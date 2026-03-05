package com.orangeHRMcucumber.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.orangeHRMcucumber.utils.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	 protected WebDriver driver;
	 protected ReadConfig rd = new ReadConfig();
	 
		public void init() {
			String browser = rd.GetBrowser();
			if (driver != null) return;
			try{
				switch (browser.toLowerCase()) {
				case "chrome":
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
				break;
				
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
					
				case "edge":
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;
					
				default:
					throw new RuntimeException("Browsers not working");
				}
				
			}catch(Exception e) {
				throw new RuntimeException (e.getMessage());
			}
		} 
		
		public void tearDown() {
			if (driver!=null) {
			driver.quit();
			}
		}	
		
		
		public WebDriver getDriver() {
	        return driver;
	    }

}
