/**
 * 
 */
package com.solvia.service;

import com.solvia.model.Estudiante;
import com.solvia.repository.EstudianteRepository;

/**
 * 
 */
public class EstudianteService {
	/**
	 * 
	 */
	private EstudianteRepository esRepo;
	
	/**
	 * 
	 * @param aux
	 */
	public void guardar (Estudiante aux) {
		esRepo.save(aux);
	}
}
