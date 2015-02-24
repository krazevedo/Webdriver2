package com.ciandt.selenium.helpers;

import java.util.Random;

public class GeradorDeNome{
	public String gerarNome() {
		 
        int i, nrAleatorioVogal, nrAleatorioConsoante;
 
        String vogal[] = { "a", "e", "i", "o", "u" }, 
                voce = "", 
                nome = "", 
                consoante[] = {
                "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p",
                "q", "r", "s", "t", "w", "x", "y", "z" };
 
        Random random = new Random();
 
        for (i = 0; i <= 1; i++) {
 
            nrAleatorioVogal = 0 + random.nextInt(4); // escolhe de 0 a 4
 
            //Números reguláveis, aumentam e diminuem a quantidade de letras
 
            nrAleatorioConsoante = 0 + random.nextInt(19); // escolhe de 0 a 19
 
            voce = vogal[nrAleatorioVogal] + consoante[nrAleatorioConsoante];
 
            nome = nome + "" + voce;
 
        }
 
        return nome;
 
    }
}
