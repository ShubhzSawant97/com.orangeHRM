package com.orangeHRMcucumber.Stepdefinition;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.orangeHRMcucumber.Base.Base;
import com.orangeHRMcucumber.pages.Loginpage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition {
	private WebDriver driver;
	private Loginpage lp;

	public Stepdefinition(Base base) throws EncryptedDocumentException, IOException {
		this.driver = base.getDriver();
		this.lp = new Loginpage();
	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("User is on loginpage");
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		lp.Enterusername(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		lp.EnterPassword(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		lp.clickonlogin();
	}

	@Then("user should see {string}")
	public void user_should_see(String result) {
		if (result.equals("homepage")) {
			Assert.assertTrue(lp.VerifyHomeUrl());

		} else {
			Assert.assertTrue(lp.VerifyInvalidnav());
		}
	}

}
