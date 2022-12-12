Feature: get a specific actor.

  Scenario Outline: Getting a specific actor from the database.
    Given Actor exists with id <ActorID>
    When I request the actors details
    Then The web page should show the first name "<firstName>" and last name "<lastName>"
    Examples:
      | ActorID | firstName | lastName   |
      |    1    | PENELOPE  | GUINESS    |
      |    5    |JOHNNY     |LOLLOBRIGIDA|
      |    3    | ED        | CHASE      |

