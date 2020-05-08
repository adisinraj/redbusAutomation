package com.redbus.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BasePage {

	public SearchResultPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "ul.bus-items")
	private WebElement busSearchResult;

	@FindBy(css = "ul.bus-items div li.row-sec.clearfix")
	private List<WebElement> buses;

	@FindBy(css = "ul.bus-items div.button.view-seats.fr")
	private List<WebElement> busOperatorViewSeats;

	@FindBy(css = "div.seat-container-wrapper")
	private WebElement busSeatsContainer;

	@FindBy(css = "div.lower-canvas.canvas-wrapper canvas")
	private WebElement busLowerSeatContainer;

	@FindBy(css = "div.search-seatlayout.show_top.animated.seatBpDp")
	private WebElement selectBPDP;

	@FindBy(css = "div.sort-sec.clearfix.onward a")
	private List<WebElement> sortingOptions;

	@FindBy(css = "div.column-three div.dp-time")
	private List<WebElement> departureTime;

	@FindBy(css = "div.column-four div.dur")
	private List<WebElement> duration;

	@FindBy(css = "div.column-five div.bp-time")
	private List<WebElement> arrivalTime;

	@FindBy(css = "div.column-six div.rating-sec  span")
	private List<WebElement> ratings;

	@FindBy(css = "div.column-seven div.fare span")
	private List<WebElement> fare;

	@FindBy(css = "div.column-eight div.seat-left")
	private List<WebElement> seatsAvailable;
	
	@FindBy(css = "li.amenties span")
	private List<WebElement> bottom_panel;
	
	@FindBy(css = "div.panels-container")
	private WebElement panelContainer;

	List<String> originalValue = new ArrayList();
	List<String> sortedValue = new ArrayList();
	List<Integer> originalFare = new ArrayList();
	List<Integer> sortedFare = new ArrayList();

	public boolean areBusesPresent() {
		_wait(busSearchResult);
		return busSearchResult.isDisplayed();
	}

	public void selectSeat() throws AWTException {
		_wait(busSeatsContainer);
		Dimension dimension = driver.manage().window().getSize();
		int yaxis = dimension.getHeight();
		int xaxis = dimension.getWidth();
		/*
		 * Actions action = new Actions(driver); action.moveByOffset(400, 500);
		 * action.build().perform();
		 */
		// System.out.println(yaxis+": yaxis ||| xaxis :"+xaxis); //806: yaxis ||| xaxis
		// :1051
		// gotoAxisAndHoverAndClick(busLowerSeatContainer, xaxis/2, yaxis/2);

		Robot robot = new Robot();
		robot.mouseMove(945, 685);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}

	public boolean isSeatSelected() {
		System.out.println(busOperatorViewSeats.size());
		if (0 != busOperatorViewSeats.size()) {
			WebElement busOperatorSeat = busOperatorViewSeats.get(1);
			System.out.println(busOperatorViewSeats.get(1).getText());
			_wait(busOperatorSeat);
			hoveroverAndClick(busOperatorSeat);
			return selectBPDP.isDisplayed();
		}

		return false;
	}

	public boolean selectBus() {
		if (buses.size() != 0) {
			buses.get(0).click();
			return true;
		} else
			return false;
	}

	public boolean sortBuses(String sortBy) throws InterruptedException {

		Thread.sleep(5000);
		switch (sortBy) {
		case "Departure":
			sortBy(sortBy, departureTime);
			break;

		case "Duration":
			sortBy(sortBy, duration);
			break;

		case "Arrival":
			sortBy(sortBy, arrivalTime);
			break;

		case "Ratings":
			sortBy(sortBy, ratings);
			break;

		case "Fare":
			sortBy(sortBy, fare,null);
			break;

		case "Seats Available":
			sortBy(sortBy, seatsAvailable);
			break;

		default:
			System.out.println("No such option");

		}

		Collections.sort(originalValue);
		System.out.println("sorted original is : " + originalValue.toString());

		if (originalValue.equals(sortedValue))
			return originalValue.equals(sortedValue);

		else {
			Collections.reverse(originalValue);
			System.out.println("reverse original is : " + originalValue.toString());
			return originalValue.equals(sortedValue);
		}
	}

	public void sortBy(String sortBy, List<WebElement> optionsToBesorted) {
		for (WebElement element : optionsToBesorted) {
			originalValue.add(element.getText());
		}
		System.out.println("unsorted original is : " + originalValue.toString());
		for (WebElement sortOption : sortingOptions) {
			if (sortOption.getText().equals(sortBy)) {
				sortOption.click();
			}
		}
		for (WebElement element : optionsToBesorted) {
			sortedValue.add(element.getText());
		}
		System.out.println("sorted value is : " + sortedValue.toString());

	}

	public void sortBy(String sortBy, List<WebElement> optionsToBesorted,String fare) {
		for (WebElement element : optionsToBesorted) {
			originalFare.add(Integer.parseInt(element.getText()));
		}
		
		for(int i : originalFare) {
	//		System.out.println(i);
		}
		System.out.println("unsorted original is : " + originalValue.toString());
		for (WebElement sortOption : sortingOptions) {
			if (sortOption.getText().equals(sortBy)) {
				sortOption.click();
			}
		}
		for (WebElement element : optionsToBesorted) {
			sortedFare.add(Integer.parseInt(element.getText()));
		}
		System.out.println("sorted value is : " + sortedValue.toString());
	}

	public void clickonBottomPanel(String panelOption) throws InterruptedException {
		Thread.sleep(5000);
		hoveroverAndClick(bottom_panel.get(1));
		for (WebElement panelOptions : bottom_panel) {
			if (panelOptions.getText().equals(panelOption)) {
				panelOptions.click();
				_wait(panelContainer);						
			}
		}
	}
	
	public boolean isResultConatinerDisplayed() {
		_wait(panelContainer);
		return panelContainer.isDisplayed();
		
		
	}
}