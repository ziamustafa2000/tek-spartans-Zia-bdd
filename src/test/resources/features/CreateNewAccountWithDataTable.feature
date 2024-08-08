@Regression
Feature: Create new account functionality

#  Steps that is common between Scenarios of specific feature.
#  Background steps will execute at beginning of each scenario
  Background: Setup create account scenarios
    Given user click on "Sign in" link
    Then validate user is in sign in page
    Given user click on "Create New Account" link

  Scenario: create valid account with random email
    When user enter "Zia" and "random"  and "786@Allah"
    When user click on "Sign Up" button
    Then validate user is in account page
    Then validate email address in account page match

  @UserStory1
  Scenario: Create account with existing email
    When user enter "Zia" and "ziamustafa2000@hotmail.com"  and "786@Allah"
    When user click on "Sign Up" button
    Then user should see error "this email is already exist, please use another email address"