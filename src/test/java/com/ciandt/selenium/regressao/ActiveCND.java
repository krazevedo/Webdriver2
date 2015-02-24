package com.ciandt.selenium.regressao;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ciandt.selenium.helpers.Geral;
import com.ciandt.selenium.pages.Passo1;



public class ActiveCND extends TestBase {
	private StringBuffer verificationErrors = new StringBuffer();
	Geral geral = new Geral();

	@Test
	public void testUntitled() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,60);

		geral.abrirATG(driver);

		for(int i = 0;i < CreateCND.cnd;i++){
			driver.findElement(By.id("loginName")).clear();
			driver.findElement(By.id("loginName")).sendKeys("cesargomes");
			driver.findElement(By.id("loginPassword")).clear();
			driver.findElement(By.id("loginPassword")).sendKeys("G1u6t1o2!");
			driver.findElement(By.name("/atg/userprofiling/InternalProfileFormHandler.login")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Personalization")));


			driver.findElement(By.linkText("Personalization")).click();
			driver.findElement(By.linkText("External Users")).click();
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (isElementPresent(By.cssSelector("img.filterButton"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}


			driver.findElement(By.id("filterField")).clear();			
			driver.findElement(By.id("filterField")).sendKeys(Passo1.nomeCND[i]);
			driver.findElement(By.cssSelector("img.filterButton")).click();
			Thread.sleep(10000);

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("scrollContainer"));
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("table#assetListContentTable > tbody > tr > td > a")));


			driver.findElement(By.cssSelector("table#assetListContentTable > tbody > tr > td > a")).click();

			driver.switchTo().defaultContent();

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightPaneIframe"));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("propertyValue_statusAssinatura")));


			driver.findElement(By.id("propertyValue_statusAssinatura")).clear();
			driver.findElement(By.id("propertyValue_statusAssinatura")).sendKeys("Active");
			new Select(driver.findElement(By.id("propertyValue_storeStatus"))).selectByVisibleText("ActiveNotAccepted");
			driver.findElement(By.cssSelector("#saveButtonLink > span")).click();


			driver.switchTo().defaultContent();		
			driver.findElement(By.linkText("Log out")).click();

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("logoutDialogFrame"));


			WebElement element = driver.findElement(By.cssSelector("div#centered > form > div.logoutBottom > a.buttonSmall.go"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click(); return true", element);			
		}			
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
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
