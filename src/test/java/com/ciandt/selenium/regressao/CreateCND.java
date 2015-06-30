package com.ciandt.selenium.regressao;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.helpers.Geral;
import com.ciandt.selenium.pages.Finalizado;
import com.ciandt.selenium.pages.Passo1;
import com.ciandt.selenium.pages.Passo2;

public class CreateCND extends TestBase{
	Geral geral = new Geral();
	Passo1 passo1 = new Passo1();
	Passo2 passo2 = new Passo2();
	Finalizado finalizado = new Finalizado();
	public StringBuffer verificationErrors = new StringBuffer();
	public static Integer cnd = 5;
	public static Integer i;

	@Test
	public void testUntitled() throws Exception {

		for (i = 0; i < cnd ; i++){
			geral.abrirCadastro(driver);
			passo1.preencheNomeEspaco();
			passo1.preencheCPF();
			passo1.preencheDataNasc();
			passo1.preencheNomeCND();
			passo1.preencherEmail();
			passo1.preencherSenha();
			passo1.preencheTelefones();
			passo1.preencherRG();			
			passo1.selecionarGenero();
			passo1.preencherEndereco();
			passo1.selecionarCheckBoxes();
			passo1.finalizaPasso();
			passo2.verificarPasso2();
			passo2.preencherNomeTitular();
			passo2.preencherNumeroCartao();
			passo2.preencherDataExpiracao();
			passo2.selecionarCheckBoxes();
			passo1.finalizaPasso();
			finalizado.verificarPaginaFinalizado();			
		}				
	}



	@After
	public void tearDown(){
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
		driver.quit();
	}	
}
