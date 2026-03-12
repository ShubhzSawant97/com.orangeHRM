Feature: Admin functionality

  Background:
    Given user logs into the application
    When user clicks on Admin menu

  @order2
  Scenario: Verify Admin page access
    Then user should be redirected to the Admin page

  @order3
  Scenario: Successfully add a new system user
    When user adds the following system users
      | UserRole | EmployeeName | Status  | UserName    | Password  | ConfirmPassword |
      | Admin    | James        | Enabled | h@gmail.com | Testing1! | Testing1!       |
      | ESS      | James        | Enabled | f@gmail.com | Testing1! | Testing1!       |
    Then user successfully gets created

  @order4
  Scenario: Search for user
    Given user enters with the existing username
    When select the user role
    And user clicks on search button
    Then result should be shown

  @order5
  Scenario: Edit the user
    Given user searches for existing username
    When user clicks on Edit button
    And user enters all the details
    And user clicks on save button
    Then user edit successfully

  @order6
  Scenario: Delete the user
    Given user Enters the  username "bbauqgmq"
    When user clicks on search button
    And user clicks on delete button for the selected user
    And user confirms the delete action
    Then user should be deleted successfully


  @order7
  Scenario: Export user list to Excel
    Given user extracts all records from the admin user table
    When user writes the records into an Excel file
    Then Excel file should contain all user details

    
    @order8
    Scenario:User create new job
    Given User clicks on the job titles
    When user clicks on Edit button
    And user clicks on Edit button
    And User enter the job details
    Then User save the job successfully