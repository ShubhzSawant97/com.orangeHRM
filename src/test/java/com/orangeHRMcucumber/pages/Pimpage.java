package com.orangeHRMcucumber.pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRMcucumber.Base.Base;
import com.orangeHRMcucumber.utils.Commonactions;

public class Pimpage {
	private WebDriver driver;
	private Commonactions ca;
	
	public Pimpage() throws EncryptedDocumentException, IOException {
		this.driver=Base.getDriver();
		PageFactory.initElements(driver, this);
		ca = new Commonactions();
	}
	
	@FindBy(xpath="//span[text()='PIM']") WebElement Pimtab;
	
	
	public void selectpim() {
		ca.elmclick(Pimtab, "Button clicked");
	}

}
