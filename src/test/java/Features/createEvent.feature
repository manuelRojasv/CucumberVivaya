Feature: The Guide is able to create Events from his Dashboard

  Scenario: Guide is able to create a Class event
    Given The Guide is in the Dashboard
    And Guide press Add NEw Event button
    And Guide select Add Class
    When Guide fill all the mandatory fields
    And Guide press Add button
    Then Guide is redirected to His dashboard in order to see the created Event
    And Guide is able to Cancel the Event and the Event is not displayed



