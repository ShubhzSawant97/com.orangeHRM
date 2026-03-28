package com.orangeHRMcucumber.Stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.orangeHRMcucumber.Base.Base;
import com.orangeHRMcucumber.pages.Adminpage;
import com.orangeHRMcucumber.utils.Commonactions;
import com.orangeHRMcucumber.utils.ReadConfig;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminSteps {
	private WebDriver driver;
	private Adminpage admin;
	ReadConfig config;
	private Commonactions ca;

	public AdminSteps(Base base) throws EncryptedDocumentException, IOException {
		this.driver = base.getDriver();
		admin = new Adminpage(driver);
		config = new ReadConfig();
		ca = new Commonactions(driver);
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

	@When("user adds the following system users")
	public void user_adds_the_following_system_users(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			admin.clickAddbutton();

			admin.Userrole(row.get("UserRole"));
			admin.EmployeeName(row.get("EmployeeName"));
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

	@Given("user enters with the existing username")
	public void user_enters_with_the_existing_username() {
		admin.EnterUserName(config.GetUsername());
	}

	@When("select the user role")
	public void select_the_user_role() {
		admin.Userrole(config.getUserRole());
	}

	@When("user clicks on search button")
	public void user_clicks_on_search_button() {
		admin.clickOnSearch();
	}

	@Then("result should be shown")
	public void result_should_be_shown() {
		Assert.assertEquals("Admin", admin.verifySearchResult());
	}

	@Given("user searches for existing username")
	public void user_searches_for_existing_username() {
		admin.EnterUserName(config.GetUsername());
		admin.clickOnSearch();
	}

	@When("user clicks on Edit button")
	public void user_clicks_on_edit_button() {
		admin.clickOnEditbutton();
	}

	@When("user enters all the details")
	public void user_enters_all_the_details() {
		admin.EmployeeName("James");
		admin.EnterUserName("Chadmin");

	}

	@When("user clicks on save button")
	public void user_clicks_on_save_button() {
		admin.ClickOnSave();
	}

	@Then("user edit successfully")
	public void user_edit_successfully() {
		String msg = admin.verifytoastmsg();
		Assert.assertEquals(msg, "Successfully Updated");
	}
	
	@Given("user Enters the  username {string}")
	public void user_Enters_the_username(String username) {
		admin.EnterUserName(username);
	}
	@When("user clicks on delete button for the selected user")
	public void user_clicks_on_delete_button_for_the_selected_user() {
	    admin.deleteuser();
	}
	@When("user confirms the delete action")
	public void user_confirms_the_delete_action() {
	    admin.confirmdelete();
	}
	@Then("user should be deleted successfully")
	public void user_should_be_deleted_successfully() {
		String DeleteToastmsg = admin.verifydeletetoast();
		Assert.assertEquals(DeleteToastmsg, "Successfully Deleted");
	}
	
	@Given("user extracts all records from the admin user table")
	public void user_extracts_all_records_from_the_admin_user_table() {
	    admin.adminuserlist();
	}
	@When("user writes the records into an Excel file")
	public void user_writes_the_records_into_an_excel_file() throws EncryptedDocumentException, IOException {
	 admin.writetoexcel(); 
	}
	@Then("Excel file should contain all user details")
	public void excel_file_should_contain_all_user_details() {
	   System.out.println("v");
	}
	
	@Given("user clicks on the job titles")
	public void user_clicks_on_the_job_titles() {
	    admin.clickOnjobdropdown();
	}
	@When("user clicks on Add button")
	public void user_clicks_on_Add_button() {
		admin.clickAddbutton();
	}
	@When("user enter the job details")
	public void user_enter_the_job_details(){
	 List<Map<String,String>> data = ca.readexceldata();
	 Map<String,String> jobData = data.get(0); 
	 admin.enterjobdetails(jobData);
	}
	@Then("user save the job successfully")
	public void user_save_the_job_successfully() {
	    admin.ClickOnSave();
	   Assert.assertEquals(admin.verifytoastmsg(),"Successfully Saved");
	}


}
