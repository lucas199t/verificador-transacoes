package com.a3.verificador.repository;

import com.a3.verificador.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
    Optional<Vendedor> findByEmail(String email);
}
