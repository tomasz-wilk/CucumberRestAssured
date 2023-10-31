Feature: Update existing comment
  As an application's user
  I want to be able update existing comment in application

  Scenario: Update existing comment - success
    Given there is existing comment in application
    When user updates comment with new values
    Then update operation succeeds
    And comment is updated with new values