package com.redbus.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;

public class LandingPage extends BasePage {

	public LandingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a.redbus-logo")
	private WebElement redbusLogo;

	@FindBy(id = "redBus")
	private WebElement busTickets;

	@FindBy(id = "cars")
	private WebElement carPool;

	@FindBy(id = "pilgrimages")
	private WebElement pilgrimages;

	@FindBy(css = "input#src")
	private WebElement fromTextbox;

	@FindBy(css = "ul.autoFill")
	private WebElement listOfCity;

	@FindBy(css = "input#dest.db")
	private WebElement toTextBox;

	@FindBy(id = "onward_cal")
	private WebElement onwardDate;

	@FindBy(id = "return_cal")
	private WebElement returnDate;

	@FindBy(id = "search_btn")
	private WebElement searchButton;

	@FindBy(tagName = "a")
	private List<WebElement> listOfHrefs;

	@FindBy(css = "td.past.day")
	private List<WebElement> pastDate;

	@FindBy(css = "td.wd.day")
	private List<WebElement> weekdays;

	@FindBy(id = "i-icon-profile")
	private WebElement profileIcon;

	@FindBy(id = "signInLink")
	private WebElement signInLink;

	@FindBy(css = "div.modalContent iframe")
	private WebElement signInframe;

	@FindBy(css = "div.google-text")
	private WebElement googleButton;

	@FindBy(id = "identifierId")
	private WebElement googleInputId;

	@FindBy(id = "identifierNext")
	private WebElement next;

	@FindBy(css = "div#password input")
	private WebElement googlePassword;

	@FindBy(css = "span.CwaK9 span")
	private WebElement nextPassword;
	
	@FindBy(css = "li.personalization-link-blocks.config-options")
	private List<WebElement> listOfOptions;

	@FindBy(id = "signOutLink")
	private WebElement signoutLink;
	
	Set<String> urls = new HashSet<String>();

	/**
	 * insertRouteDetails insert the @param into the field
	 * 
	 * @param sourceCity
	 * @param destinationCity
	 * @param dateOfJourney+-
	 */
	public void insertRouteDetails(String sourceCity, String destinationCity, @Optional String dateOfJourney) {
		fromTextbox.sendKeys(sourceCity);
		_wait(listOfCity);
		keyPress();
		toTextBox.sendKeys(destinationCity);
		_wait(listOfCity);
		keyPress();
		if (dateOfJourney != null)
			setDate(dateOfJourney);
		keyPress();
	}

	/**
	 * this method performs the search operation
	 */
	public void performSearch() {
		searchButton.click();
	}

