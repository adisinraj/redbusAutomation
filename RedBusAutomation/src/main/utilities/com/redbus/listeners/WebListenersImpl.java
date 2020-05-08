package com.redbus.listeners;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebListenersImpl implements WebDriverEventListener{

	static Logger LOGGER = Logger.getLogger(WebListenersImpl.class);
	
	
	public void beforeAlertAccept(WebDriver driver) {
		// DO Nothing
	}

	
	public void afterAlertAccept(WebDriver driver) {
		// DO Nothing
	}

	
	public void afterAlertDismiss(WebDriver driver) {
		// DO Nothing
	}

	
	public void beforeAlertDismiss(WebDriver driver) {
		// DO Nothing
	}

	
	public void beforeNavigateTo(String url, WebDriver driver) {
		// DO Nothing
	}

	
	public void afterNavigateTo(String url, WebDriver driver) {
		LOGGER.info("Navigated to URL :"+url);
	}

	
	public void beforeNavigateBack(WebDriver driver) {
		// DO Nothing
	}

	
	public void afterNavigateBack(WebDriver driver) {
		// DO Nothing
	}

	
	public void beforeNavigateForward(WebDriver driver) {
		// DO Nothing
	}

	
	public void afterNavigateForward(WebDriver driver) {
		// DO Nothing
	}

	
	public void beforeNavigateRefresh(WebDriver driver) {
		// DO Nothing
	}

	
	public void afterNavigateRefresh(WebDriver driver) {
		// DO Nothing
	}

	
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// DO Nothing
	}

	
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		LOGGER.info("Found the element by '"+by.toString()+"'");
	}

	
	public void beforeClickOn(WebElement element, WebDriver driver) {
		LOGGER.info("Going to click on element : "+element.toString());
	}

	
	public void afterClickOn(WebElement element, WebDriver driver) {
		LOGGER.info("Clicked on element : "+element.toString());
	}

	
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// DO Nothing
	}

	
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// DO Nothing
	}

	
	public void beforeScript(String script, WebDriver driver) {
		// DO Nothing
	}

	
	public void afterScript(String script, WebDriver driver) {
		// DO Nothing
	}

	
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// DO Nothing
	}

	
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		LOGGER.info("Switched to window : "+windowName);
	}

	
	public void onException(Throwable throwable, WebDriver driver) {
		// DO Nothing
	}

	
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// DO Nothing
	}

	
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}

	

}
