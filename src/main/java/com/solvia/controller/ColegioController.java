/**
 * 
 */
package com.solvia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * 
 */
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.solvia.model.Colegio;
import com.solvia.service.ColegioService;

/**
 * 
 */
@RestController
@RequestMapping("/api/colegios")
@CrossOrigin(origins = "http://localhost:5173")
public class ColegioController {

	@Autowired
	private ColegioService colServi;

	@GetMapping(path = "/get")
	public List<Colegio> obtenerTodos() {
		return colServi.listarColegios();
	}

	@PostMapping(path = "/create")
	public ResponseEntity<String> create(@RequestBody Colegio colegio) {
		
		System.out.println("Se empezo a crear el colegio");
		System.out.println("Se empezo a crear el colegio");

		Colegio guardado = colServi.crear(colegio);

		if (guardado == null) {
			return new ResponseEntity<>("Ya existe un colegio con ese NIT", HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<>("Colegio creado con éxito", HttpStatus.OK);
		}
	}

	@PutMapping(path = "/update/{id}")
	public ResponseEntity<Colegio> update(@PathVariable Long id, @RequestBody Colegio colegio) {

		Colegio actualizado = colServi.actualizar(id, colegio);

		if (actualizado == null) {
			return new ResponseEntity<>(actualizado, HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<>(actualizado, HttpStatus.OK);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {

		boolean eliminado = colServi.eliminar(id);

		if (eliminado) {
			return ResponseEntity.ok("Colegio eliminado");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colegio no encontrado");
		}
	}

}
