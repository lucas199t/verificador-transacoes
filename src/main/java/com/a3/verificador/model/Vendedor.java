package com.a3.verificador.model;

import jakarta.persistence.*;

@Entity
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String documento;
    private String email;    // Novo campo
    private String senha;    // Novo campo
    private boolean verificado;

    // Getters e setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isVerificado() {
        return verificado;
    }
    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }
}
