package com.ciandt.selenium.regressao;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.helpers.DataDriven;
import com.ciandt.selenium.helpers.Geral;
import com.ciandt.selenium.pages.Entrega;
import com.ciandt.selenium.pages.FinalizarCompra;
import com.ciandt.selenium.pages.HomeEspaco;
import com.ciandt.selenium.pages.Identificacao;

public class BuyProducts extends TestBase{
	Geral geral = new Geral();
	Entrega entrega = new Entrega();
	HomeEspaco home = new HomeEspaco();
	FinalizarCompra finalizar = new FinalizarCompra();
	Identificacao identificacao = new Identificacao();
	DataDriven properties = new DataDriven();
	public StringBuffer verificationErrors = new StringBuffer();	
	

	@Test
	public void cadastrarCliente() throws Exception {
		properties.lerArquivo();
		home.cadastrarCliente(properties.getProperties().getProperty("espaco"));
		identificacao.minhaPrimeiraCompra();
		home.validarClienteLogado();			
		home.completarCadastro();
		identificacao.completarCadastroSemPedido();
	}

	@Test
	public void comprarProdutoClienteExistente() throws Exception {
		properties.lerArquivo();
		home.realizarLogin(properties.getProperties().getProperty("espaco"), properties.getProperties().getProperty("login"), properties.getProperties().getProperty("password"));
		home.validarClienteLogado();
		home.incluirProdutoSacola(properties.getProperties().getProperty("espaco"));
		entrega.confirmarEndereco();
		finalizar.finalizarCompra();
	}

	@Test
	public void comprarVariosProdutosClienteExistente() throws Exception {
		properties.lerArquivo();
		home.realizarLogin(properties.getProperties().getProperty("espaco"), properties.getProperties().getProperty("login"), properties.getProperties().getProperty("password"));
		home.validarClienteLogado();
		home.incluirProdutoSacola(properties.getProperties().getProperty("espaco"));
		home.incluirMaisProdutosSacola(properties.getProperties().getProperty("espaco"));
		entrega.confirmarEndereco();
		finalizar.finalizarCompra();
	}

	@Test
	public void comprarProdutoClienteNovo() throws Exception {
		properties.lerArquivo();
		home.cadastrarCliente(properties.getProperties().getProperty("espaco"));
		identificacao.minhaPrimeiraCompra();
		home.validarClienteLogado();
		home.incluirProdutoSacola(properties.getProperties().getProperty("espaco"));
		identificacao.completarCadastroComPedido();
		entrega.preencheEndereco();
		entrega.confirmarEndereco();
		finalizar.finalizarCompra();
	}

	@Test
	public void comprarVariosProdutosClienteNovo() throws Exception {
		properties.lerArquivo();
		home.cadastrarCliente(properties.getProperties().getProperty("espaco"));
		identificacao.minhaPrimeiraCompra();
		home.validarClienteLogado();
		home.incluirProdutoSacola(properties.getProperties().getProperty("espaco"));
		home.incluirMaisProdutosSacola(properties.getProperties().getProperty("espaco"));
		identificacao.completarCadastroComPedido();
		entrega.preencheEndereco();
		entrega.confirmarEndereco();
		finalizar.finalizarCompra();
	}

	@Test
	public void abandonarSacola() throws Exception {
		properties.lerArquivo();
		home.cadastrarCliente(properties.getProperties().getProperty("espaco"));
		identificacao.minhaPrimeiraCompra();
		home.validarClienteLogado();
		home.incluirProdutoSacola(properties.getProperties().getProperty("espaco"));
	}

	@After
	public void tearDown(){
		String verificationErrorString = home.verificationErrors.toString();
		String verificationErrorString2 = identificacao.verificationErrors.toString();
		String verificationErrorString3 = entrega.verificationErrors.toString();
		String verificationErrorString4 = finalizar.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
		if (!"".equals(verificationErrorString2)) {
			fail(verificationErrorString2);
		}
		if (!"".equals(verificationErrorString3)) {
			fail(verificationErrorString3);
		}
		if (!"".equals(verificationErrorString4)) {
			fail(verificationErrorString4);
		}
		driver.quit();
	}


}
