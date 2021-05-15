package com.economigos.economigosfiles.services;

import com.economigos.economigosfiles.dtos.UltimasAtividades;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ContabilUltimasAtividadesService {

    public UltimasAtividades requestConta(Long idUsuario, Long idConta){
        RestTemplate restTemplate = new RestTemplate();
        UltimasAtividades ultimasAtividades = restTemplate.getForObject( "http://localhost:8080" + "/economigos/contas/"+idConta+"/usuario/"+idUsuario + "/ultimas-atividades", UltimasAtividades.class);

        return ultimasAtividades;
    }

}
