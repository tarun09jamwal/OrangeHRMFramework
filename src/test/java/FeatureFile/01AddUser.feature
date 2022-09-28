Feature: feature to test website functionality

  Scenario: Check new system user is added
    Given fill username and password and click login
    When User is navigate to the PIM page click on Admin page
    And User navigated to the User Management page and click Add button
    Then Fill the user details and click save
    And Verify the added user and click on logout
