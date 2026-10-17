@US-0001
Feature: AS a Diagnostic Engineer I WANT to see the current low-beam light state SO THAT I can monitor the vehicle lights

  @UC1
  Scenario Outline: The low-beam light state is displayed as <state>
    Given the vehicle's low-beam lights are <state>
    When the low-beam light state is requested
    Then the low-beam light state is returned as <state>

    Examples:
      | state |
      | ON    |
      | OFF   |

  @UC2
  Scenario Outline: Low-beam light state cannot be displayed when the vehicle <condition>
    Given the vehicle <condition>
    When the low-beam light state is requested
    Then the error "<error>" is returned

    Examples:
      | condition                               | error                         |
      | is not connected                        | Cannot connect to the vehicle |
      | reports an internal error               | Vehicle software error        |
      | does not respond within 5 seconds       | Vehicle not responding        |
      | reports an invalid low-beam light state | Vehicle software error        |

  @UC3
  Scenario Outline: Low-beam light state cannot be displayed when an internal server error occurs
    Given the vehicle's low-beam lights are <state>
      And an internal server error occurs
    When the low-beam light state is requested
    Then the error "Internal server error" is returned

    Examples:
      | state |
      | ON    |
      | OFF   |
