package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.*;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class HomePageTest {
	
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	
	
	@BeforeTest
	public void setUp() {
		basePage=new BasePage();
		prop=basePage.init_properties();
		String browser=prop.getProperty("browser");
		driver=basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		loginPage=new LoginPage(driver);
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));  
	    
			
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title=homePage.getHomePageTitle();
		System.out.println("Home Page title is: " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE__TITLE , "Home Page title is missing...");
		
	}
	@Test(priority=2)
	public void verifyHomePageHeaderTest() {
		Assert.assertTrue(homePage.isHomePageHeaderPresent(), "Home Page header is not displaying...");
		String header=homePage.getHomePageHeaderValue();
		System.out.println("Home page header value is :" + header);
		Assert.assertEquals(header, Constants.HOME_PAGE__HEADER);
	}
	@Test(priority=3)
	public void verifyLoggedInUserTest() {
		Assert.assertTrue(homePage.isAccountNamePresent());
		String accountNameTest=homePage.getAccountNameValue();
		System.out.println("Logged in user name is : " + accountNameTest);
		Assert.assertEquals(accountNameTest, prop.getProperty("accountNameProperties"));
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
