Feature: Login
@smoke
  @order1
  Scenario Outline: Login validation
    Given user is on login page
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on login button
    Then user should see "<result>"

    Examples:
      | username | password | result    |
      | Test     | admin123 | loginpage |
      | Admin    | admin123 | homepage  |
