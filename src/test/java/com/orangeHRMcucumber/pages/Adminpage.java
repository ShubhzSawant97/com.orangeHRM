package com.orangeHRMcucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRMcucumber.utils.Commonactions;

public class Adminpage {
	protected WebDriver driver;
	protected PageFactory pf;
	protected Commonactions ca;
	
	public  Adminpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		ca = new Commonactions(driver);
	}
	@FindBy (xpath="//span[text()='Admin']") private WebElement Admintab;
	
	@FindBy (xpath = "//input[@name='username']") private WebElement UsernameInput;
	
	@FindBy (xpath = "//input[@type='password']") private WebElement PasswordInput;
	
	@FindBy (xpath = "//button[@type='submit']") private WebElement SubmitButton;
	
	@FindBy (xpath = "//button[@fdprocessedid='3ldpy']") private WebElement Adduser;
	
	public void Enterusername(String username) {
	ca.enterinput(UsernameInput, "Username entered", username);	
	}
	
	public void Enterpassword(String password) {
	ca.enterinput(PasswordInput, "Password entered", password);	
	}
	
	public void logintoapp() {
	ca.elmclick(SubmitButton, "Login clicked");	
	}
	
	public void clickAdmintab() {
	ca.elmclick(Admintab, "Adminoption clicked");	
	}
	
	public void clickAddbutton() {
	ca.elmclick(Adduser, "Add button clicked");	
	}
	
	public boolean verifynav() {
		return ca.verifynav("admin/viewSystemUsers");	
	}
	
	public boolean verifyusercreationnav() {
		return ca.verifynav("admin/saveSystemUser");	
	}

}
