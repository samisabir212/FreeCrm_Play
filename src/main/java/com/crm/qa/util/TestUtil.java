package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public TestUtil() throws IOException {
		super();
	}
	public static long PAGE_LOAD_TIMEOUT = 10;
	public static long IMPLICIT_WAIT = 20;
	
	public static String TESTDATA_SHEET_PATH ="/Users/sami/git/EclipseWorkSpace/FreeCRMTest"
			+ "/src/main/java/com/crm/qa/testdata/freeCRMtestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;

	
	public static Object[][] getTestData(String sheetName) {
		
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	
	
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
		}
	

	 public void switchToIframe(String nameOrID) {

	        //make sure you get the id or name of the iframe and pass it as element
	        //so create a variable and store the webelement object and pass it to the method parameter
	        driver.switchTo().frame(nameOrID);

	    }
	 
		
		public void waitUntilClickable_UsingBy(By locator) {

	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        wait.until(ExpectedConditions.elementToBeClickable((locator)));

	    }
		
		public void verifyDisplayedElement(boolean element) {
			
			if(element == true) {
				System.out.println("element is displayed:: pass");
			}else {
				System.out.println("element is not displayed:: fail");
			}
			
			
		}
		
		public void selectDropListByIndex(By locator, int index) {

	        Select DropDownList = new Select(driver.findElement(locator));
	        DropDownList.selectByIndex(index);
	    }

		public void selectOptionByVisibleTextElementOutside(WebElement element, String value) {
	        Select select = new Select(element);
	        select.selectByVisibleText(value);
	    }

	    public void selectOptionByVisibleText(By locator, String value) {
	        WebElement object = driver.findElement(locator);
	        Select select = new Select(object);
	        select.selectByVisibleText(value);
	    }

		

	    /*sleep*/
	    public void sleepFor(int sec) throws InterruptedException {
	        Thread.sleep(sec * 1000);
	    }
		
}
