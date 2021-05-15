package com.economigos.economigosfiles.models;

import javax.persistence.*;

@Entity
public class Anexo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(length = 500_000)
    private byte[] header;
    @Column(length = 500_000)
    private byte[] body;
    @Column(length = 500_000)
    private byte[] trailer;

    public Anexo() {
    }

    public Anexo(String nome, byte[] header, byte[] body, byte[] trailer) {
        this.nome = nome;
        this.header = header;
        this.body = body;
        this.trailer = trailer;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getHeader() {
        return header;
    }

    public void setHeader(byte[] header) {
        this.header = header;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public byte[] getTrailer() {
        return trailer;
    }

    public void setTrailer(byte[] trailer) {
        this.trailer = trailer;
    }
}
