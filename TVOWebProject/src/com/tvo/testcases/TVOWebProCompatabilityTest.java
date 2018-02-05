package com.tvo.testcases;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

import com.tvo.util.ExcelUtils;
import com.tvo.util.WebUtils;

public class TVOWebProCompatabilityTest extends TestWatcher {

public static Logger logger = Logger.getLogger("TVOWebProCompatabilityTest");
	
	@Rule
    public TestWatcher watchman = new TVOWebProLog4jTestWatcher();
	
	@Before
	public void setUp() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
	}
	@After
	public void tearDown() throws Exception {
		
	}
	@Test
	//To test page loaded using chrome is successful or not
	public void CompatibilityTest1() throws Exception {	
		logger.info("Test1 - To test page loaded using chrome is successful or not");
		ExcelUtils.extractTestCaseInputs(13);
		if(ExcelUtils.sTestRunMode.equalsIgnoreCase("Yes"))
		{
		assertTrue(WebUtils.CheckBrowserCompatibility(ExcelUtils.sBrowserName));
		ExcelUtils.sTestResult ="Pass";
		}
	}
	@Test
	//To test page loaded using firefox is successful or not
    public void CompatibilityTest2() throws Exception {
		logger.info("Test2 - To test page loaded using firefox is successful or not");
		ExcelUtils.extractTestCaseInputs(14);
		if(ExcelUtils.sTestRunMode.equalsIgnoreCase("Yes"))
		{
		assertTrue(WebUtils.CheckBrowserCompatibility(ExcelUtils.sBrowserName));
		ExcelUtils.sTestResult ="Pass";
		}
	}
	@Test
	//To test page loaded using Internet Explorer is successful or not
    public void CompatibilityTest3() throws Exception {
		logger.info("Test3 - To test page loaded using Internet Explorer is successful or not");
		ExcelUtils.extractTestCaseInputs(15);
		if(ExcelUtils.sTestRunMode.equalsIgnoreCase("Yes"))
		{
		assertTrue(WebUtils.CheckBrowserCompatibility(ExcelUtils.sBrowserName));
		ExcelUtils.sTestResult = "Pass";
		}
	}
}