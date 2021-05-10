package com.economigos.economigosfiles.models;

import java.time.LocalDateTime;
import java.util.List;

public class Usuario {

    private Long id;
    private String email;
    private String senha;
    private List<Conta> contas;
    private List<Cartao> cartoes;
    private LocalDateTime dataCriacao;

    public Usuario(Long id, String email, String senha, List<Conta> contas, List<Cartao> cartoes, LocalDateTime dataCriacao) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.contas = contas;
        this.cartoes = cartoes;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<Cartao> cartoes) {
        this.cartoes = cartoes;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
