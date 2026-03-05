	package com.orangeHRMcucumber.pages;
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	
	import com.orangeHRMcucumber.utils.Commonactions;
	
	public class Loginpage {
		protected WebDriver driver;
		protected Commonactions ca;
		public Loginpage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			ca = new Commonactions(driver);
		}
		
		 @FindBy (xpath = "//input[@name='username']") private WebElement UsernameInput;
	
		 @FindBy (xpath = "//input[@type='password']") private WebElement PasswordInput;
		 
		 @FindBy (xpath = "//button[@type='submit']") private WebElement SubmitButton;
		 
		 @FindBy (xpath = "//a[text()='Logout']") private WebElement logoutbutton;
		 
		 @FindBy (xpath = "//img[@class= 'oxd-userdropdown-img']") private WebElement Profileicon;
		 
		 @FindBy (xpath = "//div[@role ='alert']") private WebElement invalidloginalert;
		 
		 @FindBy (xpath = "//span[text()='Admin']") private WebElement AdminTab;
		 
		 
		 public void clickonlogin() {
			 ca.elmclick(SubmitButton, "User is able to click successfully");
		 }
		 
		 public void Enterusername(String username) {
			ca.enterinput(UsernameInput, "Username Entered", username);
		 }
		 
		 public void EnterPassword(String password) {
			 ca.enterinput(PasswordInput,"Password Entered", password);
		 }
		 public boolean  VerifyHomeUrl() {
			 return ca.verifynav("dashboard");
			 }
		 
		 public boolean VerifyInvalidnav() {
			 return ca.verifynav("login");
			 }
	}
