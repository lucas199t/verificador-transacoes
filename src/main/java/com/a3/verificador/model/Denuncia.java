package com.a3.verificador.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String chavePix;
    private String motivo;
    private LocalDateTime data;

    public Long getId() {
        return id;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}