package com.economigos.economigosfiles.services;

import com.economigos.economigosfiles.models.Conta;
import org.springframework.web.client.RestTemplate;

public class ContaService {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        Conta conta = restTemplate.getForObject( "http://localhost:8080" + "/economigos/contas/1/usuario/1", Conta.class);
        System.out.println(conta.toString());
    }
}
