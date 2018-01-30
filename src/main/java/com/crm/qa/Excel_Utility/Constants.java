package com.crm.qa.Excel_Utility;

public class Constants {


	public static String RUNMODE_COL = "Runmode";
	public static String SUITENAME_COL ="SuiteName";
	public static String TESTCASE_COL = "TestCases";



	public static String DATA_SHEET = "TestData";
	public static String SUITE_SHEET = "Suite";
	public static String TESTCASE_SHEET = "TestCases";


	public static String RUNMODE_YES = "Y";
	public static String RUNMODE_NO = "N";


	//what suite will do we want to run?
	public static String SUITE_XL_PATH = "/Users/sami/Desktop/SeleniumBootCamp/Way2Automation/src/test/java/testdata/Suite.xlsx";

	//how are we setting up out suite for the bankmanger testcases
	public static String BankManagerSuite_XLPATH = System.getProperty("user.dir") + "/src/test/java/testdata/BankManagerSuite.xlsx";

	public static String SUITE2_XL_PATH = System.getProperty("user.dir") + "/src/test/java/testdata/CustomerSuite.xlsx";



}
