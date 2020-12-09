package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.nopcommerce.utils.TestBase;
import com.nopcommerce.utils.TestUtil;



public class RegisterPage extends TestBase {
	
	WebDriver driver;
	
	@FindBy(className = "userlink")
	WebElement userLink;
	
	@FindBy(className = "ico-register")
	WebElement register;
	
	@FindBy(id = "FirstName")
	WebElement fname;

	@FindBy(id = "LastName")
	WebElement lname;
	
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "ConfirmEmail")
	WebElement confirmEmail;
	
	@FindBy(id = "Username")
	WebElement username;
	
	@FindBy(id = "check-availability-button")
	WebElement availability;
	
	@FindBy(id = "CountryId")
	WebElement country;
	
	@FindBy(id = "TimeZoneId")
	WebElement timeZone;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPassword;
	
	@FindBy(id = "Details_CompanyIndustryId")
	WebElement accountDetails_drp1;
	
	@FindBy(id = "Details_NopCommerceIntendedUseId")
	WebElement accountDetails_drp2;
	
	@FindBy(id = "Details_CompanyRoleId")
	WebElement accountDetails_drp3;
	
	@FindBy(id = "Details_CompanySizeId")
	WebElement accountDetails_drp4;
	
	@FindBy(id ="register-button")
	WebElement registerBtn;
	
	public RegisterPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickUserLink() {
		TestUtil.explicitWait(userLink);
		userLink.click();
	}
	
	public void ClickRegister() {
		TestUtil.explicitWait(register);
		register.click();
	}
	
	public void sendFirstname(String Fname) {
		fname.sendKeys(Fname);
	}
	
	public void sendLastname(String Lname) {
		lname.sendKeys(Lname);
	}
	
	public void sendEmail(String Email) {
		email.sendKeys(Email);
	}
	
	public void sendConfirmEmail(String confEmail) {
		confirmEmail.sendKeys(confEmail);
	}
	
	public void sendUserName(String uname) {
		username.sendKeys(uname);
	}
	
	public void CheckAvailability() throws InterruptedException {
		availability.click();
		Thread.sleep(3000);
		String checkUsernameAvailability = driver.findElement(By.id("username-availabilty")).getText();
		System.out.println(checkUsernameAvailability);
		Assert.assertEquals(checkUsernameAvailability, "Username available", "Username Not available");
	}
	

	public void SelectCountry(String Country) {
		Select drpcountry = new Select (country);
		drpcountry.selectByVisibleText(Country);
	}
	
	public void SelectTimeZone(String timezone) {
		Select drptimezone = new Select (timeZone);
		drptimezone.selectByValue(timezone);
	}
	
	public void sendPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void sendConfirmPassword(String confpwd) {
		confirmPassword.sendKeys(confpwd);
	}
	
	public void SelectAccountDeatilsDrop1(String acdrp1) {
		Select drp1 = new Select (accountDetails_drp1);
		drp1.selectByVisibleText(acdrp1);
	}
	
	public void SelectAccountDeatilsDrop2(String acdrp2) {
		Select drp2 = new Select (accountDetails_drp2);
		drp2.selectByVisibleText(acdrp2);
	}
	
	public void SelectAccountDeatilsDrop3(String acdrp3) {
		Select drp3 = new Select (accountDetails_drp3);
		drp3.selectByVisibleText(acdrp3);
	}
	
	public void SelectAccountDeatilsDrop4(String acdrp4) {
		Select drp4 = new Select (accountDetails_drp4);
		drp4.selectByValue(acdrp4);
	}
	
	
	public RegisterConfirmation ClickRegisterBtn() {
		registerBtn.click();
		return new RegisterConfirmation(driver);
	}
	
	
}
