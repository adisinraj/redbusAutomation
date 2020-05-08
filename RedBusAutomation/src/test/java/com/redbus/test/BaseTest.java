package com.redbus.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.redbus.listeners.WebListenersImpl;

/**
 * Unit test for simple App.
 */
public class BaseTest{
	
	static {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
	}

	static Logger LOGGER = Logger.getLogger(BaseTest.class);
	
	public WebDriver driver = null;
	public static Properties properties= null;
	EventFiringWebDriver eventFiringWebDriver;
	
	@Parameters("browser")
	@BeforeClass
	public void loadConfigurationFile(@Optional String browser) {
		properties = new Properties();
		LOGGER.info("property obj initiated");
		ClassLoader classLoader = getClass().getClassLoader();
		LOGGER.info("class loader");
		String filePath = classLoader.getResource("config.properties").getPath();
		try {
			properties.load(new FileInputStream(new File(filePath)));
			browser= properties.getProperty("browser");
			
			LOGGER.info("prop file load");	
		} catch (IOException e) { 
				System.out.println();
				e.printStackTrace();
			}
		
	if(browser.equalsIgnoreCase("chrome")){
		  System.setProperty(properties.getProperty("chromedriverkey"),properties.getProperty("chromedriverpath"));
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--disable-notifications");
		  driver = new ChromeDriver(options);
	}
	else if (browser.equalsIgnoreCase("firefox")){
				driver = new FirefoxDriver();
	}
	setListener();
	}
	
	public void setListener() {
		 eventFiringWebDriver = new EventFiringWebDriver(driver);
		WebListenersImpl webListener = new WebListenersImpl();
		eventFiringWebDriver.register(webListener);
	}
	
	@AfterClass
	public void quit(){
	//	driver.quit();
	//	eventFiringWebDriver.close();
	//	eventFiringWebDriver.quit();
		
	}
		
	}