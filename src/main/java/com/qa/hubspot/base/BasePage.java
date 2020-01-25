package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	WebDriver driver;
	Properties prop;
	/**
	 * This driver is used to initialize the browser on the basis of browserName.
	 * @param browserName
	 * @return return 
	 */
	public WebDriver init_driver(String browserName) {
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else if(browserName.equals("internet explorer")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			
		}
		else {
			System.out.println(browserName + "Browser value is wrong, Please pass the correct browser name..");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
		
	}
	/**
	 * This method is used to read the properties from config.properties file
	 * @return prop
	 */
	
	public Properties init_properties() {
	 prop=new Properties();
	 try {
		FileInputStream ip=new FileInputStream("D:\\AppiumProjects\\MonsterAutomation\\MonsterIndia\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		System.out.println("Config file is missing, Please check it...");
		
	} catch (IOException e) {
		System.out.println("Properties could not be loaded, Pleae check it...");
		e.printStackTrace();
	}
	 return prop;
	}
	

}
