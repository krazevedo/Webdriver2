package com.ciandt.selenium.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.ciandt.selenium.regressao.TestBase;

public class HomeEspaco extends TestBase{
	
	public StringBuffer verificationErrors = new StringBuffer();

	public void cadastrarCliente(String nomeEspaco){
		driver.get("https://s.staging2.rede.natura.net/identifique-se?contextURL=http%3A%2F%2Fstaging2.rede.natura.net%2Fespaco%2F" + nomeEspaco);
	}

	public void realizarLogin(String nomeEspaco, String user, String pass) throws Exception{
		driver.get("https://s.staging2.rede.natura.net/espaco/" + nomeEspaco);
		Thread.sleep(4000);
		driver.findElement(By.linkText("Olá visitante, identifique-se aqui")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("login-form-email")).clear();
		driver.findElement(By.id("login-form-email")).sendKeys(user);
		driver.findElement(By.cssSelector("div.form-text > input[name=\"password\"]")).clear();
		driver.findElement(By.cssSelector("div.form-text > input[name=\"password\"]")).sendKeys(pass);
		driver.findElement(By.cssSelector("input.btn-entrar")).click();
	}

	public void completarCadastro(){
		driver.get("https://s.staging2.rede.natura.net/minha-conta");
	}

	public void validarClienteLogado(){
		assertEquals("Teste", driver.findElement(By.cssSelector("span.logged-user-name")).getText());
	}

	public void incluirProdutoSacola(String nomeEspaco) throws Exception{
		driver.get("http://staging2.rede.natura.net/espaco/" + nomeEspaco + "/nossos-produtos/kaiak-a7/desodorantes-b32");
		Thread.sleep(4000);
		WebElement scroll = driver.findElement(By.cssSelector("div#products-navigation-menu.text-color > h3"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(500); 
		driver.findElement(By.cssSelector("button.button.enabled > strong")).submit();	
		Thread.sleep(4000);
	}
	
	public void incluirMaisProdutosSacola(String nomeEspaco) throws Exception{
		driver.get("http://staging2.rede.natura.net/espaco/" + nomeEspaco + "/nossos-produtos/ekos-a1/castanha-b4/corpo-c15");
		Thread.sleep(4000);
		WebElement scroll = driver.findElement(By.cssSelector("div#products-navigation-menu.text-color > h3"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(500); 
		driver.findElement(By.cssSelector("button.button.enabled > strong")).submit();	
		Thread.sleep(4000);
		driver.get("http://staging2.rede.natura.net/espaco/" + nomeEspaco + "/nossos-produtos/mamae-e-bebe-a13/momento-banho-b60");
		Thread.sleep(4000);
		WebElement scroll2 = driver.findElement(By.cssSelector("div#products-navigation-menu.text-color > h3"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll2);
		Thread.sleep(500); 
		driver.findElement(By.cssSelector("button.button.enabled > strong")).submit();
		Thread.sleep(4000);
	}

}
