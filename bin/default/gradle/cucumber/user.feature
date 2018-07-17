Feature: User Profile

  Scenario: Fetch User Info for a valid User Id
    Given I have a valid user id with me
    When I make a request to fetch user info for user with id 12345
    Then system will return user information with 200 response status

  Scenario: Fetch User Info for a invalid User Id
    Given I have a invalid user id with me
    When I make a request to fetch user info for user with id abcd
    Then system will return user information with 404 response status
