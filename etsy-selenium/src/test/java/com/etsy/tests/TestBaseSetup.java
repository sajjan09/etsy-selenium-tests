package com.etsy.tests;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBaseSetup {

	private WebDriver driver;
	
	public  TestBaseSetup(){
		initializeTestBaseSetup();
	}
	
	public void initializeTestBaseSetup(){
		//Launching Firefox browser
		// Edit the gecko driver exe file's location below
		System.setProperty("webdriver.gecko.driver","C:\\E\\Shobha\\prof\\Dev-Shobha\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		this.driver = new FirefoxDriver();
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	@After
	public void tearDown() {
		driver.quit();
	}
	
}
