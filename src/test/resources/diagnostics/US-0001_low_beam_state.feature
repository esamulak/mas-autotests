@US-0001
Feature: AS a Diagnostic Engineer I WANT to see the current low-beam light state SO THAT I can monitor the vehicle lights

  @UC1
  Scenario: The low-beam light state is displayed as ON when the vehicle’s low-beam lights are on
    Given the connection to the vehicle is established
    And the vehicle's low-beam lights are on
    When the Diagnostic Engineer requests the low-beam light state
    Then the low-beam light state is returned as ON

  @UC2
  Scenario: The low-beam light state is displayed as OFF when the vehicle’s low-beam lights are off
    Given the connection to the vehicle is established
    And the vehicle's low-beam lights are off
    When the Diagnostic Engineer requests the low-beam light state
    Then the low-beam light state is returned as OFF

  @UC3
  Scenario: Low-beam light state cannot be displayed when the vehicle is not connected
    Given the connection to the vehicle is not established
    When the Diagnostic Engineer requests the low-beam light state
    Then the low-beam light state is not returned
    And information that the vehicle is disconnected is sent
