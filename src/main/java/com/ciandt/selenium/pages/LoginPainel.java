package com.ciandt.selenium.pages;

import org.openqa.selenium.By;
import com.ciandt.selenium.regressao.TestBase;

public class LoginPainel extends TestBase {
	public void logarPainel(String emailCND){
		driver.findElement(By.id("auth_email")).clear();
		driver.findElement(By.id("auth_email")).sendKeys(emailCND);
		driver.findElement(By.id("auth_password")).clear();
		driver.findElement(By.id("auth_password")).sendKeys("inicial1");
		driver.findElement(By.id("authenticate")).click();
	}

}
