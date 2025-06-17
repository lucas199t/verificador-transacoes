package com.a3.verificador.repository;

import com.a3.verificador.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByChavePix(String chavePix);
}
