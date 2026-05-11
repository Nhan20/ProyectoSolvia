package com.solvia.controller;

import com.solvia.model.AuthRequest;
import com.solvia.model.Usuario;
import com.solvia.service.UsuarioService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {


	@Autowired
    private UsuarioService userServ;
    
    
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthRequest request) {
		return ResponseEntity.ok(userServ.login(request));
	}
    
    @GetMapping(path = "/get")
    public List<Usuario> obtenerTodos() {
        return userServ.obtenerTodos();
    }

//    // Obtener usuario por id
//    @GetMapping("/{id}")
//    public Usuario obtenerPorId(@PathVariable Long id) {
//        return usuarioService.obtenerPorId(id)
//                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
//    }
    
    
    
    

    /**
     * 
     * @param usuario
     * @return
     */
    @PostMapping(path = "/create")
    public ResponseEntity<String> create(@RequestBody Usuario usuario) {

        Usuario guardado = userServ.guardar(usuario);

        Usuario res = new Usuario();

        res.setId(guardado.getId());
        res.setName(guardado.getName());
        res.setEmail(guardado.getEmail());
        res.setRole(guardado.getRole());

        if (guardado == null) {
            return new ResponseEntity<String>("Ya existe", HttpStatus.NOT_ACCEPTABLE);
        } else {
            return new ResponseEntity<String>("Creado con exito", HttpStatus.OK);
        }
    }
    
    
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id,
                                             @RequestBody Usuario usuario) {

        Usuario usuarioAccion = userServ.findById(1L).orElse(null);

        Usuario actualizado = userServ.actualizarUsuario(id, usuario, usuarioAccion);

        Usuario res = new Usuario();

        res.setId(actualizado.getId());
        res.setName(actualizado.getName());
        res.setEmail(actualizado.getEmail());
        res.setRole(actualizado.getRole());

        if (actualizado == null) {
            return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
        } else {
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        boolean eliminado = userServ.eliminar(id);

        if (eliminado) {
            return ResponseEntity.ok("Usuario eliminado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }
    
    @PutMapping("/estado/{id}")
    public ResponseEntity<Usuario> cambiarEstado(@PathVariable Long id) {
        Usuario usuarioActualizado = userServ.cambiarEstado(id);
        return ResponseEntity.ok(usuarioActualizado);
    }
    
}
