package com.tvo.util;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtils {

	public static WebDriver driver = null;
	public static Logger logger = Logger.getLogger("WebUtils");    
    // To open browser based on the given options
	public static WebDriver openBrowser(String sBrowserName) throws Exception {
		
		PropertyConfigurator.configure("log4j.properties");

		if (sBrowserName.equals("Chrome")) {
			File file = new File(Constants.ChromeDrvPath);
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
		} 
		else if (sBrowserName.equals("FireFox")) {
			File file = new File(Constants.FireFoxDrvPath);
			System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
			driver = new FirefoxDriver();			
		}
		else if(sBrowserName.equals("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver", Constants.IEDrvPath);
			driver = new InternetExplorerDriver();
		}
		else {
			
		}
		
		logger.info("Browser Opened");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("Implict wait for 20 seconds to open the browser loadded with all the components");
		driver.get(Constants.URL);
		logger.info("Constants.URL Opened");
		return driver;
		
	}
	//To Close the existing opened browser
	public static void closeBrowser() throws Exception {
		
		if(driver!=null)
			driver.quit();
		logger.info("Browser Closed");
	}
    //To Check the Home page is loaded with the MPower logo or not 
	public static boolean IsHomePageMPowerLogoPresent (WebDriver driver) {
		
		if(!driver.findElement(By.xpath("//html/body/div[3]/div/div[1]/div/div[1]/nav/div/div[1]/div/a/img")).isDisplayed())
		{
			logger.info("Unable to find the tvo mPower logo");
			return false;
		}
		logger.info("TVO mPower logo is loaded in Home Page");
		return true;
	}
	//To Check the Registration page is loaded with MPower logo or not 
    public static boolean IsRegPageMPowerLogoPresent (WebDriver driver) {
		
		if(!driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div/div[1]/nav/div/div[1]/div/a/img")).isDisplayed())
		{
			logger.info("Unable to find the tvo mPower logo");
			return false;
		}
		logger.info("TVO mPower logo is loaded in Registration Page");
		return true;
	}
	//To Check the Registration page is loaded with the text content or not
	public static boolean IsContentsOfRegPagePresent(WebDriver driver) {

		if (!driver.getPageSource().contains("Create Your")) {
			logger.info("Unable to find the text - Create Your FREE Acctount");
			assert (false);
		}
		if (!driver.getPageSource().contains("Register for mPower and get your class up and running!")) {
			logger.info("Unable to find the text - Register for mPower and get your class up and running!");
			assert (false);
		}
		if (!driver.getPageSource().contains("All fields marked with")) {
			logger.info("Unable to find the text - All fields marked with");
			assert (false);
		}
		if (!driver.getPageSource().contains("TVO is a registered charity #85985 0232 RR0001 - Copyright ©")) {
			logger.info("Unable to find the text - TVO is a registered charity #85985 0232 RR0001 - Copyright ©");
			assert (false);
		}
		if (!driver.getPageSource().contains("The Ontario Educational Communications Authority (TVO)")) {
			logger.info("Unable to find text - Ontario Educational Communications Authority (TVO)");
			assert (false);
		}
		logger.info("All the Text in the Registration Page loaded successfully");
		return true;
	}
	//To Check the Registration page is loaded with the page elements or not
	public static boolean IsElementsOfRegPagePresent(WebDriver driver) throws Exception {
		if (!driver.findElement(By.id("firstName")).isDisplayed())
		{
			logger.info("Unable to locate first name field");
			assert (false);
		}
		if (!driver.findElement(By.id("lastName")).isDisplayed())
		{
			logger.info("Unable to locate last name field");
			assert (false);
		}
		if (!driver.findElement(By.id("educatorRoleId")).isDisplayed())
		{
			logger.info("Unable to locate role field");
			assert (false);
		}
		if (!driver.findElement(By.id("boardId")).isDisplayed())
		{
			logger.info("Unable to locate BoardId field");
			assert (false);
		}
		if (!driver.findElement(By.id("email")).isDisplayed())
		{
			logger.info("Unable to locate emailId field");
			assert (false);
		}
		if (!driver.findElement(By.id("userEmailConfirm")).isDisplayed())
		{
			logger.info("Unable to locate userEmailConfirm field");
			assert (false);
		}
		if (!driver.findElement(By.id("source")).isDisplayed())
		{
			logger.info("Unable to locate source field");
			assert (false);
		}
		if (!driver.findElement(By.id("sourceOther")).isDisplayed())
		{
			logger.info("Unable to locate sourceOther field");
			assert (false);
		}
		if (!driver.findElement(By.id("agreement")).isDisplayed())
		{
			logger.info("Unable to locate agreement field");
			assert (false);
		}
		if (!driver.findElement(By.id("emailPromos")).isDisplayed())
		{
			logger.info("Unable to locate emailPromos field");
			assert (false);
		}
		if (!driver.findElement(By.id("registerSubmit")).isDisplayed())
		{
			logger.info("Unable to locate registerSubmit field");
			assert (false);
		}
		logger.info("All the elements/field in the Registration Page loaded successfully");
		return true;
	}
	//Go to the Registration page 
	public static WebDriver GoToRegPage() throws Exception
	{
		driver.findElement(By.id("loginPageRegister1")).click();
		driver.manage().window().maximize();
		logger.info("Navigated to Registration Page and Maximized");
		return driver;
	
	}
	//Check and Verify Registration page is loaded with all the features of that page or not
	public static boolean CheckContentsOfRegPage(WebDriver driver) throws Exception
	{
		logger.info("Check Registration Page MPower Logo is loaded or not");
		if (IsRegPageMPowerLogoPresent(driver))
		{
			logger.info("Check Registration Page Text are loaded or not");
			if (IsContentsOfRegPagePresent(driver))
			{
				logger.info("Check Registration Page elements/fields are loaded or not");
				if(IsElementsOfRegPagePresent(driver))
				{
					logger.info("Registration page loaded successfully");
					return true;
				}
			}
		}
		logger.info("Registration page not found");
		return false;
	}
	// Check and Verify Registration Page is loaded properly or not
	public static boolean CheckRegistrationPage() throws Exception {
		logger.info("Check Registration Page");
		WebDriver driverLocal = GoToRegPage();
		return (CheckContentsOfRegPage(driverLocal));
	}
	//Check and Verify the text of the Home Page loaded or not 
	public static boolean IsContentsOfHomePagePresent(WebDriver driver) {
		
		if (!driver.getPageSource().contains("Introducing mPower!")) {
			logger.info("Unable to find the text - Introducing mPower!");
			assert (false);
		}		
		if(!driver.findElement(By.xpath("//html/body/div[3]/div/div[1]/div/div[2]/div[1]/video")).isDisplayed())
		{
			logger.info("Unable to find video");
			return false;	
		}		
		if (!driver.getPageSource().contains("TVO's mPower is a creative online game that teaches fundamental")) {
			logger.info("Unable to find text - TVO's mPower is a creative online game that teaches fundamental");
			assert (false);
		}
		if (!driver.getPageSource().contains("Always free for Ontario students and educators")) {
			logger.info("Unable to find text - Always free for Ontario students and educators");
			assert (false);
		}
		if (!driver.getPageSource().contains("Includes teacher dashboard and educator resources")) {
			logger.info("Unable to find text - Includes teacher dashboard and educator resources");
			assert (false);
		}
		if (!driver.getPageSource().contains("Tracks student progress and responds to learners' needs")) {
			logger.info("Unable to find text - Tracks student progress and responds to learners' needs");
			assert (false);
		}
		if (!driver.getPageSource().contains("Supports the development of global competencies")) {
			logger.info("Unable to find text - Supports the development of global competencies");
			assert (false);
		}
		if (!driver.getPageSource().contains("Tested and trusted by Ontario educators")) {
			logger.info("Unable to find text - Tested and trusted by Ontario educators");
			assert (false);
		}
		if (!driver.getPageSource().contains("mPower is my new go-to resource here in my")) {
			logger.info("Unable to find text - mPower is my new go-to resource here in my");
			assert (false);
		}
		if (!driver.getPageSource().contains("mPower has changed the way my kids")) {
			logger.info("Unable to find text - mPower has changed the way my kids");
			assert (false);
		}
		if (!driver.getPageSource().contains("Available on desktops, laptops, and iPads with the following browsers")) {
			logger.info("Unable to find text - Available on desktops, laptops, and iPads with the following browsers");
			assert (false);
		}
		if (!driver.getPageSource().contains("TVO is a registered charity #85985 0232 RR0001 - Copyright ©")) {
			logger.info("Unable to find the text - TVO is a registered charity #85985 0232 RR0001 - Copyright ©");
			assert (false);
		}
		if (!driver.getPageSource().contains("The Ontario Educational Communications Authority (TVO)")) {
			logger.info("Unable to find text - Ontario Educational Communications Authority (TVO)");
			assert (false);
		}
		logger.info("All the Text in the Home Page Loaded Successfully");
		return true;
	}
	//Check and Verify all the elements of the Home Page loaded or not
	public static boolean IsElementsOfHomePagePresent (WebDriver driver) {
		
		if (!driver.findElement(By.id("loginPageRegister1")).isDisplayed())
		{
			logger.info("Unable to locate loginPageRegister1 field");
			assert (false);
		}
		if (!driver.findElement(By.id("loginPageGetNews")).isDisplayed())
		{
			logger.info("Unable to locate loginPageGetNews field");
			assert (false);
		}
		if (!driver.findElement(By.id("play_btn")).isDisplayed())
		{
			logger.info("Unable to locate loginPageGetNews field");
			assert (false);
		}		
		if (!driver.findElement(By.id("username")).isDisplayed())
		{
			logger.info("Unable to locate username field");
			assert (false);
		}
		if (!driver.findElement(By.id("password")).isDisplayed())
		{
			logger.info("Unable to locate password field");
			assert (false);
		}
		if (!driver.findElement(By.id("educatorLoginButton")).isDisplayed())
		{
			logger.info("Unable to locate educatorLoginButton field");
			assert (false);
		}
		if (!driver.findElement(By.id("whybg")).isDisplayed())
		{
			logger.info("Unable to locate whybg field");
			assert (false);
		}
		if (!driver.findElement(By.id("info")).isDisplayed())
		{
			logger.info("Unable to locate info field");
			assert (false);
		}
		if (!driver.findElement(By.id("educatorLoginButton")).isDisplayed())
		{
			logger.info("Unable to locate educatorLoginButton field");
			assert (false);
		}
		
		if (!driver.findElement(By.id("educatorLoginButton")).isDisplayed())
		{
			logger.info("Unable to locate educatorLoginButton field");
			assert (false);
		}
		logger.info("All the elements/field of the Registration Page is loaded successfully");
		return true;
	}
	//Check and verify Home Page loaded successfully or not
	public static String CheckHomePage() throws Exception {
		driver.manage().window().maximize();
		logger.info("Check Home page logo is loaded or not");
	    if (IsHomePageMPowerLogoPresent(driver))
		{
	    	logger.info("Check All the Text of the Home Page loaded or not");
			if (IsContentsOfHomePagePresent(driver))
			{
				logger.info("Check all the elements/fields of the Home Page loaged or not");
				if(IsElementsOfHomePagePresent(driver))
				{
					logger.info("Home Page Loaded Successfully");
					return ("Home page loaded successfully");					
				}
			}
		}
	    logger.info("Problem in loading the Home Page");
		return null;
	}
    // Check the presence of the id
	public static boolean isIdIsPresent(String inputVal)
	{
		try
		{
		WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(inputVal)));
		}catch(Exception e)
		{
	        e.printStackTrace();
	        logger.info("Given Id of the element is not loaded");
			return false;
		}
		logger.info("Given Id of the element is loaded");
		return true;
	}
	// Check the Alert popup or not
	public static String checkAlert() {
		Alert alert = null;
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 2);
	        wait.until(ExpectedConditions.alertIsPresent());
	        alert = driver.switchTo().alert();
	        alert.accept();	 
	        return(alert.getText());
	    } catch (Exception e) {
	        //exception handling
	    }
	    return(null);
	}
	//Set the given input to web element
	public static void giveInput(String inputId, String inputVal)
	{
		if (isIdIsPresent(inputId)) {
			logger.info("Clear the webelement");
			driver.findElement(By.id(inputId)).clear();
			logger.info("Set the webelement with the given input value");
			driver.findElement(By.id(inputId)).sendKeys(inputVal);
		}
	}
	//Click the submit button
	public static void submiButton(String inputId)
	{
		if (isIdIsPresent(inputId)) {
			logger.info("Click the submitbutton");
			driver.findElement(By.id(inputId)).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}
	//Login with the given credentials 
	public static void loginWithCredintials(String uname, String passWord)
	{
		logger.info("Set uname");
		giveInput("username", uname);
		logger.info("Set password");
		giveInput("password", passWord);
		logger.info("Click submit button");
		submiButton("educatorLoginButton");
	}
	//Verify the given login credentials
	public static boolean verifyCredintials(String uname, String passWord, String espectedStr, String alertStrXpath)
	{
		if(espectedStr.equals(driver.findElement(By.xpath(alertStrXpath)).getText()))
		{
			logger.info("Popup Alert is coorect");
			return true;
		}
		logger.info("Popup Alert is not correct");
		return false;
	}
	//Check Home Page login credentials 
  	public static boolean CheckHPLoginCredintals(String uname, String passWord, String espectedStr, String alertStrXpath) throws Exception {
  		logger.info("Check and Verify Login Credintials");
  		loginWithCredintials(uname,passWord);
  		return(verifyCredintials(uname,passWord,espectedStr,alertStrXpath));
  	}
  	//Check Page navigation from one page to another
  	public static String CheckPageNavigationHPToRPToHP() throws Exception
  	{
  		driver.navigate().to("https://mpower.tvo.org/educators/#/signup/");
  		if(CheckContentsOfRegPage(driver))
  		{
  			logger.info("Successfully Navigated to Registration Page");
  			driver.navigate().back();
  			return (CheckHomePage());
  		}
  		logger.info("Page navigation to Registration page is unsuccessful");
  		return null;
  	}
  	//Check page navigation from one page to another
  	public static boolean CheckPageNavigationHPToGetNewPoHP() throws Exception
  	{
  		driver.findElement(By.id("loginPageGetNews")).click();
  		
  		if (driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div/div/div/div[1]/h4")).isDisplayed())
  		{
  			String alertMsg = driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div/div/div/div[1]/h4")).getText();
  			alertMsg.trim();
  			String espectedStr = "Please tell me more about !";
  			espectedStr.trim();
  			if (alertMsg.equals(espectedStr))
  			{
  				driver.findElement(By.xpath("//html/body/div[3]/div/div[2]/div/div/div/a")).click();
  				logger.info("Page navigation from Home page to login news window and the home page is successfu;");
  				return (true);
  			}
   		}
  		logger.info("Page navigation from home page to news window is unsuccessful");
  	    return(false);
  	}
  	//Check page navigation from one page to another
  	public static boolean CheckPageNavigationHPToPlay() throws Exception
  	{
  		driver.findElement(By.id("play_btn")).click();
  		
  		if (driver.findElement(By.xpath("//html/body/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/a/img")).isDisplayed())
  		{
  			logger.info("Page navigation from Home Page to kids play page is successful");
  			return (true);
  		}
		logger.info("Page navigation from Home Page to kids play page is unsuccessful");
  	    return(false);
  	}
  	//Check all the links in the page is broken or not 
  	public static String isLinkBroken(URL url) throws Exception
	{		
		try
		{
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			logger.info("Link or URL is not broken");
			return response;
		}
		catch (Exception exp)
		{
       		System.out.println(exp.getMessage());
       		logger.info("Link or URL is broken");
       		return "NOK";
		}
	}
    //Check and verify all the links in the Home page is able to navigate or not
	public static boolean CheckPageLinkNavigationInPage() throws Exception {
		List<WebElement> all_links_webpage = driver.findElements(By.tagName("a"));
		int k = all_links_webpage.size();
		
		String[] link = new String[k];
		int index = 0;
		for (int i = 0; i < k; i++) {
		
				if ((all_links_webpage.get(i).getAttribute("href" ))!= null)
				{
					if (!all_links_webpage.get(i).getAttribute("href").isEmpty())
					{
			             link[index] = all_links_webpage.get(i).getAttribute("href");
			             index++;
					}
				}
		}
		int actualListSize = index;
		
		for (index = 0; index < actualListSize; index++) {
			String tempStr=isLinkBroken(new URL(link[index]));
			if ( tempStr == "NOK")
			{
				System.out.println(link[index] + " is " + tempStr);
				logger.info("Link is broken");
			}
			
		}	
		return true;
	}
	//Check the loaded page is proper or not
	public static boolean CheckloadedPage(WebDriver wDriver) throws Exception {
		wDriver.manage().window().maximize();
		logger.info("Check Home Page logo is present or not ");
	    if (IsHomePageMPowerLogoPresent(wDriver))
		{
	    	logger.info("Check all the text in the Home page is present or not");
			if (IsContentsOfHomePagePresent(wDriver))
			{
				logger.info("Check all the elements/fields or present or not");
				if(IsElementsOfHomePagePresent(wDriver))
				{
					logger.info("Page Loaded Successfully");
					return true;
				}
			}
		}
	    logger.info("Page not found");
		return false;
	}
	//Check the browser compatibility with different browsers
	public static boolean CheckBrowserCompatibility(String browserName) throws Exception
	{
		WebDriver localDriver = null;
		logger.info("Open Browser");
		localDriver = openBrowser(browserName);
		logger.info("Check page loaded is proper or not");
		if (CheckloadedPage(localDriver))
		{
			logger.info("Close the browser");
			closeBrowser();
			return true;
		}
		logger.info("Page not found");
	return false;
	}
}
