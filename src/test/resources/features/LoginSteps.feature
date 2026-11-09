Feature: SauceDemo Login

@smoke @Login
Scenario: Successful Login
  Given the user is on the login page
  When the user enters valid login credentials
  Then the user should be logged in successfully

@smoke @Login
Scenario: Logout
  Given the user is on the login page
  When the user enters valid login credentials
  Then the user should be logged in successfully
  And the user clicks the Logout link
  Then the user should be redirected to the login page