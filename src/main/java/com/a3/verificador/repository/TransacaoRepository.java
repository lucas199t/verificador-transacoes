package com.a3.verificador.repository;

import com.a3.verificador.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByChavePix(String chavePix);
}