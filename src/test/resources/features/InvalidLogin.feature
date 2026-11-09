Feature: SauceDemo Invalid Login
  As a visitor with wrong credentials
  I want to be told my login failed
  So that I know I cannot get into the store

@smoke @regression @Login
Scenario: Invalid username and password are rejected
  Given the user is on the login page
  When the user enters invalid username and password
  Then the user should see an error message
