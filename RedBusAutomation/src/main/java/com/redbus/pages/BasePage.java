package com.redbus.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static WebDriver driver;
	static Logger LOGGER = Logger.getLogger(BasePage.class);

	BasePage(WebDriver driver) {
		BasePage.driver = driver;
		driver.manage().window().maximize();
	}

	public void getUrl(String url) {
		driver.get(url);
	}

	public void keyPress() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void _wait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void hoveroverAndClick(WebElement toElement) {
		Actions action = new Actions(driver);
		action.moveToElement(toElement);
		action.build().perform();
		toElement.click();					
	}

	public void gotoAxisAndHoverAndClick(WebElement toElement, int xaxis, int yaxis) {
		Actions action = new Actions(driver);
		_wait(toElement);
		action.moveToElement(toElement).build().perform();
		;
		// toElement.click();
	}

}
