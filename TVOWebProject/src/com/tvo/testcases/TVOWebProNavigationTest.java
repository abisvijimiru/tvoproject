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

public class TVOWebProNavigationTest extends TestWatcher{
public static Logger logger = Logger.getLogger("NavigatePageLinkTestCases");
	
	@Rule
    public TestWatcher watchman = new TVOWebProLog4jTestWatcher();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
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
	//To test the navigation from home page to registration page and then back to home page
	public void PageNavigation1() throws Exception {
		logger.info("Test1 - Page Navigation from HP to RegPage to HP");
		ExcelUtils.extractTestCaseInputs(8);
		if(ExcelUtils.sTestRunMode.equalsIgnoreCase("Yes"))
		{
		assertEquals(WebUtils.CheckPageNavigationHPToRPToHP(), ExcelUtils.sExpResult);
		ExcelUtils.sTestResult ="Pass";		
		}
	}
	@Test
	//To test the navigation from home page to login page news window pop-up and click cancel to back to home page
	public void PageNavigation2() throws Exception {
		logger.info("Test2 - Page Navigation from HP to news window and cancel to HP");
		ExcelUtils.extractTestCaseInputs(9);
		if(ExcelUtils.sTestRunMode.equalsIgnoreCase("Yes"))
		{		
		assertTrue(WebUtils.CheckPageNavigationHPToGetNewPoHP());
		ExcelUtils.sTestResult ="Pass";
		}
	}
	@Test
	//To test the navigation from home page to login page play  window and then back to home page
	public void PageNavigation3() throws Exception {
		logger.info("Test3 - Page Navigation from HP to Play page");
		ExcelUtils.extractTestCaseInputs(10);
		if(ExcelUtils.sTestRunMode.equalsIgnoreCase("Yes"))
		{		
		assertTrue(WebUtils.CheckPageNavigationHPToPlay());
		ExcelUtils.sTestResult ="Pass";
		}		
	}
	@Test
	//To test and verify all the links in the home page is working or broken
	public void LinkNavigation1() throws Exception {
		logger.info("Test4 - Verify all the links in HP is working or broken");
		ExcelUtils.extractTestCaseInputs(11);
		if(ExcelUtils.sTestRunMode.equalsIgnoreCase("Yes"))
		{		
		assertTrue(WebUtils.CheckPageLinkNavigationInPage());
		ExcelUtils.sTestResult ="Pass";
		}		
	}
	@Test
	//To test and verify all the links in the registration page is broken or not
	public void LinkNavigation2() throws Exception {
		logger.info("Test5 - Verify all the links in the registration page is working or broken");
		ExcelUtils.extractTestCaseInputs(12);
		if(ExcelUtils.sTestRunMode.equalsIgnoreCase("Yes"))
		{		
		WebUtils.GoToRegPage();			 
		assertTrue(WebUtils.CheckPageLinkNavigationInPage());
		ExcelUtils.sTestResult = "Pass";
		}
	}
}