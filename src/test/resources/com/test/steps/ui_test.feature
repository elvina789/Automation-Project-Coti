Feature: UI Testing
  Verify the UI flow, we only tested terms on condition example, because this the only flow working on my local computer

  Scenario: Simple flow
    Given I go to Coti page
    And I click on threasury button
    And I click on metamask check box
    Then I click on terms of conditions
    And Terms of use are valid
    Then I close Coti page
