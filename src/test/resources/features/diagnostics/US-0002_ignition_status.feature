@US-0002
Feature: AS a Diagnostic Engineer I WANT to see a vehicle's ignition status remotely SO THAT I know if it is ready for diagnosis

  @UC1
  Scenario Outline: The ignition status is displayed as <status>
    Given the vehicle's ignition is <status>
    When the ignition status is requested
    Then the ignition status is returned as <status>

    Examples:
      | status |
      | ON     |
      | OFF    |

  @UC2
  Scenario Outline: Ignition status cannot be displayed when the vehicle <issue>
    Given the vehicle <issue>
    When the ignition status is requested
    Then the corresponding error details are returned

    Examples:
      | issue                              |
      | is not connected                   |
      | reports an internal error          |
      | does not respond within 5 seconds  |
      | reports an invalid ignition status |

  @UC3
  Scenario Outline: Ignition status cannot be displayed when an internal server error occurs
    Given the vehicle's ignition is <status>
      And an internal server error occurs
    When the ignition status is requested
    Then the internal server error details are returned

    Examples:
      | status |
      | ON     |
      | OFF    |
