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
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	String path = System.getProperty("user.dir")+ "/src/test/resources/testData/UserData.xlsx";
	FileInputStream fs;
	Workbook wb;
	
	public Commonactions(WebDriver driver) throws EncryptedDocumentException, IOException {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		fs = new FileInputStream(path);
		wb = WorkbookFactory.create(fs);
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
		
		public List<Map<String,String>> listvalues(List<WebElement> rows, List<WebElement> headers){
		
			List<Map<String,String>> table = new ArrayList<>();
			for (WebElement row: rows) {
				List<WebElement> cells  = wait.until(ExpectedConditions.visibilityOfAllElements( row.findElements(By.xpath(".//div[@role='cell']"))));
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
	
	public void WriteExcel(List<Map<String,String>> data) throws EncryptedDocumentException, IOException {
		Sheet sheet = wb.getSheet("Sheet1");
		int rownum = 0;
		Row header = sheet.createRow(rownum++);
		
		int cellnum = 0;
		for (String key : data.get(0).keySet()) {
			 header.createCell(cellnum++).setCellValue(key);
		}
		
		  for(Map<String,String> map : data){

		        Row row = sheet.createRow(rownum++);
		        cellnum = 0;

		        for(String value : map.values()){
		            row.createCell(cellnum++).setCellValue(value);
		        }
		    }
		  FileOutputStream fos = new FileOutputStream(path);
		    wb.write(fos);

		    fos.close();
		    wb.close();
	}
	
	public List<Map<String,String>>  readexceldata() {
		Sheet sheet = wb.getSheet("Sheet2");
		List<Map<String,String>> data = new ArrayList<>();
		Row headerRow = sheet.getRow(0);
		
		  for(int i=1;i<=sheet.getLastRowNum();i++){
		        Row row = sheet.getRow(i);
		        Map<String,String> map = new HashMap<>();

		        for(int j=0;j<headerRow.getLastCellNum();j++){
		            String key = headerRow.getCell(j).toString();
		            Cell cell = row.getCell(j);
		            String value = "";

		            if(cell != null) {
		                value = cell.toString();
		            }

		            map.put(key,value);
		        }
		        data.add(map);
	}
		  System.out.println(data);
		    return data;

	}
	
	
 
}
