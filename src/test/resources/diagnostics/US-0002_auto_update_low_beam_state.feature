@US-0002
Feature: AS a Diagnostic Engineer I WANT the low-beam light state to be updated automatically when it changes in the vehicle SO THAT I always see the current state without refreshing manually.

  @UC1
  Scenario Outline: The displayed low-beam light state is automatically updated
    Given the vehicle's low-beam lights are <initial>
    When the low-beam lights are switched to <target>
    Then the displayed low-beam light state is automatically updated to <target>

    Examples:
      | initial | target |
      | OFF     | ON     |
      | ON      | OFF    |

  @UC2
  Scenario Outline: The displayed low-beam light state is not updated when an error occurs
    Given the vehicle's low-beam lights are <initial>
      And the update fails with the error "<error>"
    When the low-beam lights are switched to <target>
    Then the displayed low-beam light state is not updated

    Examples:
      | initial | target | error                                   |
      | OFF     | ON     | Cannot connect to the diagnostic screen |
      | OFF     | ON     | Internal server error                   |
      | OFF     | ON     | Diagnostic screen not responding        |
      | ON      | OFF    | Cannot connect to the diagnostic screen |
      | ON      | OFF    | Internal server error                   |
      | ON      | OFF    | Diagnostic screen not responding        |
