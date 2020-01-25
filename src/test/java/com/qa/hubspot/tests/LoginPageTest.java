package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class LoginPageTest {
	
	// BM - T - AM
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	
	
	@BeforeTest
	public void setUp() {
		basePage=new BasePage();
		prop=basePage.init_properties();
		String browser=prop.getProperty("browser");
		driver=basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	    loginPage=new LoginPage(driver);
			
	}
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		Assert.assertEquals(loginPage.getPageTitle(), Constants.LOGIN_PAGE__TITLE, "Login page title is mismatch...");
		
	}
	@Test(priority=2)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.verifySignUpLink(),"Sign Up link is not displaying...");
	}
	@Test(priority=3)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=4)
	public void verifyShowPasswordTest() {
		Assert.assertTrue(loginPage.verifyShowPassword(), "Show password text is not displaying..." );
	}

	/*
	 * @Test(priority=4) public void verifyShowPwdLinkTest() {
	 * Assert.assertTrue(loginPage.verifyShowPwdLink(),
	 * "Forgot password link is not displaying..."); }
	 */
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	

}
