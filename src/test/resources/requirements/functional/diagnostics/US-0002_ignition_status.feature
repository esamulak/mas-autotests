@US-0002
Feature: AS a Diagnostic Engineer I WANT to see a vehicle's ignition status remotely SO THAT I know if it is ready for diagnosis

  @UC1
  Scenario Outline: The ignition status is displayed as <status>
    Given the vehicle reports the ignition:
      | status | <status> |
    When the ignition status is requested
    Then the ignition details are returned:
      | status | <status> |

    Examples:
      | status |
      | ON     |
      | OFF    |

  @UC2
  Scenario Outline: Ignition status cannot be displayed when the vehicle <issue>
    Given the vehicle <issue>
    When the ignition status is requested
    Then the error details are returned:
      | errorMessage | <error message> |

    Examples:
      | issue                         | error message                |
      | is not connected              | No connection to the vehicle |
      | reports an internal error     | Vehicle software error       |
      | takes too long to respond     | Vehicle is not responding    |
      | reports an invalid data error | Vehicle software error       |

  @UC3
  Scenario Outline: Ignition status cannot be displayed when the application throws an unexpected error
    Given the vehicle's ignition is <status>
      And the application throws an unexpected error
    When the ignition status is requested
    Then the error details are returned:
      | errorMessage | Unexpected application error |

    Examples:
      | status |
      | ON     |
      | OFF    |
