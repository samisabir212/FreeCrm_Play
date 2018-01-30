package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

@Listeners(com.qa.ExtentReportListener.ExtentReporterNG.class)


public class ContactsPageTest extends TestBase {
	
	
	public ContactsPageTest() throws IOException {
		super();
	}

	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	

	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage =  homePage.clickContacts();
		//waitUntilClickable_UsingBy(By.xpath("//ul[@class='mlddm']/li[5]"));

	}
	
	
	public void verifyContactsPageTitle() {
		
		System.out.println("contacts page title is:: " + contactsPage.printContactsPageTitle());
		
	}
	
	@Test(enabled = false)
	public void verifyContactsPageLabel_isDisplayed() {
		
		boolean label = contactsPage.verifyContactsPageLabel();		
		testUtil.verifyDisplayedElement(label);
		Assert.assertTrue(label, "contacts page label is missing on the page");
		
	}
	
	//verify fred oz is in your contacts list
	@Test(enabled = false)
	public void verifyContactName() throws InterruptedException {
		
		contactsPage.selectContactByName("Fred oz");
		testUtil.sleepFor(5);
		
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	
	@Test(enabled = true, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) throws InterruptedException{
		
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(title, firstName, lastName, company);
	}
	

	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	

}
