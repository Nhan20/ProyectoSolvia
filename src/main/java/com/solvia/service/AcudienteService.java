/**
 * 
 */
package com.solvia.service;


/**
 * 
 */
import com.solvia.model.Acudiente;
import com.solvia.repository.AcudienteRepository;
import java.util.List;
import java.util.Optional;

/**
  * 
  */
public class AcudienteService {
	
	/**
	 * 
	 */
	private AcudienteRepository acuRepo;
	
	/**
	 * 
	 * @param aux
	 */
	public void crear(Acudiente aux) {
		acuRepo.save(aux);
	}
	
	/**
	 * 
	 * @param id
	 * @param acuNew
	 */
	public void actualizar(Long id, Acudiente acuNew) {
		Acudiente acuNow = acuRepo.findById(id).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
		acuNow.setId(id);
		acuNow.setNombre(acuNew.getNombre());
		acuNow.setCorreo(acuNew.getCorreo());
		acuNow.setTelefono(acuNew.getTelefono());
		acuRepo.save(acuNow);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Acudiente> leerTodos() {
		return acuRepo.findAll();
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Acudiente> buscarById(Long id) {
		return acuRepo.findById(id);
	}
	
	/**
	 * 
	 * @param id
	 */
	public void eliminar(Long id) {
		acuRepo.deleteById(id);
    }
}
