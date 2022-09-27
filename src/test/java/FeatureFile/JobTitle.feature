Feature: feature to test website functionality

  Scenario: Check new job title is added
    Given fill username and password and click login
    When User is navigate to the PIM page click on Admin page
    And User navigated to the User Management page click on job dropdown select job title in dropdown option
    And click on add button on job titles page
    Then Fill the job title details and click save
    And Verify the added job title  and click on logout
