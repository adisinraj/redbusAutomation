package com.citrix.elearng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class WelcomeTest extends BaseTest{
  @Test
  public void navigateToMenu(){
	  WelcomePage welcomePage = new WelcomePage(driver);
	  welcomePage.navigateto(properties.getProperty("url"));
	  String title = welcomePage.navigateToNextPage();
	  assertEquals("Browse eLearning | Citrix Education", welcomePage.getTitle());
  }
}
