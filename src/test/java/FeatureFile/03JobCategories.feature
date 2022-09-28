Feature: feature to test website functionality

  Scenario: Check new job categories  is added
    Given Enter username and password and click login
    When User navigate to the PIM page click on Admin page
    And User navigates to the User Management page click on job dropdown select job categorie in dropdown option
    Then Click on add button and fill job categorie and click save
    And Verify the job categorie and click on logout