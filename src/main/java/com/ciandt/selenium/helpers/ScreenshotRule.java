package com.ciandt.selenium.helpers;



import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ciandt.selenium.regressao.TestBase;



public class ScreenshotRule extends TestWatcher{
	Geral geral = new Geral();
	
	protected void failed(Throwable e, Description description)	{
		String nomeClasse = description.getTestClass().getSimpleName();
		String nomeTeste = description.getMethodName();

		try {
			tiraScreenshot(nomeClasse, nomeTeste);
		} catch (Throwable e1) {
			e1.printStackTrace();
		}		
		TestBase.getFirefoxDriver().quit();
	}

	public void tiraScreenshot(String nomeClasse, String nomeTeste) throws Throwable {
		TakesScreenshot takesScreenshot = (TakesScreenshot) TestBase.getFirefoxDriver();
		//Cria um diretório "screenshots" na raiz do projeto
		geral.gerarData();
		geral.pegarHora();
		new File("screenshots/" + nomeClasse + "/" + nomeTeste + "/" + geral.getData() + "/").mkdirs();
		//Obtém um screenshot
		File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
		//Cria um arquivo dentro do diretório "screenshots", contendo
		//o nome da classe/método de teste
		//Exemplo: "IncluirUsuarioTest-incluirComSucesso-screenshot.png"
		FileUtils.copyFile(screenshot, new File("screenshots/" + nomeClasse + "/" + nomeTeste + "/" + geral.getData() + "/" + geral.getHora() +"-screenshot.png"));			
	}
}
