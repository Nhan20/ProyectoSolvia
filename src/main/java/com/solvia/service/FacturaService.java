/**
 * 
 */
package com.solvia.service;

import com.solvia.model.Factura;
import com.solvia.repository.FacturaRepository;

/**
 * 
 */
public class FacturaService {
	/**
	 * 
	 */
	private FacturaRepository facRepo;
	
	/**
	 * 
	 * @param aux
	 */
	public void guardar (Factura aux) {
		facRepo.save(aux);
	}

}
