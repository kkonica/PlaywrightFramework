Feature: Test amazon product page

  @smoketest
  Scenario: Verify if product features are visible for second highest priced Samsung TV
    Given I open the URL
    When I click on Search input box
    And I search for item
    And I click on second item link
    When I click on Add to Cart button
    Then TV should be added in the cart

  @smoketest
  Scenario: Verify if product features are visible for second highest priced Samsung TV
    Given I open the URL
    When I click on Search input box
    And I search for item
    And I click on second item link
    When I click on Add to Cart button
    Then TV should be added in the cart invalid