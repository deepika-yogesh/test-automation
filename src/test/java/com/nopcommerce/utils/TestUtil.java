package com.nopcommerce.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil extends TestBase {

	// Page Time Out
	public static long PAGE_LOAD_TIMEOUT = 30;

	// Implicit Wait
	public static void ImplicitWait(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	// Take screenshot and store as a png file format
	public static void captureScreenShot(WebDriver driver) {
		String timestamp = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,
					new File(System.getProperty("user.dir") + "\\screenshots\\" + timestamp + ".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	

	//To Quit Browser
	public static void quitBroswer() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Explicit Wait
	public static void explicitWait(WebElement locator) {
		WebDriverWait wdwait = new WebDriverWait(driver, 10);
		wdwait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	}
	
	

