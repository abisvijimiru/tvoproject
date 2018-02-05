package com.tvo.testcases;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

import com.tvo.util.Constants;
import com.tvo.util.ExcelUtils;
import com.tvo.util.WebUtils;

public class TVOWebProFunctionalityTest extends TestWatcher {

	public static Logger logger = Logger.getLogger("FunctionalityTestCases");
	
    @Rule
    public TestWatcher watchman = new TVOWebProLog4jTestWatcher();
    
	@BeforeClass
	public static void setupBeforeClass() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path);
	}
	@AfterClass
    public static void setupAfterClass() throws Exception {
		if(WebUtils.driver !=null)
		{
			WebUtils.closeBrowser();
		}
	}
	@Before
	public void setUp() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		ExcelUtils.sBrowserName = Constants.DefaultBrowser;
		WebUtils.openBrowser(ExcelUtils.sBrowserName);
	}
	@After
	public void tearDown() throws Exception {
		WebUtils.closeBrowser();
			
	}
	@Test
	//To test the various elements present in the Home page, is loaded properly or not
	public void testHomePageValidation1() throws Exception {
		logger.info("Test1 - Home Page Validation");
		ExcelUtils.extractTestCaseInputs(1);
		if(ExcelUtils.sTestRunMode.equalsIgnoreCase("Yes"))
		{
				assertEquals(WebUtils.CheckHomePage(), ExcelUtils.sExpResult);
				ExcelUtils.sTestResult ="Pass";
		}
    }
    @Test
    //To test the login credentials with uname is empty or null
	public void testHPLoginValidation1() throws Exception {
    	logger.info("Test2 - Home Page Login Validation with uname and password is empty or null");
		ExcelUtils.extractTestCaseInputs(2);
		if(ExcelUtils.sTestRunMode.equalsIgnoreCase("Yes"))
		{
		String alertStrXpath = "//html/body/div[3]/div/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[4]";
		assertTrue(WebUtils.CheckHPLoginCredintals(ExcelUtils.sUserName,ExcelUtils.sPassword,
				                                   ExcelUtils.sExpResult,alertStrXpath));
		ExcelUtils.sTestResult ="Pass";
		}		
	}	
	@Test
	//To test the login credentials with invalid uname and valid password
	public void testHPLoginValidation2() throws Exception {
		logger.info("Test3 - Home Page Login Validation with invalid uname and valid password");
		ExcelUtils.extractTestCaseInputs(3);
		if(ExcelUtils.sTestRunMode.equalsIgnoreCase("Yes"))
		{
		String alertStrXpath = "//html/body/div[3]/div/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[5]";
		assertTrue(WebUtils.CheckHPLoginCredintals(ExcelUtils.sUserName,ExcelUtils.sPassword,
                ExcelUtils.sExpResult,alertStrXpath));
		ExcelUtils.sTestResult ="Pass";
		}
	}
	@Test
	//To test the login credentials with valid uname and invalid password
	public void testHPLoginValidation3() throws Exception {
		logger.info("Test4 - Home Page Login Validation with invalid uname and valid password");
		ExcelUtils.extractTestCaseInputs(4);
		if(ExcelUtils.sTestRunMode.equalsIgnoreCase("Yes"))
		{
		String alertStrXpath = "//html/body/div[3]/div/div[1]/div/div[2]/div[1]/div[2]/div[3]/div[2]";
		assertTrue(WebUtils.CheckHPLoginCredintals(ExcelUtils.sUserName,ExcelUtils.sPassword,
                   ExcelUtils.sExpResult,alertStrXpath));
		ExcelUtils.sTestResult ="Pass";
		}
		logger.info("testHPLoginValidation3 Execution Completed");
    }	
	@Test
	//To test the login credentials with valid uname and password but not the registered user.
	public void testHPLoginValidation4() throws Exception {
		logger.info("Test5 - Home Page Login Validation with valid uname and password for the non registered user");
		ExcelUtils.extractTestCaseInputs(5);
		if(ExcelUtils.sTestRunMode.equalsIgnoreCase("Yes"))
		{
		String alertStrXpath = "//html/body/div[3]/div/div[1]/div/div[2]/div[1]/div[2]/div[3]/div[3]";
		assertTrue(WebUtils.CheckHPLoginCredintals(ExcelUtils.sUserName,ExcelUtils.sPassword,
        ExcelUtils.sExpResult,alertStrXpath));
		ExcelUtils.sTestResult ="Pass";
		}
    }
	@Test
	//To test the login credentials with password is empty or null
	public void testHPLoginValidation5() throws Exception {
		logger.info("Test6 - Home Page Login Validation with password is empty");
		ExcelUtils.extractTestCaseInputs(6);
		if(ExcelUtils.sTestRunMode.equalsIgnoreCase("Yes"))
		{
		String alertStrXpath = "//html/body/div[3]/div/div[1]/div/div[2]/div[1]/div[2]/div[3]/div[1]";
        assertTrue(WebUtils.CheckHPLoginCredintals(ExcelUtils.sUserName,ExcelUtils.sPassword,
                ExcelUtils.sExpResult,alertStrXpath));
        ExcelUtils.sTestResult ="Pass";
		}
	}
	@Test
	//To test the various elements present in the Home page, is loaded properly or not
	public void testRegPageValidation1() throws Exception {
		logger.info("Test7 - Registration Page Login Validation");
		ExcelUtils.extractTestCaseInputs(7);
		if(ExcelUtils.sTestRunMode.equalsIgnoreCase("Yes"))
		{
		assertTrue(WebUtils.CheckRegistrationPage());
		ExcelUtils.sTestResult ="Pass";
		}
	}
}
