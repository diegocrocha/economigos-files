package com.economigos.economigosfiles.models;

import java.util.List;

public class Conta {

    private Long id;
    private String banco;
    private String numeroConta;
    private String descricao;
    private String apelido;
    private Double valorAtual;
    private Usuario usuario;
    private List<Renda> rendas;
    private List<Gasto> gastos;

    public Conta(Long id, String banco, String numeroConta, String descricao, String apelido, Double valorAtual, Usuario usuario, List<Renda> rendas, List<Gasto> gastos) {
        this.id = id;
        this.banco = banco;
        this.numeroConta = numeroConta;
        this.descricao = descricao;
        this.apelido = apelido;
        this.valorAtual = valorAtual;
        this.usuario = usuario;
        this.rendas = rendas;
        this.gastos = gastos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(Double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Renda> getRendas() {
        return rendas;
    }

    public void setRendas(List<Renda> rendas) {
        this.rendas = rendas;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }
}
