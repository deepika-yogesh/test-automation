package com.nopcommerce.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;





public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public String excelFileName;
	
	//To Load property file	
	public TestBase() {
		try {
		prop = new Properties();		
		FileInputStream ip = new FileInputStream ((System.getProperty("user.dir") + "\\config\\config.properties"));
		prop.load(ip);
	}
	catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	catch (IOException e) {
		e.printStackTrace();
	}
}

	

//To Initialise Browser
public static void initialisation () {
	String browsername = prop.getProperty("browser");
	if(browsername.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir") +"\\drivers\\chromedriver.exe"));
		driver = new ChromeDriver();
	} else if (browsername.equals("IE")) {
		System.setProperty("webdriver.ie.driver", (System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe"));
		driver = new InternetExplorerDriver();
}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	TestUtil.ImplicitWait(5);
	
}

//To Launch URL
public static void launchURL(String url) {
	  driver.get(prop.getProperty(url)); 
	 }

//To read from excel
@DataProvider(name="fetchData")
public String[][] getData() throws IOException {
	return ReadExcel.readExcelData(excelFileName);
}


}

