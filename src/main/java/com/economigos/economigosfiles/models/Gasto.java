package com.economigos.economigosfiles.models;

public class Gasto {

    private Long id;
    private String tipo;
    private Conta conta;
    private Categoria categoria;
    private Double valor;
    private String descricao;
    private String dataPagamento;
    private Boolean fixo;
    private Boolean pago;
    private Cartao cartao;

    public Gasto(Long id, String tipo, Conta conta, Categoria categoria, Double valor, String descricao, String dataPagamento, Boolean fixo, Boolean pago, Cartao cartao) {
        this.id = id;
        this.tipo = tipo;
        this.conta = conta;
        this.categoria = categoria;
        this.valor = valor;
        this.descricao = descricao;
        this.dataPagamento = dataPagamento;
        this.fixo = fixo;
        this.pago = pago;
        this.cartao = cartao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
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

    public Boolean getFixo() {
        return fixo;
    }

    public void setFixo(Boolean fixo) {
        this.fixo = fixo;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    @Override
    public String toString() {
        return "Gasto{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", conta=" + conta +
                ", categoria=" + categoria +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", dataPagamento='" + dataPagamento + '\'' +
                ", fixo=" + fixo +
                ", pago=" + pago +
                ", cartao=" + cartao +
                '}';
    }
}
