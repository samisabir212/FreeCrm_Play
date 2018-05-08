package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.TestBase;

public class TestLaunch extends TestBase {
	
	
	
	public TestLaunch() throws IOException {
		super();
	}

	@BeforeMethod
	public void launchmyshit() throws IOException {
		
		initialization();
		
		
		
	}

}
