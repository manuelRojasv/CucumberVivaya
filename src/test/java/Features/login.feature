Feature: Feature to test basic Login in Vivaya

  Scenario: Check login and Logout is successful with Guide credentials
    Given User is in Home page
    And  Press Login link
    When Guide enters his valid credentials username and password
    And  Press Login button
    Then Guide is redirected to his Dashboard
    And  Press Logout link
    Then User is redirected to Home page

  Scenario: Check login and Logout is successful with Seeker credentials
    Given User is in Home page
    And  Press Login link
    When Seeker enters his valid credentials username and password
    And  Press Login button
    Then Seeker is redirected to his Dashboard
    And  Press Logout link
    Then User is redirected to Home page