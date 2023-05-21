Feature: This feature will be used to test the login functionlity of SwagsLab

  Scenario: Login Success Scenario using parameters
    Given I have launched the application
    When I enter username as "standard_user"
    And I enter password as "secret_sauce"
    And Click on login
    Then I should be able to login successfully

  Scenario Outline: Login Success Scenario using parameters
    Given I have launched the application
    When I enter username as "<UserName>"
    And I enter password as "<Password>"
    And Click on login
    Then I should get error message "<Error>"

    Examples: 
      | UserName        | Password     | Error                                                                     |
      | standard_user   |        1234 | Epic sadface: Username and password do not match any user in this service |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
