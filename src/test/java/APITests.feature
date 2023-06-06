Feature: API Tests

 Background:
    * url 'https://api.openweathermap.org/data/2.5'
    * configure headers = { 'Content-Type': 'application/json' }

# Test to verify if response contains name of the city as London 
  Scenario: Get weather information for a valid city
    Given path 'weather'
    And param q = 'London'
    And param appid = '8ee7ebb46dfddd6baecb119d58650940'
    When method get
    Then status 200
    And match response.name == 'London'

# Test if city name is invalid then return 'city not found' message 
  Scenario: Get weather information for an invalid city
    Given path 'weather'
    And param q = 'Invalid'
    And param appid = '8ee7ebb46dfddd6baecb119d58650940'
    When method get
    Then status 404
    And match response.message == 'city not found'
    