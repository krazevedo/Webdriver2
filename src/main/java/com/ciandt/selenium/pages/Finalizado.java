package com.ciandt.selenium.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import com.ciandt.selenium.regressao.TestBase;



public class Finalizado extends TestBase{
	public void verificarPaginaFinalizado() throws Exception{
		WebElement scroll = driver.findElement(By.cssSelector("div > div > h2"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Seu cadastro foi concluído com sucesso!".equals(driver.findElement(By.cssSelector("div > div > h2")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		assertEquals("rede.natura.net/espaco/" + Passo1.nomeEspaco, driver.findElement(By.cssSelector("div > div > p > span.ng-binding")).getText());
	}
	
	
}
