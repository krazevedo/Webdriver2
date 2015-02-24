package com.ciandt.selenium.pages;



import org.openqa.selenium.By;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import com.ciandt.selenium.helpers.DataDriven;
import com.ciandt.selenium.regressao.TestBase;



public class Finalizado extends TestBase{
	public void verificarPaginaFinalizado() throws Exception{
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Seu endereço na internet será:".equals(driver.findElement(By.cssSelector("div > div > p > span.ng-scope")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		assertEquals("rede.natura.net/espaco/" + Passo1.nomeEspaco, driver.findElement(By.cssSelector("div > div > p > span.ng-binding")).getText());
	}
	
	public void gravarCNDExcel(){
		String[] a = Passo1.getCND();
		String[] b = Passo1.getEmailCND();
		DataDriven.writereport(a, b);
	}
}
