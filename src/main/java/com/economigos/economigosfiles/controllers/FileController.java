package com.economigos.economigosfiles.controllers;

import com.economigos.economigosfiles.models.UltimasAtividades;
import com.economigos.economigosfiles.services.ContabilUltimasAtividadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/economigos/files")
public class FileController {

    @Autowired
    ContabilUltimasAtividadesService contabilUltimasAtividadesService;

    @GetMapping("/export/{idUsuario}/{idConta}")
    @Transactional
    public void teste(@PathVariable Long idUsuario, @PathVariable Long idConta) {
        UltimasAtividades ultimasAtividades = contabilUltimasAtividadesService.requestConta(idUsuario, idConta);
    }

}
