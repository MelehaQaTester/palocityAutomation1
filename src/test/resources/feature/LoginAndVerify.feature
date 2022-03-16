Feature: I want to input my employee data so that i can get a preview of benefit cost

  Background: Login to the website
    Given User input their credentials

  Scenario: Add employee
    When User is on the Benefits Dashboard Page
    Then Select Add employee
    When I can enter employees details
    And The employee detail should be saved
    And I should see the employee in the table
    And the Benefit cost calculation
