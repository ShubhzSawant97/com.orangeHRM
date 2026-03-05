Feature: Admin functionality

Scenario: Verify Admin page access
Given user is on login page
When user logs into the application
And user clicks on Admin menu
Then user should be redirected to the Admin page