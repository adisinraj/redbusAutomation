package com.redbus.pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends BasePage{

	PaymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		}

	
	@FindBy(css="a.login")
	private WebElement loginButton;
	
	@FindBy(css="input#email_create")
	private WebElement emailAddress;


}
