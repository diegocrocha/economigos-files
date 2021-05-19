package com.economigos.economigosfiles.controllers;

import com.economigos.economigosfiles.dtos.ContabilUltimasAtividades;
import com.economigos.economigosfiles.dtos.UltimasAtividades;
import com.economigos.economigosfiles.models.Anexo;
import com.economigos.economigosfiles.repositories.AnexoRepository;
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
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/economigos/files")
public class FileController {

    @Autowired
    ContabilUltimasAtividadesService contabilUltimasAtividadesService;
    @Autowired
    AnexoRepository anexoRepository;

    @GetMapping("/export/{idUsuario}/{idConta}")
    @Transactional
    public ResponseEntity<Resource> getExtrato(@PathVariable Long idUsuario,
                                               @PathVariable Long idConta,
                                               @RequestParam Boolean csvFile) throws FileNotFoundException {
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

    @PostMapping("/import")
    @Transactional
    public ResponseEntity<String> importart(@RequestParam MultipartFile arquivo) throws IOException {
        if(!arquivo.isEmpty()){
            Anexo anexo = new Anexo(arquivo.getOriginalFilename(), "01".getBytes(), arquivo.getBytes(), "02".getBytes());
            anexoRepository.save(anexo);

            return ResponseEntity.ok().body("Arquivo guardado.");
        }else{
            return ResponseEntity.badRequest().body("Arquivo vazio.");
        }
    }

}
