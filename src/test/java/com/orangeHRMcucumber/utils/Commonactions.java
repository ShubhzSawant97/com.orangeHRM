package com.orangeHRMcucumber.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Commonactions {
	
	protected WebDriverWait wait;
	
	
	public Commonactions(WebDriver driver) { 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
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
		elm.clear();
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
	
	public String verifySearchResult(WebElement elm, WebElement spinner){
		wait.until(ExpectedConditions.invisibilityOf(spinner));
		String users = elm.getText();
		System.out.println(users);
		return users;
	}
	
	public String getToastMessage(By toast) {
	    WebElement toastElement = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(toast)
	    );
	    String message = toastElement.getText();
	    System.out.println("Toast Message: " + message);
	    return message;
	}
		
		public List<Map<String,String>> listvalues(List<WebElement> rows, List<WebElement> headers, String path){
		
			List<Map<String,String>> table = new ArrayList<>();
			for (WebElement row: rows) {
				List<WebElement> cells  = wait.until(ExpectedConditions.visibilityOfAllElements( row.findElements(By.xpath(path))));
				Map<String,String> data = new LinkedHashMap<>();
				for(int i =1; i<cells.size();i++) {
					String header = headers.get(i).getText();
					String value = cells.get(i).getText();
					
					data.put(header,value);	
				}
				
				table.add(data);
			}
			System.out.println(table);
			return table;
		}
	
 
}
