Feature: Add new post
  As an application's user
  I want to be able add new post in application

  Scenario Outline: Add new post with <description> - success
    Given there is existing user in application
    When user adds post with present fields: 'title' = <titleAvailable>, 'body' = <bodyAvailable>
    Then post is added successfully
    And post is added with new values

    Examples:
      | description        | titleAvailable | bodyAvailable |
      | present all fields | true           | true          |
      | missing body       | true           | false         |
      | missing title      | false          | true          |
      | missing all fields | false          | false         |