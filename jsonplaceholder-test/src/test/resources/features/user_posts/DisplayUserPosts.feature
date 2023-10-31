Feature: Display all user's posts
  As an application's user
  I want to be able to see all other user's posts

  Scenario Outline: Display all posts for <description> user
    Given there is existing = <existing> user in application
    When all posts for user are requested
    Then list of posts is returned not empty = <not empty>

    Examples:
      | description  | existing | not empty |
      | existing     | true     | true      |
      | not existing | false    | false     |