package com.orangeHRMcucumber.Stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.orangeHRMcucumber.Base.Base;
import com.orangeHRMcucumber.pages.Adminpage;
import com.orangeHRMcucumber.utils.ReadConfig;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminSteps {
	private WebDriver driver;
	private Adminpage admin;
	ReadConfig config;

	public AdminSteps(Base base) {
		this.driver = base.getDriver();
		admin = new Adminpage(driver);
		config = new ReadConfig();
	}


	@Given("user logs into the application")
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

	@When("user clicks on Admin tab")
	public void user_clicks_on_Admin_tab() {
		admin.clickAdmintab();
	}

	@When("user adds the following system users")
	public void user_adds_the_following_system_users(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class,String.class);
		for(Map<String, String> row: data) {
			admin.clickAddbutton();
			
			admin.Userrole(row.get("UserRole"));
			admin.EmployerName(row.get("EmployeeName"));
			admin.SelectStatus(row.get("Status"));
			admin.EnterUserName(row.get("UserName"));
			admin.EnterUserPassword(row.get("Password"));
			admin.EnterUserConfirmPassword(row.get("ConfirmPassword"));
			
			admin.ClickOnSave();
		}
	}

	@Then("user successfully gets created")
	public void user_successfully_gets_created() {
		System.out.println("User created");
	}

}
