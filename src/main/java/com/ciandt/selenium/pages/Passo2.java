package com.ciandt.selenium.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.ciandt.selenium.helpers.Geral;
import com.ciandt.selenium.regressao.TestBase;

import static org.junit.Assert.fail;

public class Passo2 extends TestBase{
	Geral geral;


	public void verificarPasso2() throws Exception{
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.cssSelector("div#fNomeDoTitularCartao > input#creditcardnameholder"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
	}

	public void preencherNomeTitular(){
		WebElement scroll = driver.findElement(By.cssSelector("p#txt-desc-recebimentos-2"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		driver.findElement(By.cssSelector("div#fNomeDoTitularCartao > input#creditcardnameholder")).sendKeys("TESTE CIT");
	}

	public void preencherNumeroCartao(){
		driver.findElement(By.cssSelector("div#fnumeroCartao > input#creditcardnumber")).click();
		driver.findElement(By.cssSelector("div#fnumeroCartao > input#creditcardnumber")).sendKeys("4929551508774256");
		/*driver.findElement(By.cssSelector("div#fnumeroCartao > input#creditcardnumber")).sendKeys("6062825607632328");*/
	}

	public void preencherDataExpiracao(){
		driver.findElement(By.cssSelector("div#creditcardexpiremonth > button#btn_creditcardexpiremonth")).click();
		driver.findElement(By.linkText("Agosto")).click();
		driver.findElement(By.cssSelector("div#creditcardexpireyear > button#btn_creditcardexpireyear")).click();
		driver.findElement(By.linkText("2020")).click();
	}

	public void selecionarCheckBoxes(){
		driver.findElement(By.cssSelector("div#fCheckDoc > p > span.check-box-style")).click();
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
