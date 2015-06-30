package com.ciandt.selenium.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.ciandt.selenium.helpers.GeradorDeNome;
import com.ciandt.selenium.helpers.Geral;
import com.ciandt.selenium.regressao.TestBase;

public class Identificacao extends TestBase{
	public String data;
	public static String email;
	public static String pass = "inicial1";
	public StringBuffer verificationErrors = new StringBuffer();
	GeradorDeNome nome = new GeradorDeNome();
	Geral geral = new Geral();
	
	

	public void gerarEmail(){
		geral.gerarData();
		email = geral.getData() + nome.gerarNome() + "@teste.com.br";		
	}	

	public String getEmail(){
		return email;
	}

	public void minhaPrimeiraCompra() throws Exception{
		gerarEmail();
		driver.findElement(By.cssSelector("label.custom-radio.show-first-buy")).click();
		driver.findElement(By.id("field-identification-email")).clear();
		driver.findElement(By.id("field-identification-email")).sendKeys(email);		
		driver.findElement(By.id("cep")).click();
		driver.findElement(By.id("cep")).clear();
		driver.findElement(By.id("cep")).sendKeys("26130-530");
		driver.findElement(By.id("new-name")).clear();
		driver.findElement(By.id("new-name")).sendKeys("Teste");
		driver.findElement(By.id("new-password")).clear();
		driver.findElement(By.id("new-password")).sendKeys(pass);
		driver.findElement(By.cssSelector("input#accept-terms")).sendKeys("");
		driver.findElement(By.cssSelector("input#accept-terms")).click();
		driver.findElement(By.id("new-name")).sendKeys(Keys.ENTER);	

	}

	public void completarCadastroComPedido() throws Exception{
		driver.get("https://s.staging2.rede.natura.net/checkout-v2/register/");
		Thread.sleep(4000);
		
		SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 5); // Adding 5 days
		String day = dayFormat.format(c.getTime());
		
		Date mes = new Date();
		SimpleDateFormat mesFormat = new SimpleDateFormat("MM");
		String month = mesFormat.format(mes);
		
		String cpf = geral.geraCPF();
		driver.findElement(By.id("cpf")).clear();
		driver.findElement(By.id("cpf")).sendKeys(cpf);
		driver.findElement(By.id("rg")).clear();
		driver.findElement(By.id("rg")).sendKeys("321231");
		WebElement scroll = driver.findElement(By.id("nome"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(500); 
		driver.findElement(By.id("sobrenome")).clear();
		driver.findElement(By.id("sobrenome")).sendKeys("CIT");
		driver.findElement(By.id("dt-nascimento")).clear();		
		driver.findElement(By.id("dt-nascimento")).sendKeys(day + month + "/1980");
		WebElement radioBtn = driver.findElement(By.id("male-radio"));
		radioBtn.click();
		driver.findElement(By.id("ddd-phone1")).clear();
		driver.findElement(By.id("ddd-phone1")).sendKeys("19");
		driver.findElement(By.id("phone1")).clear();
		driver.findElement(By.id("phone1")).sendKeys("3466-6666");	
		WebElement scroll2 = driver.findElement(By.id("email-natura"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll2);
		Thread.sleep(500); 
		driver.findElement(By.id("password-natura")).sendKeys("inicial1");
		driver.findElement(By.id("password-natura-repeat")).sendKeys("inicial1");
		driver.findElement(By.id("update-user")).click();
		Thread.sleep(5000);		
	}
	
	
	public void completarCadastroSemPedido() throws Exception{
		SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 5); // Adding 5 days
		String day = dayFormat.format(c.getTime());
		
		Date mes = new Date();
		SimpleDateFormat mesFormat = new SimpleDateFormat("MM");
		String month = mesFormat.format(mes); 
		
		String cpf = geral.geraCPF();
	    driver.findElement(By.id("cpf")).clear();
	    driver.findElement(By.id("cpf")).sendKeys(cpf);
	    driver.findElement(By.id("rg")).clear();
	    driver.findElement(By.id("rg")).sendKeys("3334456");
	    driver.findElement(By.id("surname")).clear();
	    driver.findElement(By.id("surname")).sendKeys("CIT");
	    driver.findElement(By.id("birthdate")).clear();
	    driver.findElement(By.id("birthdate")).sendKeys(day + month + "/1980");
	    driver.findElement(By.id("gender-male")).click();
	    driver.findElement(By.id("ddd-phone1")).clear();
	    driver.findElement(By.id("ddd-phone1")).sendKeys("19");
	    driver.findElement(By.id("phone1")).clear();
	    driver.findElement(By.id("phone1")).sendKeys("3466-4646");
	    driver.findElement(By.id("ddd-phone2")).clear();
	    driver.findElement(By.id("ddd-phone2")).sendKeys("19");
	    driver.findElement(By.id("phone2")).clear();
	    driver.findElement(By.id("phone2")).sendKeys("9999-4646");
	    WebElement scroll2 = driver.findElement(By.id("phone1"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll2);
		Thread.sleep(500); 
	    driver.findElement(By.linkText("salvar alterações")).click();
	    Thread.sleep(2000);
	}
}
