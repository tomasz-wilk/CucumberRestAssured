Feature: Update existing comment
  As an application's user
  I want to be able update existing comment in application

  Scenario Outline: Update existing comment with <description> - success
    Given there is existing comment in application
    When user updates comment with present fields: 'name' = <nameAvailable>, 'email' = <emailAvailable>, 'body' = <bodyAvailable>
    Then update operation succeeds
    And comment is updated with new values

    Examples:
      | description        | nameAvailable | emailAvailable | bodyAvailable |
      | present all fields | true          | true           | true          |
      | new name           | true          | false          | false         |
      | new email          | false         | true           | false         |
      | new body           | false         | false          | true          |
      | absent new fields  | false         | false          | false         |