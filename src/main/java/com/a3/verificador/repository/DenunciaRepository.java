package com.a3.verificador.repository;

import com.a3.verificador.model.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {
    List<Denuncia> findByChavePix(String chavePix);
}