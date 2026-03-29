package com.orangeHRMcucumber.Base;

import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.orangeHRMcucumber.utils.ReadConfig;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	private static  ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	private ReadConfig rd = new ReadConfig();

	public void init() {
		WebDriver driver;
		String browser = rd.GetBrowser();
		if (tldriver.get() != null)
			return;
		try {
			switch (browser.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				tldriver.set(driver);
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				tldriver.set(driver);
				break;

			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				tldriver.set(driver);
				break;

			default:
				throw new RuntimeException("Browsers not working");
			}

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	
	public void tearDown() {
		if (tldriver.get() != null) {
			tldriver.get().quit(); 
	        tldriver.remove();
		}
	}

	public static WebDriver getDriver() {
		return tldriver.get();
	}

}
