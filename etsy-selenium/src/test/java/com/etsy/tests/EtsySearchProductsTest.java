package com.etsy.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EtsySearchProductsTest extends TestBaseSetup {

	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = super.getDriver();
	}
	
	@Test
	public void shouldPrintItemPrice() throws InterruptedException {
		EtsyHomePage page = new EtsyHomePage(driver);
		page.openPage();
		//Pop up window handling
		page.clickOnCookiesAcceptButton();
		page.enterSearchCriteria(new String[] {"Sports Shoes"});
		// wait for the dropdown to appear
		Thread.sleep(1000);

		page.clickOnSuggestedSearchItem();
		// wait for search results to load
		Thread.sleep(1000);

		page.sortByPrice();
		
		List<WebElement> allItems = page.getAllItemPrices();
		System.out.println("Total number of items listed: " + allItems.size());
		
		Assert.assertTrue("Number of items listed", allItems.size() > 10);

		page.printTopTenItemPrices(allItems);
	}

}
