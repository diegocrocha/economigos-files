package com.economigos.economigosfiles.utils.fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LeArquivo {

    public static void leArquivo(FileReader arquivo) {
        BufferedReader entrada = new BufferedReader(arquivo);

        String leitura;
        String tipoRegistro;
        String registro, valor, data;
        int contRegistro=0;

        try {
            leitura = entrada.readLine();

            while (leitura != null) {
                tipoRegistro = leitura.substring(0, 2); // obtém os 2 primeiros caracteres do leitura

                if (tipoRegistro.equals("00")) {
                    System.out.println("Header");
                    System.out.println("Tipo de arquivo: " + leitura.substring(2, 9));
                    int dataGerado= Integer.parseInt(leitura.substring(9,28));
                    System.out.println("Data gerado: " + dataGerado);
                    System.out.println("Versão do layout: " + leitura.substring(28,30));
                }
                else if (tipoRegistro.equals("01")) {
                    System.out.println("\nTrailer");
                    int qtdRegistro = Integer.parseInt(leitura.substring(2,5));
                    if (qtdRegistro == contRegistro) {
                        System.out.println("Quantidade de leituras gravados compatível com quantidade lida");
                    }
                    else {
                        System.out.println("Quantidade de leituras gravados não confere com quantidade lida");
                    }
                }
                else if (tipoRegistro.equals("02") || tipoRegistro.equals("03")) {

                    registro = leitura.substring(2,7);
                    valor = leitura.substring(7,17);
                    data = leitura.substring(17,36);

                    contRegistro++;
                }
                else {
                    System.out.println("Tipo de leitura inválido");
                }
                leitura = entrada.readLine();
            }

            entrada.close();
        } catch (IOException e) {
            System.err.printf("Erro ao ler arquivo: %s.\n", e.getMessage());
        }

    }
}