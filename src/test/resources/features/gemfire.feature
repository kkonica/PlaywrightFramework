Feature: Test gemfire UI

  @test
  Scenario: Login using the cluster url
    Given the user visits gemfire app url
    When the user enables developer mode
    Then verify if the user is logged in
    When the user connects the locator
    Then cluster members and regions are visible