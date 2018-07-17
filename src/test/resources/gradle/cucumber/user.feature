Feature: User Profile

  Scenario: Fetch User Info for a valid User Id
    Given I have a valid user id with me
    When I make a request to fetch user info with id "12345"
    Then system will return user information with 200 response status

