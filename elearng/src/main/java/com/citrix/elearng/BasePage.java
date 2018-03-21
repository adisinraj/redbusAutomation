package com.citrix.elearng;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	public static WebDriver driver;
	
	public BasePage(WebDriver driver){
		BasePage.driver = driver;
	}

	public void navigateto(String url){
		driver.get(url);
	}
	
}
