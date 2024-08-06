Feature: Create new account functionality


  Scenario: create valid account with random email
    Given user click on "Sign in" link
    Then validate user is in sign in page
    Given user click on "Create New Account" link
    When user enter "Zia" and "random"  and "786@Allah"
    When user click on "Sign Up" button
    Then validate user is in account page
    Then validate email address in account page match

  Scenario: Create account with existing email
    Given user click on "Sign in" link
    Then validate user is in sign in page
    Given user click on "Create New Account" link
    When user enter "Zia" and "ziamustafa2000@hotmail.com"  and "786@Allah"
    When user click on "Sign Up" button
    Then user should see error "this email is already exist, please use another email address"