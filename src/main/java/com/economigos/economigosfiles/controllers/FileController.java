package com.economigos.economigosfiles.controllers;

import com.economigos.economigosfiles.models.ContabilUltimasAtividades;
import com.economigos.economigosfiles.models.UltimasAtividades;
import com.economigos.economigosfiles.services.ContabilUltimasAtividadesService;
import com.economigos.economigosfiles.utils.fileio.GravaArquivo;
import com.economigos.economigosfiles.utils.structures.PilhaObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/economigos/files")
public class FileController {

    @Autowired
    ContabilUltimasAtividadesService contabilUltimasAtividadesService;

    @GetMapping("/export/{idUsuario}/{idConta}")
    @Transactional
    public ResponseEntity<Resource> getExtrato(@PathVariable Long idUsuario, @PathVariable Long idConta, @RequestParam Boolean csvFile) throws FileNotFoundException {
        UltimasAtividades ultimasAtividades = contabilUltimasAtividadesService.requestConta(idUsuario, idConta);

        List<ContabilUltimasAtividades> atividadesList = ultimasAtividades.getContabilUltimasAtividadesDtos();

        int tamanhoRetorno = atividadesList.size();

        Collections.sort(atividadesList);

        PilhaObj<ContabilUltimasAtividades> ultimasAtividadesPilhaObj = new PilhaObj<>(tamanhoRetorno);

        String fileName = "extrato";

        if (tamanhoRetorno > 0) {
            for (ContabilUltimasAtividades contabilUltimasAtividades : atividadesList) {
                ultimasAtividadesPilhaObj.push(contabilUltimasAtividades);
            }
            try {
                GravaArquivo.gravaPilha(ultimasAtividadesPilhaObj, fileName, csvFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            InputStreamResource resource = new InputStreamResource(new FileInputStream(GravaArquivo.getFile()));

            if (GravaArquivo.getFile().getName().endsWith(".csv")){
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName + ".csv")
                        .contentType(MediaType.parseMediaType("application/csv"))
                        .body(resource);
            }else{
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName + ".txt")
                        .contentType(MediaType.parseMediaType("application/txt"))
                        .body(resource);
            }
        }

        return ResponseEntity.badRequest().build();
    }

}
