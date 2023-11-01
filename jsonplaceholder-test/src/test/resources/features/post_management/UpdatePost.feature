Feature: Update existing post
  As an application's user
  I want to be able update existing post in application

  Scenario Outline: Update existing post with <description> - success
    Given there is existing post in application
    When user updates post with present fields: 'title' = <titleAvailable>, 'body' = <bodyAvailable>
    Then update operation succeeds
    And post is updated with new values

    Examples:
      | description        | titleAvailable | bodyAvailable |
      | present all fields | true           | true          |
      | new title          | true           | false         |
      | new body           | false          | true          |
      | absent new fields  | false          | false         |