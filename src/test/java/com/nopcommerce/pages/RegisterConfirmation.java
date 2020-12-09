package com.nopcommerce.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.nopcommerce.utils.TestBase;
import com.nopcommerce.utils.TestUtil;

public class RegisterConfirmation extends TestBase {

	WebDriver driver;
	
	public RegisterConfirmation(WebDriver driver) {
		this.driver = driver;
	}

	
	public void getTitleofPage() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Register - nopCommerce");
		TestUtil.captureScreenShot(driver);
	}
	
	
	
	
	
}
