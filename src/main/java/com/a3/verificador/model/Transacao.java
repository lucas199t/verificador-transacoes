package com.a3.verificador.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String chavePix;
    private Double valor;
    private LocalDateTime data;
    private boolean confiavel;

    public Long getId() {
        return id;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public boolean isConfiavel() {
        return confiavel;
    }

    public void setConfiavel(boolean confiavel) {
        this.confiavel = confiavel;
    }
}