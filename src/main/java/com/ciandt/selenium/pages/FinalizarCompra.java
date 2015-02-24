package com.ciandt.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.ciandt.selenium.regressao.TestBase;

public class FinalizarCompra extends TestBase{
	public StringBuffer verificationErrors = new StringBuffer();

	public void finalizarCompra() throws Exception{
		Thread.sleep(5000);
		WebElement scroll = driver.findElement(By.cssSelector("td.last.saleslist-totalprice"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(500); 
		driver.findElement(By.cssSelector("div.pushcart-tab-salesinfo-submit > a.button-replace.continue-btn-mycart.button-finish-order")).click();
		Thread.sleep(4000);
		driver.findElement(By.linkText("boleto bancário")).click();
		driver.findElement(By.linkText("Fazer compra com boleto bancário")).click();
		driver.findElement(By.id("boletoLink")).click();
	}
}
