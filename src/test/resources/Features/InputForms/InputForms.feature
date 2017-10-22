@smokeTest
Feature: Verify Input Fields present in the AUT

Scenario:  I want to whether I can enter values in the text box
    Given I  Navigate to inputForms page
    When the page is loaded
    Then the input fields is displayed
    And I should be able to enter message in the field
    
Scenario:  Calculate the sum of two numbers
    Given I  Navigate to inputForms page
    When the page is loaded
    And the input fields are displayed
    Then I enter 5 and 10 in the input fields
    And The result should be sum of the entered two numbers

