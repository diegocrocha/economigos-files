package com.economigos.economigosfiles.models;

public class Renda {

    private Long id;
    private Double valor;
    private Boolean recebido;
    private String descricao;

    public Renda() {
    }

    public Renda(Long id, Double valor, Boolean recebido, String descricao) {
        this.id = id;
        this.valor = valor;
        this.recebido = recebido;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getRecebido() {
        return recebido;
    }

    public void setRecebido(Boolean recebido) {
        this.recebido = recebido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Renda{" +
                "id=" + id +
                ", valor=" + valor +
                ", recebido=" + recebido +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
