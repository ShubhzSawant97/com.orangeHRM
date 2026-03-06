package com.orangeHRMcucumber.utils;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Commonactions {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public Commonactions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	
	public void elmclick(WebElement elm, String msg) {
		try {
		wait.until(ExpectedConditions.elementToBeClickable(elm));
		elm.click();
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void enterinput(WebElement elm, String msg, String value) {
		try {
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.sendKeys(value);
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public boolean verifynav(String expPart) {
		try {
			return  wait.until(ExpectedConditions.urlContains(expPart));
			
		} catch(Exception e) {
			return false;
			
		}
	}
	

}
