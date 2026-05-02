/**
 * 
 */
package com.solvia.repository;

import java.util.Optional;

/**
 * 
 */
import org.springframework.data.jpa.repository.JpaRepository;
import com.solvia.model.Colegio;

/**
 * 
 */
public interface ColegioRepository extends JpaRepository<Colegio, Long>{
	Optional<Colegio> findByNit(String nit);
	boolean existsByNit(String nit);
}
