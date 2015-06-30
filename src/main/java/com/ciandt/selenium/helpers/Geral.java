package com.ciandt.selenium.helpers;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.MaskFormatter;

import org.openqa.selenium.WebDriver;

public class Geral{
	public String data;
	public String dataHora;
	

	public void abrirCadastro(WebDriver driver){
		driver.get("http://cadastrohml.rede.natura.net/cadastro");
		/*driver.get("http://alfeu:7009/cadastro");*/
	}

	public void abrirATG(WebDriver driver){
		driver.get("http://content-staging2.rede.natura.net/atg/bcc");		
	}
	
	public void abrirPainel(WebDriver driver){
		driver.get("http://wcsbiostaginghml.natura.net/cs/Satellite?c=Page&pagename=NAT/Wrapper&isAdminLogin=true&isAdmin=true");
	}
	
	public void abrirEspaco(WebDriver driver){
		driver.get("http://staging2.rede.natura.net/espaco/0112emepon");
	}

	public void gerarData(){
		Date date = new Date() ;
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMM");
		data = dateFormat.format(date);		
	}	

	public String getData(){
		return data;
	}

	public void pegarHora(){
		Date date = new Date() ;
		SimpleDateFormat dateFormatHr = new SimpleDateFormat("HH-mm");
		dataHora = dateFormatHr.format(date);		
	}

	public String getHora(){
		return dataHora;
	}

	private static String calcDigVerif(String num) {    

		Integer primeiroDigito; 
		Integer segundoDigito;    
		int soma = 0; 
		int peso = 10; 

		for (int i = 0; i < num.length(); i++)    
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;    

		if (soma % 11 == 0 | soma % 11 == 1)    
			primeiroDigito = new Integer(0);    
		else   
			primeiroDigito = new Integer(11 - (soma % 11));    

		soma = 0;    
		peso = 11; 

		for (int i = 0; i < num.length(); i++)    
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;    

		soma += primeiroDigito.intValue() * 2;    
		if (soma % 11 == 0 | soma % 11 == 1)    
			segundoDigito = new Integer(0);    
		else   
			segundoDigito = new Integer(11 - (soma % 11));    

		return primeiroDigito.toString() + segundoDigito.toString();    
	}

	public String geraCPF() {   

		String iniciais = "";    
		Integer numero;  

		for (int i = 0; i < 9; i++) {    
			numero = new Integer((int) (Math.random() * 10));    
			iniciais += numero.toString();    
		}    
		return iniciais + calcDigVerif(iniciais);    
	} 

	public static boolean validaCPF(String cpf) {    
		if (cpf.length() != 11)    
			return false;    

		String numDig = cpf.substring(0, 9);    
		return calcDigVerif(numDig).equals(cpf.substring(9, 11));    
	} 
	
	public String format(String pattern, Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
