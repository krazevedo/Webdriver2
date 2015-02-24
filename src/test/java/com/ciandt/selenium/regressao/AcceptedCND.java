package com.ciandt.selenium.regressao;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;

import com.ciandt.selenium.helpers.Geral;
import com.ciandt.selenium.pages.LoginPainel;
import com.ciandt.selenium.pages.Passo1;

public class AcceptedCND extends TestBase{
	private StringBuffer verificationErrors = new StringBuffer();
	Geral geral = new Geral();
	LoginPainel login = new LoginPainel();
	@Test
	public void testUntitled2() throws Exception {
		geral.abrirPainel(driver);	
		for(int i = 0;i < CreateCND.cnd;i++){
			login.logarPainel(Passo1.emailCND[i]);
			driver.findElement(By.id("auth_email")).clear();
			driver.findElement(By.id("auth_email")).sendKeys(Passo1.emailCND[i]);
			driver.findElement(By.id("auth_password")).clear();
			driver.findElement(By.id("auth_password")).sendKeys("inicial1");
			driver.findElement(By.id("authenticate")).click();
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if ("Contrato de Franquia".equals(driver.findElement(By.cssSelector("div#modal-tdu div div div h4")).getText())) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}

			driver.findElement(By.id("accept-user-terms")).click();
			driver.findElement(By.id("download")).click();
			driver.findElement(By.cssSelector("span.user-info")).click();
			driver.findElement(By.linkText("Sair")).click();
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
