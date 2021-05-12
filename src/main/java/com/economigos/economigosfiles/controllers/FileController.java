package com.economigos.economigosfiles.controllers;

import com.economigos.economigosfiles.services.ContaService;
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
    ContaService contaService;

    @GetMapping("/export/{idUsuario}/{idConta}")
    @Transactional
    public void teste(@PathVariable Long idUsuario, @PathVariable Long idConta) {
        contaService.requestConta(idUsuario, idConta);
    }

}
