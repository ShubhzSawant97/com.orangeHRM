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
| UserRole | EmployeeName | Status | UserName | Password | ConfirmPassword |
| Admin | James | Enabled | h@gmail.com | Testing1! | Testing1! |
| ESS   | James | Enabled | f@gmail.com | Testing1! | Testing1! |
Then user successfully gets created

@smoke
@order4
Scenario: Search for user 
Given user enters with the existing username
When select the user role
And user clicks on search button
Then result should be shown