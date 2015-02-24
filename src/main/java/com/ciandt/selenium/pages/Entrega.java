package com.ciandt.selenium.pages;

import org.openqa.selenium.By;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.ciandt.selenium.regressao.TestBase;

public class Entrega extends TestBase{
	public StringBuffer verificationErrors = new StringBuffer();

	public void preencheEndereco() throws Exception{
		driver.get("https://s.staging2.rede.natura.net/minha-sacola"); 
		driver.findElement(By.id("delivery-address-number")).click();
		driver.findElement(By.id("delivery-address-number")).clear();
		driver.findElement(By.id("delivery-address-number")).sendKeys("3221");
		WebElement scroll = driver.findElement(By.id("delivery-receiver-phone"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(500); 
		driver.findElement(By.cssSelector("label.custom-radio.normal")).click();
		driver.findElement(By.cssSelector("a.btn-continue-delivery.ir")).click();		
	}

	public void confirmarEndereco() throws Exception{
		driver.get("https://s.staging2.rede.natura.net/minha-sacola");
		Thread.sleep(4000);
		driver.findElement(By.id("normal-delivery-mode")).click();
		driver.findElement(By.linkText("Entregar neste endereço")).click();

	}

}
