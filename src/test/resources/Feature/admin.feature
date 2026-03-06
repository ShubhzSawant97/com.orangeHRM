Feature: Admin functionality

Background:
Given user logs into the application

Scenario: Verify Admin page access
When user clicks on Admin menu
Then user should be redirected to the Admin page

Scenario: Successfully add a new system user 
When user clicks on Admin tab
And user adds the following system users
| UserRole | EmployeeName | Status | UserName | Password | ConfirmPassword |
| Admin | James | Enabled | p@gmail.com | Testing1! | Testing1! |
| ESS   | Rahul | Enabled | m@gmail.com | Testing1! | Testing1! |
Then user successfully gets created