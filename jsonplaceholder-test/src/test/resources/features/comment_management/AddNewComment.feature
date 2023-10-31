Feature: Add new comment
  As an application's user
  I want to be able add new comment in application

  Scenario Outline: Add new comment with <description> - success
    Given there is existing post in application
    When user adds comment with present fields: 'name' = <nameAvailable>, 'email' = <emailAvailable>, 'body' = <bodyAvailable>
    Then comment is added successfully
    And comment is added with new values

    Examples:
      | description        | nameAvailable | emailAvailable | bodyAvailable |
      | present all fields | true          | true           | true          |
      | missing name       | false         | true           | true          |
      | missing email      | true          | false          | true          |
      | missing body       | true          | true           | false         |
      | missing all fields | false         | false          | false         |