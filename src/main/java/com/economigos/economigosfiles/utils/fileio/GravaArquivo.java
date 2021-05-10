package com.economigos.economigosfiles.utils.fileio;

import com.economigos.economigosfiles.utils.structures.PilhaObj;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.FormatterClosedException;

public class GravaArquivo<T> {

    public void gravaLista(PilhaObj<T> lista, String nomeDoArquivo, Boolean csvFile) {
        FileWriter arquivo = null;
        String registro = "";
        String nomeDoArquivoDefault = "entregas.csv";
        boolean crashed = false;

        if (nomeDoArquivo == null) {
            nomeDoArquivo = nomeDoArquivoDefault;
        }
        if (csvFile) {
            nomeDoArquivo += ".csv";

            try {
                for (int i = 0; i < lista.getTamanho(); i++) {
                    Entrega entrega = lista.getElemento(i);
                    registro = String.format
                            ("%04d;%-20s;%-30s;%-50s;%05d;%05.2f;",
                                    entrega.getId(),
                                    entrega.getEstado(),
                                    entrega.getCidade(),
                                    entrega.getRua(),
                                    entrega.getNumero(),
                                    entrega.getDistancia()
                            );
                    gravaRegistro(nomeDoArquivo, registro);
                }
            } catch (FormatterClosedException erro) {
                System.err.println("Erro ao gravar no arquivo");
                crashed = true;
            } finally {
                try {
                    arquivo.close();
                } catch (IOException erro) {
                    System.err.println("Erro ao fechar arquivo.");
                    crashed = true;
                }
                if (crashed)
                    System.exit(1);
            }

        } else {
            nomeDoArquivo += ".txt";
            gravarTxt(nomeDoArquivo, lista);
        }

    }

    public static void gravaRegistro(String nomeArq, String registro) {

        BufferedWriter saida = null;
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        try {
            if(nomeArq.endsWith(".csv")){
                saida.append(registro);
                saida.close();
            }else{
                saida.append(registro + "\n");
                saida.close();
            }

        } catch (IOException e) {
            System.err.printf("Erro ao gravar arquivo: %s.\n", e.getMessage());
        }
    }


    public static void gravarTxt(String nomeArq, ListaObj<Entrega> entregas) {

        String header = "";
        String corpo = "";
        String trailer = "";
        int contRegDados = 0;

        Date dataDeHoje = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        header += "00ENTREGAS00189236";
        header += formatter.format(dataDeHoje);
        header += "01";
        gravaRegistro(nomeArq, header);

        for (int i = 0; i < entregas.getTamanho(); i++) {
            Entrega entrega = entregas.getElemento(i);

            corpo += "02";
            corpo += String.format("%-5d", entrega.getId());
            corpo += String.format("%-20s", entrega.getEstado());
            corpo += String.format("%-30s", entrega.getCidade());
            corpo += String.format("%-50s", entrega.getRua());
            corpo += String.format("%05d", entrega.getNumero());
            corpo += String.format("%05.2f", entrega.getDistancia());
            contRegDados++;
            gravaRegistro(nomeArq, corpo);
        }

        trailer += "01";
        trailer += String.format("%010d", contRegDados);
        gravaRegistro(nomeArq, trailer);
    }

}
