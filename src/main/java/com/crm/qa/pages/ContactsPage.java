package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	//'Contacts' label
	@FindBy(xpath="//td[contains(text(),'Contacts')]") //fix extra s testing screenshot
	public WebElement contactsLabel;
	

	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement companyName;
	

	//company
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveButton;

	
	//verify contacts label
	public boolean verifyContactsPageLabel() {
		boolean label = contactsLabel.isDisplayed();
		return label;
		
	}
	
	//print contacts page title
	public String printContactsPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	//selectContactByName 
	public void selectContactByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		
		//verify that the radio button is enabled
		boolean button = driver.findElement(By.xpath(".//*[@id='vContactsForm']/table/tbody/tr[4]/td[1]/input")).isEnabled();
		
		Assert.assertTrue(button, "radio button is not selected");
		
		
	}
	
	
	public void createNewContact(String title,String fn, String ln, String company) {
		
		Select select = new Select(driver.findElement(By.xpath("//select[contains(@name,'title')]")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		companyName.sendKeys(company);
		saveButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
