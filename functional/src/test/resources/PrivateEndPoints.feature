Feature: Private Endpoints Feature


  Scenario: Client calls private-status endpoint and receives 200 OK
    When the client makes a request to "private-status" endpoint
    Then the client receives a body of "OK"
    And the client receives a status code of 200
