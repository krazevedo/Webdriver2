package com.ciandt.selenium.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.ciandt.selenium.helpers.GeradorDeNome;
import com.ciandt.selenium.helpers.Geral;
import com.ciandt.selenium.regressao.CreateCND;
import com.ciandt.selenium.regressao.TestBase;

import static org.junit.Assert.fail;

public class Passo1 extends TestBase{
	public static String nomeEspaco;
	public static String email;
	public static String[] nomeCND = new String [CreateCND.cnd];
	public static String[] emailCND = new String [CreateCND.cnd];
	GeradorDeNome nome = new GeradorDeNome();
	Geral geral = new Geral();


	public void gerarNomeEspaco(){
		geral.gerarData();
		nomeEspaco = geral.getData() + nome.gerarNome();	
		nomeCND[CreateCND.i] = Passo1.nomeEspaco;	
	}	

	public String getNomeEspaco(){
		return nomeEspaco;
	}

	public void preencheNomeEspaco() throws Exception{
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.id("virtualAddress"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		WebElement webElement = driver.findElement(By.cssSelector("div#row-espaco > div > div > fieldset > div[class*='tooltip-validacao']"));
		String a = webElement.getAttribute("class");

		for (int name = 0; name <= 3; name++){
			gerarNomeEspaco();
			driver.findElement(By.name("virtualAddress")).sendKeys(nomeEspaco);
			driver.findElement(By.id("btn-espaco")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("btn-espaco")).click();
			WebElement webElement2 = driver.findElement(By.cssSelector("div#row-espaco > div > div > fieldset > div[class*='tooltip-validacao']"));
			String b = webElement2.getAttribute("class");
			if (a.equals(b)){					
				break;
			} 
			driver.findElement(By.cssSelector("p#box-escolha-nome-do-espaco > input")).clear();
		}
	}
	
	public static String[] getCND(){
		return nomeCND;
	}

	public void preencheCPF() throws Exception{
		String cpf = geral.geraCPF();
		String formatcpf = geral.format("###.###.###-##", cpf);
		WebElement scroll = driver.findElement(By.name("virtualAddress"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);		
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div#fCpf > input#document1")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div#fCpf > input#document1")).sendKeys(formatcpf);
	}

	public void preencheDataNasc()  throws Exception{
		driver.findElement(By.cssSelector("div#fBirthday > input#birthday")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div#fBirthday > input#birthday")).sendKeys("01/01/1980");
		WebElement element = driver.findElement(By.cssSelector("div#fBirthday > input#birthday"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].focus(); arguments[0].blur(); return true", element);

	}

	public void preencheNomeCND(){
		driver.findElement(By.id("name")).sendKeys("João José");
		driver.findElement(By.id("lastname")).sendKeys("de Maná");
	}

	public void gerarEmail(){
		email = nomeEspaco + "@teste.com";	
		emailCND[CreateCND.i] = Passo1.email;	
	}

	public String getEmail(){
		return email;
	}
	public static String[] getEmailCND(){
		return emailCND;
	}

	public void preencherEmail(){
		gerarEmail();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("confirmEmail")).sendKeys(email);
	}

	public void preencherSenha(){
		driver.findElement(By.id("password")).sendKeys("inicial1");
		driver.findElement(By.id("confirmPassword")).sendKeys("inicial1");
	}

	public void preencheTelefones(){
		driver.findElement(By.cssSelector("div#fPhone > input#phone")).sendKeys("(019) 3444-4444");
		WebElement element1 = driver.findElement(By.cssSelector("div#fPhone > input#phone"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].focus(); arguments[0].blur(); return true", element1);
	}

	public void selecionarGenero() throws Exception{		 
		driver.findElement(By.cssSelector("div#fGenero > button#dropdownGenero")).sendKeys(Keys.ENTER);
		WebElement scroll = driver.findElement(By.cssSelector("div#fPhone > input#phone"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		driver.findElement(By.cssSelector("div#fGenero > ul > li:nth-child(1) > a")).click();			
	}

	public void preencherRG(){
		driver.findElement(By.id("rg")).sendKeys("2977269");
	}

	public void preencherEndereco() throws Exception{
		driver.findElement(By.cssSelector("div#fCep > input#cep")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div#fCep > input#cep")).sendKeys("13460-000");
		WebElement element = driver.findElement(By.cssSelector("div#fCep > input#cep"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].focus(); arguments[0].blur(); return true", element);
		driver.findElement(By.cssSelector("div#fNumero > input#addressNumber")).sendKeys("111");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("div#fBairro > input#addressNeighborhood")).sendKeys("bairro");
		driver.findElement(By.cssSelector("div#fLogradouro > input#street")).sendKeys("Rua");
	}

	public void selecionarCheckBoxes(){
		driver.findElement(By.cssSelector("div#fContratoFranquia > span.check-box-style")).click();
		driver.findElement(By.cssSelector("div#fTermosUso > span.check-box-style")).click();		
	}

	public void finalizaPasso() throws Exception{
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("div#btn-submit-form > button")).click();
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
