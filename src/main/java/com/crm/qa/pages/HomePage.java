package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.pages.CalenderPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase  {
	
	
	private static WebDriverWait wait = new WebDriverWait(driver, 12);
	
	TestUtil testUtil = new TestUtil();
	
	//campro logo at homepage right side
	@FindBy(xpath="//td[contains(text(),'CRMPRO')]")
	WebElement crmPRO_Logo_homePage;
	
	//validate user logged in 
	@FindBy(xpath="//td[contains(text(),'User: sami sabir-idrissi')]")
	WebElement username_Text;
	
	
	//deals button link
	@FindBy(xpath="//ul[@class='mlddm']/li[5]")
	WebElement dealsLink;

	//contacts button link
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	//calender button link
	@FindBy(xpath="//td[@class='headertable']//div[@id='navmenu']/ul/li[2]")
	WebElement calenderLink;
	//tasks button link
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	//'new contact' link from contact drop down after mouse hover
	@FindBy(xpath=".//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
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
	
	
	
	
	
	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	//validateCRMLogo
	public boolean validate_CRMLOGO() {
		return crmPRO_Logo_homePage.isDisplayed();
	}
	
	//validate login page title
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	
	//validate user name that is logged in
	public boolean validateUserByText() {
		
		return username_Text.isDisplayed();
		
	}

	
	
	

	public ContactsPage clickContacts() throws IOException {
		testUtil.switchToIframe("mainpanel");
		contactsLink.click();
		return new ContactsPage();
	}

	public CalenderPage clickCalender() throws IOException  {
		calenderLink.click();
		return new CalenderPage();
	}

//	public TasksPage clickTasks() {
//		tasksLink.click();
//		return new TasksPage();
//		
//	}

	public DealsPage clickDeals() throws IOException {
		dealsLink.click();
		return new DealsPage();	
	}
	
	public void clickOnNewContactLink() throws InterruptedException{
		
		wait.until(ExpectedConditions.visibilityOf(contactsLink));
		wait.until(ExpectedConditions.elementToBeClickable(contactsLink));
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		testUtil.sleepFor(3);
		wait.until(ExpectedConditions.visibilityOf(newContactLink));
		wait.until(ExpectedConditions.elementToBeClickable(newContactLink));
		newContactLink.click();

	}





	
	
	
 }


