Feature: Security tests scenarios

  Scenario: validate sign in functionality with valid credential
    When user click on sign in link
    Then validate user is in sign in page
    When user enter "ziamustafa2000@hotmail.com" and "786@Allah" and click on login
    # When user enter username and password and click on login
    Then user should be able to see account link




    #Task First implement this below scenarios and then Apply Scenario Outline

  Scenario: Validate sign in with invalid username valid password
    When user click on sign in link
    Then validate user is in sign in page
    When user enter "invalid@gmail.com" and "786@allah" and click on login
    Then user should see error "wrong username or password"

  Scenario: Validate sign in with invalid username valid password
    When user click on sign in link
    Then validate user is in sign in page
    When user enter "ziamustafa2000@hotmail.com" and "WrongPassword" and click on login
    Then user should see error "wrong username or password"