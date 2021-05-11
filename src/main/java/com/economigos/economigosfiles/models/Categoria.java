package com.economigos.economigosfiles.models;

import java.util.List;

public class Categoria {

    private Long id;
    private String categoria;
    private List<Gasto> gastos;
    private List<Renda> rendas;

    public Categoria(Long id, String categoria, List<Gasto> gastos, List<Renda> rendas) {
        this.id = id;
        this.categoria = categoria;
        this.gastos = gastos;
        this.rendas = rendas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public List<Renda> getRendas() {
        return rendas;
    }

    public void setRendas(List<Renda> rendas) {
        this.rendas = rendas;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                ", gastos=" + gastos +
                ", rendas=" + rendas +
                '}';
    }
}
