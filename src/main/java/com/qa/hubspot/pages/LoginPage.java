package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	// 1.  Page object / OR / By Locators
	By emailId=By.id("username");
	By pasword=By.id("password");
	By loginButton=By.id("loginBtn");
	By signUpLink=By.linkText("Sign up");
	//By showPassword=By.xpath("//a[@href='/login/forgot?email=']");
	By showPassword=By.xpath("//span[text()='Show Password']");
	
	
	
	// 2. Constructor of Page class
	
	public LoginPage(WebDriver driver) {
		this.driver=driver; 
		elementUtil=new ElementUtil(driver);
		
		elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE__TITLE, 30);
	}
	
	// 3 . Page Actions / Page Method
	
	public String getPageTitle() {
		String title=elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE__TITLE, 15);
		
		
		System.out.println("Login Page Title is :" + title);
		return title;
		
	}
	public boolean verifySignUpLink() {
		return elementUtil.isElementDisplayed(signUpLink);
		
	}
	/*
	 * public boolean verifyShowPwdLink() { return
	 * driver.findElement(showPassword).isDisplayed(); }
	 */
	
	public boolean verifyShowPassword() {
		return driver.findElement(showPassword).isDisplayed();
		
	}
	
	
	
	public HomePage doLogin(String username, String pwd) {
		System.out.println("Credentials are :" + username + " : " + pwd);
		elementUtil.doSendKeys(emailId, username);
		elementUtil.doSendKeys(pasword, pwd);
		elementUtil.doClick(loginButton);
		elementUtil.waitForTitlePresent(Constants.HOME_PAGE__TITLE, 30);
		
		return new HomePage(driver);
	}
	
	

}
