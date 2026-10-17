@US-0001
Feature: AS a Diagnostic Engineer I WANT to see the current low-beam light state SO THAT I can monitor the vehicle lights

  @UC1
  Scenario: The low-beam light state is displayed as ON when the vehicle’s low-beam lights are on
    Given the vehicle's low-beam lights are on
    When the low-beam light state is requested
    Then the low-beam light state is returned as ON

  @UC2
  Scenario: The low-beam light state is displayed as OFF when the vehicle’s low-beam lights are off
    Given the vehicle's low-beam lights are off
    When the low-beam light state is requested
    Then the low-beam light state is returned as OFF

  @UC3
  Scenario: Low-beam light state cannot be displayed when the vehicle is not connected
    Given the vehicle is not connected
    When the low-beam light state is requested
    Then the error "Cannot connect to the vehicle" is returned

  @UC4
  Scenario: Low-beam light state cannot be displayed when an internal vehicle error occurs
    Given an internal vehicle error occurs
    When the low-beam light state is requested
    Then the error "Internal vehicle error" is returned

  @UC5
  Scenario: Low-beam light state cannot be displayed when the vehicle does not respond in time
    Given the vehicle does not respond within 5 seconds
    When the low-beam light state is requested
    Then the error "Vehicle not responding" is returned