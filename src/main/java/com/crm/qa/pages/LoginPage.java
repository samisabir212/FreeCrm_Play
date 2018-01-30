package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	

	//~~~~~~~~PAGE ELEMENTS~~~~~~~
	//username 
	@FindBy(name="username")
	WebElement username;
	//password
	@FindBy(name="password")
	WebElement password;
	//Login button
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	//'FreeCRM' logo
	@FindBy(xpath="//a[@class='navbar-brand']/img")
	WebElement freeCRM_Logo;
	//features link
	@FindBy(xpath="//a[contains(text(),'Features')]")
	WebElement features_Link;
	//Sign Up link
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUp_Link;
	//Pricing link
	@FindBy(xpath="//a[contains(text(),'Pricing')]")
	WebElement pricing_Link;
	//Customers Link
	@FindBy(xpath="//a[contains(text(),'Customers')]")
	WebElement customers_link;
	//Contact Link
	@FindBy(xpath="//a[contains(text(),'Contact')]")
	WebElement contact_Link;
	//'Forgot Password?' text
	@FindBy(xpath="//a[contains(text(),'Forgot Password?')]")
	WebElement forgotPassword_txt;
	//Sign Up button link below 'Free CRM' logo on top left side of page
	@FindBy(xpath="//button[@class='btn' or contains(text(),'Sign Up')]")
	WebElement signUp_ButtonLink;
	
	
	//initialize LoginPage objects
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	 
	
	
	//~~~~~~~~~~~~~~~~Page Actions~~~~~~~~~~~~~~~~~~
	//validate login page title
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	

	
	//validate Crm Logo image is present
	public boolean validateCRM_LOGO() {
		return freeCRM_Logo.isDisplayed();
	}
	
	//login to crm application
	public HomePage login(String userName, String passWord) throws IOException, InterruptedException{
		
		
		username.sendKeys(userName);
		password.sendKeys(passWord);
		Thread.sleep(4000);
		loginButton.click();
		System.out.println("login button clicked");
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		return new HomePage();
		
		
		
		
	}
	
	
	
	
	
	
	

}