	/**
	 * This method take date in form of string and set into the datepicker.
	 * @param date
	 */
	public void setDate(String date) {
		JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
		jsexecutor.executeScript("arguments[0].removeAttribute(arguments[1])", onwardDate, "readonly");
		onwardDate.sendKeys(date);
		jsexecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", onwardDate, "data-caleng",
				date);
	}

	/**
	 * @return if the page is navigated to search result pages or not
	 */
	public boolean isNavigatedToNextPage() {
		return driver.getTitle().equalsIgnoreCase("Search Bus Tickets");
	}

	/**
	 * This function to fetch all the links from the landingpage.
	 */
	public void fetchAllLinks() throws IOException {
		System.out.println("links found:" + urls.size());
		for (WebElement href : listOfHrefs) {
			System.out.println(href.getAttribute("href"));
			if (href.getAttribute("href").contains("javascript") || href.getAttribute("href").equals(""))
				continue;
			urls.add(href.getAttribute("href"));
		}
	//	System.out.println("links found:" + urls.size());
		areURLsWorking();
	}

	/**
	 * 
	 * @return true if all the URLs are accessible or else false
	 * @throws IOException
	 */
	public boolean areURLsWorking() throws IOException {
		boolean linksareWorking = true;
		for (String url : urls) {
			URL link = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) link.openConnection();
			connection.setConnectTimeout(5000);
			try {
				if (connection.getResponseCode() == 200) {
					System.out.println(url + " : is working fine");
				} else if (connection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND
						|| connection.getResponseCode() == HttpURLConnection.HTTP_BAD_REQUEST
						|| connection.getResponseCode() == HttpURLConnection.HTTP_MOVED_PERM
						|| connection.getResponseCode() == HttpURLConnection.HTTP_MOVED_TEMP) {
					System.out.println("URL Moved " + connection.getResponseCode() + " :" + url);
					linksareWorking = false;
				} else {
					System.out.println("URL Unresponsive " + connection.getResponseCode());
					linksareWorking = false;
				}
			} catch (Exception e) {
				System.out.println("URL NOT Accessible: " + url);
				System.out.println(e.getMessage());
				System.out.println("-------------------");
				linksareWorking = false;
			}
		}
		return linksareWorking;
	}

	/**
	 * Inserts the incorrect values to be searched upon
	 * @param sourceCity
	 * @param destinationCity
	 * @param dateOfJourney
	 */
	public void insertIncorrectSourceDestination(String sourceCity, String destinationCity, String dateOfJourney) {
		fromTextbox.sendKeys(sourceCity);
		keyPress();
		toTextBox.sendKeys(destinationCity);
		keyPress();
		setDate(dateOfJourney);
	}

	/**
	 * @return true if past date is set in the calendar
	 */
	public boolean setPastDate() {
		boolean var = true;
		if (onwardDate.isEnabled()) {
			_wait(onwardDate);
			System.out.println(pastDate.size());
			for (WebElement pastday : pastDate) {
				try {
					if (pastday.getText().contains("14")) {
						System.out.println(pastday.getText());
						pastday.click();
						// System.out.println("after click");
						searchButton.click();
						var = isNavigatedToNextPage();
					}
				} catch (ElementNotVisibleException e) {
					System.out.println("in the catch ");
					var = false;
				}
			}
			// System.out.println(weekdays.size());
			/*
			 * for (WebElement weekday : weekdays) {
			 * if(weekday.getText()!="")System.out.println(weekday.getText()); } find out
			 * what the blank space is
			 */
		}

		else if (returnDate.isEnabled()) {
			_wait(returnDate);
			System.out.println(pastDate.size());
			for (WebElement pastday : pastDate) {
				try {
					if (pastday.getText().contains("14")) {
						System.out.println(pastday.getText());
						pastday.click();
						// System.out.println("after click");
						var = isNavigatedToNextPage();
					}
				} catch (ElementNotVisibleException e) {
					System.out.println("in the catch ");
					var = false;
				}
			}
		}
		return var;
	}

	/**
	 * @return true if the SignIn Link is present
	 */
	public boolean isSignInLInkPresent() {
		_wait(profileIcon);
		profileIcon.click();
		return signInLink.isDisplayed();

	}

	/**
	 * This method performs login
	 * @throws InterruptedException
	 */
	public void login() throws InterruptedException {
		_wait(profileIcon);
		profileIcon.click();
		signInLink.click();
		String parentWindow = driver.getWindowHandle();
		_wait(signInframe);
		driver.switchTo().frame(signInframe);

		googleButton.click();

		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
		}
		googleInputId.sendKeys("adisinraj");
		next.click();
		_wait(nextPassword);
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
		googlePassword.sendKeys("Anshul@123");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		_wait(nextPassword);
		nextPassword.click();

		Thread.sleep(10000);

		driver.switchTo().window(parentWindow);
		System.out.println(driver.getWindowHandle());
		
	
	}

	/**
	 * This method selects the options available after login on profile icon
	 * @param option
	 */
	public void selectOption(String option) {
		profileIcon.click();
		_wait(listOfOptions.get(1));
		System.out.println(listOfOptions.size());
		for (WebElement options : listOfOptions) {
			if (options.getText().equals(option)) {
				 options.click();
				 break;
			}
		}
	}
	
	public boolean isNavigatedToTripsPage() throws InterruptedException {
		return driver.getCurrentUrl().equals("https://www.redbus.in/myprofile#trips");
	}
	public boolean isNavigatedToWalletCardPage() {
		return driver.getCurrentUrl().equals("https://www.redbus.in/myprofile#wallet");
	}
	public boolean isNavigatedToProfilePage() {
		return driver.getCurrentUrl().equals("https://www.redbus.in/myprofile");
	}
	public boolean isNavigatedToWalletHistoryPage() {
		return driver.getCurrentUrl().equals("https://www.redbus.in/myprofile#walletHistory");
	}
	
	/**
	 * This method performs Logout
	 * @throws InterruptedException
	 */
	public void performSignout() throws InterruptedException {
		profileIcon.click();
		signoutLink.click();
		Thread.sleep(5000);
	}

}
