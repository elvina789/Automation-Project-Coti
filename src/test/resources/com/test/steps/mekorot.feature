Feature: UI Testing for Mekorot
  Scenario Outline: Simple flow for Mekorot
    Given I go to Mekorot page
    When I click on Mekorot menu
    Then I click on "About Us"
    Examples:
      |  |
