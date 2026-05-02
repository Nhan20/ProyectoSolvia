/**
 * 
 */
package com.solvia.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solvia.model.AuthRequest;
import com.solvia.model.LogMovimiento;
import com.solvia.model.Usuario;
import com.solvia.repository.LogMovimientoRepository;
import com.solvia.repository.UsuarioRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.util.Date;
import java.security.Key;

/**
 * 
 */
@Service
public class UsuarioService {
	/**
	 * 
	 */
	@Autowired
	private UsuarioRepository useRepo;
	private LogMovimientoRepository logRepo;

	public Map<String, Object> login(AuthRequest request) {

		Usuario user = useRepo.findByEmail(request.getEmail())
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

		if (!user.getPassword().equals(request.getPassword())) {
			throw new RuntimeException("Contraseña incorrecta");
		}
		
		if (!user.isActivo()) {
		    throw new RuntimeException("Usuario desactivado");
		}

		String token = generarToken(user);

		return Map.of("token", token, "role", user.getRole());
	}

	public String generarToken(Usuario user) {

		String SECRET_KEY = "mi_clave_secreta_muy_larga_123456";

		Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

		return Jwts.builder().setSubject(user.getEmail()).claim("role", user.getRole()).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)).signWith(key).compact();
	}

	public Usuario cambiarEstado(Long id) {
	    Usuario usuario = useRepo.findById(id)
	        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

	    usuario.setActivo(!usuario.isActivo());

	    return useRepo.save(usuario);
	}
	
	/**
	 * 
	 * @param aux
	 */
	public Usuario guardar(Usuario aux) {
		aux.setActivo(true);
		Usuario temp = useRepo.save(aux);

		LogMovimiento log = new LogMovimiento();
		log.setAccion("CREAR_USUARIO");
		log.setDescripcion("Se creó el usuario: " + temp.getId() + " , con rol: " + temp.getRole());

		logRepo.save(log);

		return temp;
	}

	public List<Usuario> obtenerTodos() {
		return useRepo.findAll();

	}

	public Optional<Usuario> findById(Long cod) {
		return useRepo.findById(cod);
	}

	public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado, Usuario usuarioAccion) {

		Usuario usuario = useRepo.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

		// Guardamos valores anteriores (para log)
		String nombreAnterior = usuario.getName();
		String rolAnterior = usuario.getRole();

		// Actualizamos solo lo permitido
		usuario.setName(usuarioActualizado.getName());
		usuario.setRole(usuarioActualizado.getRole());

		Usuario actualizado = useRepo.save(usuario);

		// Registrar movimiento
		LogMovimiento log = new LogMovimiento();
		log.setAccion("ACTUALIZAR_USUARIO");
		log.setDescripcion("Usuario actualizado. Nombre: " + nombreAnterior + " -> " + actualizado.getName() + ", Rol: "
				+ rolAnterior + " -> " + actualizado.getRole());
		log.setUsuario(usuarioAccion);

		logRepo.save(log);

		return actualizado;
	}

	public boolean eliminar(Long id) {
		if (useRepo.existsById(id)) {
			useRepo.deleteById(id);

			LogMovimiento log = new LogMovimiento();
			log.setAccion("ELIMINAR_USUARIO");
			log.setDescripcion("Se eliminó el usuario con el id: " + id);
			logRepo.save(log);

			return true;
		}
		return false;
	}

}
