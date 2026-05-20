/**
 * 
 */
package com.solvia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 */
import com.solvia.model.Colegio;
import com.solvia.repository.ColegioRepository;

/**
 * 
 */
@Service
public class ColegioService {

	/**
	 * 
	 */
	@Autowired
	private ColegioRepository coRepo;

	/**
	 * 
	 * @param aux
	 */
	public Colegio crear(Colegio aux) {
		if (coRepo.findByNit(aux.getNit()).isPresent()) {
			throw new RuntimeException("Ya existe un colegio con ese NIT");
		}
		return coRepo.save(aux);
	}

	public List<Colegio> listarColegios() {
		return coRepo.findAll();
	}

	/**
	 * 
	 * @param id
	 * @param acuNew
	 */
	public Colegio actualizar(Long id, Colegio coleNew) {
		Colegio existente = coRepo.findById(id).orElseThrow(() -> new RuntimeException("Colegio no encontrado"));

		existente.setNombre(coleNew.getNombre());
		existente.setNit(coleNew.getNit());
		existente.setDireccion(coleNew.getDireccion());
		existente.setTelefono(coleNew.getTelefono());

		return coRepo.save(existente);
	}

	public boolean eliminar(Long id) {
		if (!coRepo.existsById(id)) {
			return false;
		}
		coRepo.deleteById(id);
		return true;
	}

}
