package com.orangeHRMcucumber.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@FindBy (xpath="//span[text()='Admin']") private WebElement Admintab;
	
	@FindBy (xpath = "//input[@name='username']") private WebElement UsernameInput;
	
	@FindBy (xpath = "//input[@type='password']") private WebElement PasswordInput;
	
	@FindBy (xpath = "//button[@type='submit']") private WebElement SubmitButton;
	
	@FindBy (xpath = "//button[normalize-space()='Add']") private WebElement Adduser;
	
	@FindBy (xpath = "(//div[@class='oxd-select-text-input'])[1]") WebElement UserRoleDropdown;	
	
	@FindBy (xpath = "(//div[@class='oxd-select-text-input'])[2]") WebElement SelectStatus;
	
	@FindBy (xpath = "//input[@placeholder='Type for hints...']") WebElement SelectEmployerName;
	
	@FindBy (xpath = "(//input[@class='oxd-input oxd-input--active'])[2]") WebElement SelectUserName;
	
	@FindBy (xpath = "(//input[@type='password'])[1]") WebElement SelectPassword;
	
	@FindBy (xpath = "(//input[@type='password'])[2]") WebElement SelectConfirmPassword;

	@FindBy (xpath = "//button[normalize-space()='Save']") private WebElement Saveuser;
	
	@FindBy (xpath = "//div[@role='row']") private List<WebElement> SearchRsults;
	
	@FindBy (xpath = "//div[@class='oxd-loading-spinner-container']") private WebElement Spinner;
	
	@FindBy (xpath = "(//div[@class='oxd-table-cell oxd-padding-cell'])[2]") private WebElement AdminSearchResult;
	
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
	

	public void Userrole(String role) {
		ca.elmclick(UserRoleDropdown, "Role selected successfully: "+role);
		By roleOption = By.xpath("//div[@role='listbox']//span[text()='"+role+"']");
		driver.findElement(roleOption).click();
	}
	
	public void EmployerName(String Employername) {
		ca.enterinput(SelectEmployerName, "EmployeeName entered: ", Employername);
		By Suggestion = By.xpath("//div[@role='listbox']//span[contains(text(),'"+Employername+"')]");
		driver.findElement(Suggestion).click();
	}
	
	public void SelectStatus(String Status) {
		ca.elmclick(SelectStatus, "Status input field clicked");
		By statusselection = By.xpath("//div[@role='listbox']//span[text()='"+Status+"']");
		driver.findElement(statusselection).click();
	}
	
	public void EnterUserName(String username) {
		ca.enterinput(SelectUserName, "Username Entered: ", username);
	}
	
	public void EnterUserPassword(String pass) {
		ca.enterinput(SelectPassword, "Password Entered: ", pass);
	}
	
	public void EnterUserConfirmPassword(String confirmpass) {
		ca.enterinput(SelectConfirmPassword, "Confirm Password Entered: ", confirmpass);
	}
	
	public void ClickOnSave() {
		ca.elmclick(Saveuser, "User saved:");
	} 
	
	public void clickOnSearch() {
		ca.elmclick(SubmitButton, "User searched");
	}
	
	public String verifySearchResult(){
		return ca.verifySearchResult(AdminSearchResult, Spinner);
		
	}
}
