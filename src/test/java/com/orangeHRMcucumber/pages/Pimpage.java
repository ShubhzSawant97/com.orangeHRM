package com.orangeHRMcucumber.pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRMcucumber.utils.Commonactions;

public class Pimpage {
	protected WebDriver driver;
	protected PageFactory pf;
	protected Commonactions ca;
	
	public Pimpage(WebDriver driver) throws EncryptedDocumentException, IOException {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		ca = new Commonactions(driver);
	}
	
	@FindBy(xpath="//span[text()='PIM']") WebElement Pimtab;
	
	
	public void selectpim() {
		ca.elmclick(Pimtab, "Button clicked");
	}

}
