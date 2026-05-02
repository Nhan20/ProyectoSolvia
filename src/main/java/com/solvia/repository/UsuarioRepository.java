package com.solvia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solvia.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByEmail(String email);
}
