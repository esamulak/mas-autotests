@US-0001
Feature: AS a Diagnostic Engineer I WANT the low-beam light state to be updated automatically when it changes in the vehicle SO THAT I always see the current state without refreshing manually.

  @UC1
  Scenario: The low-beam lights are turned on and the ON state is reported
    Given the connection to the vehicle is established
      And the low-beam light state is OFF
    When the low-beam lights are switched to ON
    Then the low-beam light state is automatically updated to ON

  @UC2
  Scenario: The low-beam lights are turned off and the OFF state is reported
    Given the connection to the vehicle is established
      And the low-beam light state is ON
    When the low-beam lights are switched to OFF
    Then the low-beam light state is automatically updated to OFF
