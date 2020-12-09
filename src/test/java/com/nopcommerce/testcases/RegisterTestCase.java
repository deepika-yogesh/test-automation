package com.nopcommerce.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nopcommerce.pages.RegisterConfirmation;
import com.nopcommerce.pages.RegisterPage;
import com.nopcommerce.utils.TestBase;
import com.nopcommerce.utils.TestUtil;

public class RegisterTestCase extends TestBase {
	
	RegisterPage registerpage;
	RegisterConfirmation registerconf;

	
	public RegisterTestCase() {
		super();
	}
	
	@BeforeClass
	public void setData() {
		excelFileName = "TestData";
	}
	
	@Test(dataProvider="fetchData")
	public void RegisterUserCase (String Fname, String Lname, String Email, String confEmail, String uname, String Country, String timezone, String pwd, String confpwd, String acdrp1, String acdrp2, String acdrp3, String acdrp4) throws InterruptedException {
		initialisation();
		TestBase.launchURL("url");
		registerpage = new RegisterPage(driver);
		registerpage.ClickUserLink();
		registerpage.ClickRegister();
		Thread.sleep(3000);
		registerpage.sendFirstname(Fname);
		registerpage.sendLastname(Lname);
		registerpage.sendEmail(Email);
		registerpage.sendConfirmEmail(confEmail);
		registerpage.sendUserName(uname);
		registerpage.CheckAvailability();
		registerpage.SelectCountry(Country);
		registerpage.SelectTimeZone(timezone);
		registerpage.sendPassword(pwd);
		registerpage.sendConfirmPassword(confpwd);
		registerpage.SelectAccountDeatilsDrop1(acdrp1);
		registerpage.SelectAccountDeatilsDrop2(acdrp2);
		registerpage.SelectAccountDeatilsDrop3(acdrp3);
		registerpage.SelectAccountDeatilsDrop4(acdrp4);
		registerconf = registerpage.ClickRegisterBtn();
		registerconf.getTitleofPage();
	}
	
	@AfterMethod
	public void tearDown() {
		TestUtil.quitBroswer();
	}
	
}
	
	
