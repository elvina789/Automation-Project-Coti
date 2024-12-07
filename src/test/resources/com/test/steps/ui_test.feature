Feature: UI Testing
  Verify the UI flow, we only tested terms on condition example, because this the only flow working on my local computer

  Scenario: Simple flow to recreate metamask wallet
    Given I go to Coti page
    And I click on treasury button
    And I click on metamask check box
    Then I click on metamask select button
    Then I click on confirm button on metamask
    Then I insert new password
    And I click on checkbox
    And i click on import my wallet
    And I click on done
    And i click on next

  Scenario: Simple flow after creating metamask wallet
    Given I go to Coti page
    And I click on enter treasury button
    And I click on metamask check box
    And I go to metamask wallet
    And I insert password
    And I click on unlock

  Scenario: Simple flow interacting with metamask wallet
    Given I go to Coti page
    And I click on enter treasury button
    And I reload the page
    And I click on enter treasury button
    And I click on metamask check box
    And I click on coti select button
#    And I insert password
#    And I click on unlock

