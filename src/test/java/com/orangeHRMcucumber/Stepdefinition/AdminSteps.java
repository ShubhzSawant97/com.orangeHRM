package com.orangeHRMcucumber.Stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.orangeHRMcucumber.Base.Base;
import com.orangeHRMcucumber.pages.Adminpage;
import com.orangeHRMcucumber.utils.ReadConfig;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminSteps{
	private WebDriver driver;
	private Adminpage admin;
	ReadConfig config;
	public AdminSteps(Base base) {
		this.driver = base.getDriver();
		admin = new Adminpage(driver);
		config = new ReadConfig();
	}
	
	@Given("user is on login to the page")
	public void user_is_on_login_to_the_page() {
	 System.out.println("User is on admin page");
	}


	@When("user logs into the application")
	public void user_logs_into_the_application() {
		 admin.Enterusername(config.GetUsername());
		 admin.Enterpassword(config.GetPassword());
		 admin.logintoapp();
	   
	}
	@When("user clicks on Admin menu")
	public void user_clicks_on_admin_menu() {
		admin.clickAdmintab();

	}
	@Then("user should be redirected to the Admin page")
	public void user_should_be_redirected_to_the_admin_page() {
	 Assert.assertTrue(admin.verifynav());
	}



}
