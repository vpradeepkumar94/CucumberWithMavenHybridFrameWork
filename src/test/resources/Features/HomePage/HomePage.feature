@smokeTest
Feature: Verify Application Home Page Title

  Scenario: I want to know the AUT  Home Page title
    Given I  launch the application url
    When the page is loaded
    Then the page title should be displayed
