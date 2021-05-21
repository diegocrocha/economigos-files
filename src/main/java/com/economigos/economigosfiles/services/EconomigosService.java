package com.economigos.economigosfiles.services;

import com.economigos.economigosfiles.dtos.CategoriaDto;
import com.economigos.economigosfiles.dtos.ContaDto;
import com.economigos.economigosfiles.dtos.UltimasAtividades;
import com.economigos.economigosfiles.form.GastoForm;
import com.economigos.economigosfiles.form.RendaForm;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EconomigosService {

    public static UltimasAtividades requestContaById(Long idUsuario, Long idConta){
        RestTemplate restTemplate = new RestTemplate();
        UltimasAtividades ultimasAtividades = restTemplate.getForObject( "http://localhost:8080" + "/economigos/contas/"+idConta+"/ultimas-atividades?idUsuario="+idUsuario, UltimasAtividades.class);

        return ultimasAtividades;
    }

    public static ContaDto requestContaByApelido(String contaApelido){
        RestTemplate restTemplate = new RestTemplate();
        ContaDto contaDto = restTemplate.getForObject( "http://localhost:8080" + "/economigos/contas/conta?apelido="+contaApelido.trim(), ContaDto.class);

        return contaDto;
    }

    public static CategoriaDto requestCategoriaByNome(String categoriaNome){
        RestTemplate restTemplate = new RestTemplate();
        CategoriaDto categoriaDto = restTemplate.getForObject( "http://localhost:8080" + "/economigos/categorias/categoria?categoriaNome="+categoriaNome.trim(), CategoriaDto.class);

        return categoriaDto;
    }

    public static Boolean createRenda(RendaForm renda) {
        try {
            new RestTemplate().postForObject("http://localhost:8080/economigos/rendas", renda, RendaForm.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Boolean createGasto(GastoForm gasto) {
        try {
            new RestTemplate().postForObject("http://localhost:8080/economigos/gastos", gasto, GastoForm.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
