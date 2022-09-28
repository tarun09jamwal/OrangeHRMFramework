Feature: feature to test website functionality

  Scenario: Check Employment status  is added
    Given User is logged in
    When  navigate Admin page
    And User navigates to the User Management page click on job dropdown select Employment Status in dropdown option
    Then Click on add button and fill Employment Status and click save
    And Verify the Employment Status and click on logout