package com.redbus.test;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.SearchResultPage;

public class SearchResultTest extends LandingTest{
	SearchResultPage searchResultPage;
	
	@Test(enabled = true)
  public void areBusesPresent() throws Exception {
		searchResultPage= new SearchResultPage(eventFiringWebDriver);
		searchBuses();
		Assert.assertTrue(searchResultPage.areBusesPresent());
  }
	
	@Test(dependsOnMethods = "areBusesPresent",enabled = true)
	public void areBusesSelectable() throws AWTException {
			
			Assert.assertTrue(searchResultPage.selectBus());
		//	Assert.assertEquals(searchResultPage.isSeatSelected(),true);
	}
	
	@Test(enabled = true)
	public void sortBusesByDeparture() throws Exception {
		searchResultPage= new SearchResultPage(eventFiringWebDriver);
		searchBuses();
		Assert.assertTrue(searchResultPage.sortBuses("Departure"));
	}
	
	@Test(enabled = true)
	public void sortBusesByDuration() throws Exception {
		searchResultPage= new SearchResultPage(eventFiringWebDriver);
		searchBuses();
		Assert.assertTrue(searchResultPage.sortBuses("Duration"));
	}
	
	@Test(enabled = false)
	public void sortBusesByArrival() throws Exception {
		searchResultPage= new SearchResultPage(eventFiringWebDriver);
		searchBuses();
		Assert.assertTrue(searchResultPage.sortBuses("Arrival"));
	}
	
	@Test(enabled = true)
	public void sortBusesByRatings() throws Exception {
		searchResultPage= new SearchResultPage(eventFiringWebDriver);
		searchBuses();
		Assert.assertTrue(searchResultPage.sortBuses("Ratings"));
	}
	
	@Test(enabled = true)
	public void sortBusesByFare() throws Exception {
		searchResultPage= new SearchResultPage(eventFiringWebDriver);
		searchBuses();
		Assert.assertTrue(searchResultPage.sortBuses("Fare"));
	}
	
	@Test(enabled = true)
	public void sortBusesBySeatsAvailable() throws Exception {
		searchResultPage= new SearchResultPage(eventFiringWebDriver);
		searchBuses();
		Assert.assertTrue(searchResultPage.sortBuses("Seats Available"));
	}
	
	@Test
	public void verifyAmenities() throws Exception {
		searchResultPage= new SearchResultPage(eventFiringWebDriver);
		searchBuses();
	
		searchResultPage.clickonBottomPanel("Amenities");
		Assert.assertTrue(searchResultPage.isResultConatinerDisplayed());
	}
			
	@Test
	public void verifyBoardingDroppingPoints() throws Exception {
		searchResultPage= new SearchResultPage(eventFiringWebDriver);
		searchBuses();						
	
		searchResultPage.clickonBottomPanel("Boarding & Dropping Points");
		Assert.assertTrue(searchResultPage.isResultConatinerDisplayed());
	}
	
	@Test
	public void verifyReviews() throws Exception {
		searchResultPage= new SearchResultPage(eventFiringWebDriver);
		searchBuses();
	
		searchResultPage.clickonBottomPanel("Reviews");
		Assert.assertTrue(searchResultPage.isResultConatinerDisplayed());
	}
	
	@Test
	public void verifyBookingPolicies() throws Exception {
		searchResultPage= new SearchResultPage(eventFiringWebDriver);
		searchBuses();
	
		searchResultPage.clickonBottomPanel("Booking policies");
		Assert.assertTrue(searchResultPage.isResultConatinerDisplayed());
	}
	
	@Test
	public void verifyRestStop() throws Exception {
		searchResultPage= new SearchResultPage(eventFiringWebDriver);
		searchBuses();
	
		searchResultPage.clickonBottomPanel("Rest Stop");
		Assert.assertTrue(searchResultPage.isResultConatinerDisplayed());
	}
	
}
