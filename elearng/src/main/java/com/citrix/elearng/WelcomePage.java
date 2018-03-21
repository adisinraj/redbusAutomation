package com.citrix.elearng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends BasePage{

	public WelcomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="/html/body/div[1]/data/ng-include[1]/div/section/div/div/div/a[2]")
	private WebElement inTheCloudButton;
	
	public String navigateToNextPage(){
		inTheCloudButton.click();
		return driver.getTitle();
	}
	
	
}
