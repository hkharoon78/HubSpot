package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;


public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	
	By header = By.xpath("//h1[text()='Sales Dashboard']");
	By accountName = By.xpath("//span[contains(text(),'Create dashboard')]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil=new ElementUtil(driver);
		

	}

	public String getHomePageTitle() {
		
		
		
		return elementUtil.waitForTitlePresent(Constants.HOME_PAGE__TITLE, 30);
	}

	public boolean isHomePageHeaderPresent() {
		
		elementUtil.waitForTitlePresent(Constants.HOME_PAGE__TITLE, 30);
		return elementUtil.isElementDisplayed(header);
	}

	public String getHomePageHeaderValue() {
		return elementUtil.doGetText(header);
	}

	
	  public boolean isAccountNamePresent() { 
	  return elementUtil.isElementDisplayed(accountName);
	  
	  
	  }
	 
	public String getAccountNameValue() {
		return elementUtil.doGetText(accountName);
	}
	

}
