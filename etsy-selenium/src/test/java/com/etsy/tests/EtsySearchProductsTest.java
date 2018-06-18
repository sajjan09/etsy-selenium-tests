package com.etsy.tests;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EtsySearchProductsTest {

	@Test
	public void shouldPrintItemPrice() throws InterruptedException {
		//Launching Firefox browser:
		System.setProperty("webdriver.gecko.driver","C:\\E\\Shobha\\prof\\Dev-Shobha\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://etsy.com");
		System.out.println("Page title:"+  driver.getTitle());
				
		//Pop up window handling
		WebElement searchElement1 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/div[2]/button"));
		searchElement1.click();
		
		//Go to Search field and enter Sports Shoes
		WebElement searchElement = driver.findElement(By.id("search-query"));
		searchElement.sendKeys(new String[] {"Sports Shoes"});
		// wait for the dropdown to appear
		Thread.sleep(1000);

		//click on one of the suggested option
		WebElement dropdownUL = driver.findElement(By.xpath("//*[@id=\"search-suggestions\"]/ul"));
		List<WebElement> itemList = dropdownUL.findElements(By.tagName("li"));
		System.out.println("Suggested search items in the dropdown:  " + itemList.size());
		itemList.get(0).click();

		// wait for search results to load
		Thread.sleep(1000);

		//Click on sort by button
		WebElement sortByButton = driver.findElement(By.xpath("//*[@id=\"sortby\"]"));
		sortByButton.click();
		
		//Choose Sort by price option
		driver.findElement(By.linkText("Lowest Price")).click();
		
		List<WebElement> allItems = driver.findElements(By.className("currency-value"));
		System.out.println("Total number of items listed: " + allItems.size());
		
		System.out.println("======= Printing prices for 10 items =========");		
		for( int i=0; i<10; i++){
			System.out.println("PRICE -> " + allItems.get(i).getAttribute("innerHTML"));
		}
				
	}

}
