package com.economigos.economigosfiles.models;

public class Gasto {

    private Long id;
    private Categoria categoria;
    private Double valor;
    private Boolean pago;
    private String descricao;
    private String dataPagamento;

    public Gasto() {
    }

    public Gasto(Long id, Categoria categoria, Double valor, Boolean pago, String descricao, String dataPagamento) {
        this.id = id;
        this.categoria = categoria;
        this.valor = valor;
        this.pago = pago;
        this.descricao = descricao;
        this.dataPagamento = dataPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    @Override
    public String toString() {
        return "Gasto{" +
                "id=" + id +
                ", categoria=" + categoria +
                ", valor=" + valor +
                ", pago=" + pago +
                ", descricao='" + descricao + '\'' +
                ", dataPagamento='" + dataPagamento + '\'' +
                '}';
    }
}
