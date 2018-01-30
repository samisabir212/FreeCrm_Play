package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

@Listeners(com.qa.ExtentReportListener.ExtentReporterNG.class)

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	//create constructor and call super keyword
	//calls super class constructor (testbase class constructor)
	public LoginPageTest() throws IOException{
		super();
		
	}

	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage(); 
		
	}
	
	
	@Test(priority=1,enabled=false)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
		
	}
	
	@Test(priority = 2,enabled=false)
	public void validate_HomePage_LOGO() {
		boolean logo = loginPage.validateCRM_LOGO();
		if(logo==true) {
			System.out.println("freeCRM_Logo:: PASSED");
		}else {
			System.out.println("freeCRM_Logo:: FAILED (ELEMENT NOT DISPLAYED)");
		}
		
		Assert.assertTrue(logo,"free_CRM_LOGO is present on page");
		
	}
	
	@Test(priority=1,enabled=true)
	public void valid_User_login_Test() throws InterruptedException, IOException {
		
	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		  
	
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
}
