Feature: Delete comment
  As an application's user
  I want to be able delete comment from application

  Scenario: Delete existing comment - success
    Given there is existing comment in application
    When user removes post from application
    Then delete operation succeeds

  Scenario: Delete not existing comment - no error
    Given there is not existing post in application
    When user removes post from application
    Then delete operation succeeds