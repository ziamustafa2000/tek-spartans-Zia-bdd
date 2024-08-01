Feature: This feature to setup framework

  Scenario: Validate top left corner logo
    #Given Open browser and navigate to retail app
    Then validate top left corner is TEKSCHOOL
    #Then Close the browser

  Scenario: Validate Logo and Sign in button

  #Navigate to retail app and make sure top-left corner text in TEKSCHOOL
  #and make sure Sign in button is enabled.

    Then validate top left corner is TEKSCHOOL
    Then Validate Sign in button is Enabled

    When user click on sign in link
    When user enter username and password and click on login
    Then user should be able to see account link