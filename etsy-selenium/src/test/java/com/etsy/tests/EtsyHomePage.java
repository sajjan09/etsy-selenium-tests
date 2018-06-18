package com.etsy.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EtsyHomePage {

	protected WebDriver driver;
		
	public EtsyHomePage(WebDriver driver) {
		this.driver = driver;
		
	}

	public void openPage(){
		driver.get("https://etsy.com");
		System.out.println("Page title:"+  driver.getTitle());
	}

	public void clickOnCookiesAcceptButton(){
		WebElement cookiesAcceptButton =  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/div[2]/button"));		
		cookiesAcceptButton.click();
	}

	public void enterSearchCriteria(String[] searchString){
		//Go to Search field and enter Sports Shoes
		WebElement searchElement = driver.findElement(By.id("search-query"));
		searchElement.sendKeys(searchString);
	}
	
	public void clickOnSuggestedSearchItem(){
		//click on one of the suggested option
		WebElement dropdownUL = driver.findElement(By.xpath("//*[@id=\"search-suggestions\"]/ul"));
		List<WebElement> itemList = dropdownUL.findElements(By.tagName("li"));
		System.out.println("Suggested search items in the dropdown:  " + itemList.size());
		itemList.get(0).click();

	}

	public void sortByPrice() {
		//Click on sort by button
		WebElement sortByButton = driver.findElement(By.xpath("//*[@id=\"sortby\"]"));
		sortByButton.click();
		
		//Choose Sort by price option
		driver.findElement(By.linkText("Lowest Price")).click();		
	}

	public List<WebElement> getAllItemPrices() {
		return driver.findElements(By.className("currency-value"));
	}

	public void printTopTenItemPrices(List<WebElement> allItems) {
		System.out.println("======= Printing prices for 10 items =========");		
		for( int i=0; i<10; i++){
			System.out.println("PRICE -> " + allItems.get(i).getAttribute("innerHTML"));
		}		
	}
	
}
