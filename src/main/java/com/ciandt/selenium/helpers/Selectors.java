package com.ciandt.selenium.helpers;

import org.openqa.selenium.By;

public class Selectors {
	//ATG
		public By loginName = By.id("loginName");
		public By loginPassword = By.id("loginPassword");
		public By personalizacao = By.linkText("Personalization");
		public By externalUsers = By.linkText("External Users");
		public By botaoFiltrar = By.cssSelector("img.filterButton");
		public By campoFiltro = By.id("filterField");
		public By itemCND = By.cssSelector("table#assetListContentTable > tbody > tr > td > a");
		public By statusAssinatura = By.id("propertyValue_statusAssinatura");
		public By storeStatus = By.id("propertyValue_storeStatus");
		public By botaoSalvar = By.cssSelector("#saveButtonLink > span");
		public By logout = By.linkText("Log out");
		public By popupLogout = By.cssSelector("div#centered > form > div.logoutBottom > a.buttonSmall.go");


		/// Login Painel
		public By loginEmail = By.id("auth_email");
		public By password = By.id("auth_password");
		public By botaoOK = By.id("authenticate");
		public By popupContrato = By.cssSelector("div#modal-tdu div div div h4");
		public By termosUso = By.id("accept-user-terms");
		public By download = By.id("download");
		public By infoUser = By.cssSelector("span.user-info");	  										
		public By botaoSair = By.linkText("Sair");
}
