package com.redbus.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.LandingPage;

public class LandingTest extends BaseTest {

	LandingPage landingPage;

	/**
	 * searchBuses() tests the functionality of the search function of Landing page
	 */	
	@Test( enabled = false, groups = "sanity", priority = 1)
	public void searchBuses() throws Exception {
		String sourceCity = properties.getProperty("sourceCity");
		String destinationCity = properties.getProperty("destinationCity");
		String dateOfJourney = properties.getProperty("dateOfJourney");
		
		landingPage = new LandingPage(eventFiringWebDriver);
		landingPage.getUrl(properties.getProperty("url"));
		landingPage.insertRouteDetails(sourceCity, destinationCity, dateOfJourney);
		landingPage.performSearch();
		Assert.assertEquals(landingPage.isNavigatedToNextPage(), true);
	}

	/**
	 * allLinkVerfication() verifies the working of all links in Landing Page
	 * @throws IOException
	 */
	@Test( enabled = false)
	public void allLinkVerfication() throws IOException {
		landingPage = new LandingPage(driver);
		landingPage.getUrl(properties.getProperty("url"));
		landingPage.fetchAllLinks();
		Assert.assertEquals(landingPage.areURLsWorking(), true);
	}

	/**
	 * verifysearchWithIncorrectSourceOrDest() performs search with incorrect source and incorrect destination
	 */
	@Test(groups = "negative", enabled = false)
	public void verifysearchWithIncorrectSourceOrDest() {
		String incorrectSourceCity = properties.getProperty("incorrectSourceCity");
		String incorrectDestinationCity = properties.getProperty("incorrectdestinationCity");
		String dateOfJourney = properties.getProperty("dateOfJourney");
		
		landingPage = new LandingPage(driver);
		landingPage.getUrl(properties.getProperty("url"));
		landingPage.insertIncorrectSourceDestination(incorrectSourceCity, incorrectDestinationCity, dateOfJourney);
		landingPage.performSearch();
		Assert.assertEquals(landingPage.isNavigatedToNextPage(), false);
	}

	/**
	 * selectTravelDatePastPresentDate() verifies selection of travel date past present date
	 */
	@Test(groups="negative", enabled = false)
	public void selectTravelDatePastPresentDate() { 
		String sourceCity = properties.getProperty("sourceCity");
		String destinationCity = properties.getProperty("destinationCity");

		landingPage = new LandingPage(driver);
		landingPage.getUrl(properties.getProperty("url"));		
		landingPage.insertRouteDetails(sourceCity, destinationCity,null);
		Assert.assertEquals(landingPage.setPastDate(),false);
	}
	
	/**
	 * setReturnDatePastOnwardDate() verifies return date past the date of journey
	 */
	@Test(groups = "negative", enabled = false)
	public void setReturnDatePastOnwardDate() {
		String sourceCity = properties.getProperty("sourceCity");
		String destinationCity = properties.getProperty("destinationCity");
		String dateOfJourney = properties.getProperty("dateOfJourney");
		
		landingPage = new LandingPage(driver);
		landingPage.getUrl(properties.getProperty("url"));
		landingPage.insertRouteDetails(sourceCity, destinationCity, dateOfJourney);
		Assert.assertEquals(landingPage.setPastDate(), false);
		
	}

	/**
	 * signupLinkVisibility() verifies visibility of SignIn Link
	 */
	@Test(enabled = false)
	public void signupLinkVisibility() {
		landingPage = new LandingPage(driver);
		landingPage.getUrl(properties.getProperty("url"));
		
		Assert.assertTrue(landingPage.isSignInLInkPresent());
	}

	/**
	 * selectMyTrips() verifies the MyTrip option on profile icon after login
	 * @throws InterruptedException
	 */
	@Test(groups = "afterLogin", enabled =false, dependsOnMethods = "signupLinkVisibility")
	public void selectMyTrips() throws InterruptedException {
		landingPage = new LandingPage(driver);
		landingPage.getUrl(properties.getProperty("url"));
		landingPage.login();
		landingPage.selectOption("My Trips");
		Assert.assertTrue(landingPage.isNavigatedToTripsPage());
	}

	/**
	 * selectWalletCards() verifies the Wallet/Cards option on profile icon after login
	 * @throws InterruptedException
	 */
	@Test(groups = "afterLogin",dependsOnMethods = "selectMyTrips", priority = 2, enabled =false)
	public void selectWalletCards() throws InterruptedException {
		landingPage = new LandingPage(driver);
		landingPage.getUrl(properties.getProperty("url"));
	
		landingPage.selectOption("Wallets/Cards");
		Assert.assertTrue(landingPage.isNavigatedToWalletCardPage());
	}
	
	/**
	 * selectMyProfile() verifies the MyProfile option on profile icon after login
	 * @throws InterruptedException
	 */
	@Test(groups = "afterLogin", dependsOnMethods = "selectMyTrips", priority = 2, enabled =false)
	public void selectMyProfile() throws InterruptedException {
		landingPage = new LandingPage(driver);
		landingPage.getUrl(properties.getProperty("url"));
		
		landingPage.selectOption("My Profile");
		Assert.assertTrue(landingPage.isNavigatedToProfilePage());
	}
	
	/**
	 * selectWallet() verifies the Wallet option on profile icon after login
	 * @throws InterruptedException
	 */
	@Test(groups = "afterLogin", dependsOnMethods = "selectMyTrips", priority = 2, enabled =false)
	public void selectWallet() throws InterruptedException {
		landingPage = new LandingPage(driver);
		landingPage.getUrl(properties.getProperty("url"));
		
		landingPage.selectOption("Wallet");
		Assert.assertTrue(landingPage.isNavigatedToWalletHistoryPage());
	}

	/**
	 * performLogout() verifies the logout option on profile icon after login
	 * @throws InterruptedException
	 */
	@Test(groups = "afterLogin", dependsOnMethods = "selectMyTrips", priority = 3, enabled =false)
	public void performLogout() throws InterruptedException {
		landingPage = new LandingPage(driver);
		landingPage.getUrl(properties.getProperty("url"));
		
		landingPage.performSignout();
		Assert.assertTrue(landingPage.isSignInLInkPresent());
	}
}