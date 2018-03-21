package com.citrix.elearng;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

/**
 * Unit test for simple App.
 */
public class BaseTest{
	
	public static WebDriver driver = null;
	public static Properties properties= null;
	
	
	@BeforeTest 
	public void loadConfigurationFile() {
		properties = new Properties();
		ClassLoader classLoader = getClass().getClassLoader();
		String filePath = classLoader.getResource("config.prop").getPath();
		
		try {
			properties.load(new FileInputStream(new File(filePath)));
			} catch (IOException e) { 
			e.printStackTrace();
			}
		//System.setProperty(properties.getProperty("driverkey"),properties.getProperty("driverpath"));
	//	driver = new ChromeDriver();
		System.setProperty("webdriver.firefox.port","4444");
		driver = new FirefoxDriver();
	}
	
	
	}