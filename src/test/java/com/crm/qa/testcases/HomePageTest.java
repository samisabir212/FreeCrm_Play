package com.crm.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

@Listeners(com.qa.ExtentReportListener.ExtentReporterNG.class)


public class HomePageTest extends TestBase {


	public HomePageTest() throws IOException {
		super();
	}





	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	
	

	
	//test cases should be seperte -- testcases should be independent of each other
	//before each testcase launch the browser and log in
	//after each testcase -- close the browser
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//waitUntilClickable_UsingBy(By.xpath("//ul[@class='mlddm']/li[5]"));

		
	}
	
	
	@Test(priority=1, enabled = false)
	public void veridyHomePageLogo() {
		
		boolean validateLogo = homePage.validate_CRMLOGO();
		if(validateLogo == true) {
			System.out.println("crm logo pass");
		}else {
			System.out.println("crm logo fail");
		}
		
		
		
		
	}
	
	@Test(priority=1,enabled=false)
	public void verifyHomePageTitle() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO");
		
	}
	
	@Test(priority=3, enabled = false)
	public void veridyLoggedInUser() {
		testUtil.switchToIframe("mainpanel");
		boolean user = homePage.validateUserByText();
		if(user == true) {
			System.out.println("user: pass");
		}else {
			System.out.println("user: fail");
		}
	}
	
	
	
	
	@Test(priority=4,enabled=false)
	public void clickDeals() throws IOException {
		homePage.clickDeals();
		String dealsTitle = driver.getTitle();
		System.out.println("deals title page is "+ dealsTitle);
		String expectedTitle= "https://www.freecrm.com/index.cfm?CFID=606462&CFTOKEN=66468799&jsessionid=9c30f9caf70c65ea03d3416329203b252d60";
		Assert.assertEquals(dealsTitle, expectedTitle);
		
	}
	
	@Test(priority=5, enabled = false)
	public void clickContacts() throws InterruptedException, IOException {
		Thread.sleep(4000);
		testUtil.switchToIframe("mainpanel");
		homePage.clickContacts();
		
		String title = driver.getTitle();
		System.out.println("contacts page title is :: "+ title);
		
	}
	
	@Test(priority=1,enabled = false)
	public void clickCalender() throws IOException {
		//Thread.sleep(4000);
		testUtil.switchToIframe("mainpanel");
		homePage.clickCalender();
		String title = driver.getTitle();
		System.out.println("contacts page title is :: "+ title);
		
		
	}
	
	
	@Test(priority=1,enabled = false)
	public void verifyLoggedInUsernameText() {
		testUtil.switchToIframe("mainpanel");
		Assert.assertTrue(homePage.validateUserByText());
		
	}
	
	@Test(priority=1,enabled = true)
	public void verifyContactsLink() throws IOException {
		testUtil.switchToIframe("mainpanel");
		contactsPage = homePage.clickContacts();
		String contactsPageTitle = driver.getTitle();
		System.out.println("contacts page title is :: "+ contactsPageTitle);

	}
	

	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	


}



































