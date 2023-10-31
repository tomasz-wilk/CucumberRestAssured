Feature: Delete post
  As an application's user
  I want to be able delete post from application

  Scenario: Delete existing post - success
    Given there is existing post in application
    When user removes post from application
    Then delete operation succeeds

  Scenario: Delete not existing post - no error
    Given there is not existing post in application
    When user removes post from application
    Then delete operation succeeds