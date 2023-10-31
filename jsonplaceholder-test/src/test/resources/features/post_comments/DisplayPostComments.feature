Feature: Display all post's comments
  As an application's user
  I want to be able to see all comments for post

  Scenario: Display all comments for the post
    Given there is existing post in application
    When all comments for post are requested
    Then list of comments is returned not empty
    And all comments are assigned to requested post