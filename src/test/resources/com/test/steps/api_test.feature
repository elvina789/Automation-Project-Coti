Feature: Mock API Testing
  We created a mock service that provides login and get products and we are doing simple test on it

  @MockAPI
  Scenario: Login and fetch product list
    Given I send a login request with username "testuser" and password "password123"
    Then I should get a valid token
    When I send a request to fetch the product list with the token
    Then I should get the product list response