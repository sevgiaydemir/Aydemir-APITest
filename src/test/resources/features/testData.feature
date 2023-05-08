Feature: API Get Request
  Scenario: Testing Gender Query Parameter
    Given I have a valid url and endpoint
    When I send a get request with a valid gender query paramater
    Then I should receive a response with the expected status code and header
    Then I should receive a response with expected data

  Scenario: Testing Multiple User Query Parameter
    Given I have a valid url and endpoint
    When I send a get request with a valid multiple user query paramater
    Then I should receive a response with the expected status code and header
    Then I should receive a response with expected count of data





