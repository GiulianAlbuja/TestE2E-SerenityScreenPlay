@Feature
Feature: Purchase products at Swag Labs

  @TestE2E
  Scenario Outline: Purchase process
    Given I am on the store page
    And I log in with my user <user> and password <password>
    When I add a unit of the product <product1> to the cart
    And I add a unit of the product <product2> to the cart
    And I enter the cart
    When I checkout with <firstName> <lastName> <postalCode>
    Then I see the message "Thank you for your order!"
    Examples:
      | user                    | password     | product1            | product2              | firstName | lastName   | postalCode |
      | standard_user           | secret_sauce | sauce-labs-backpack | sauce-labs-bike-light | David     | Albuja     | 17035      |
      | locked_out_user         | secret_sauce | sauce-labs-backpack | sauce-labs-bike-light | Giulian   | Albuja     | 17045      |
      | problem_user            | secret_sauce | sauce-labs-backpack | sauce-labs-bike-light | Santiago  | Fajardo    | 17045      |
      | performance_glitch_user | secret_sauce | sauce-labs-backpack | sauce-labs-bike-light | Tasmy     | Evangeline | 17045      |
      | visual_user             | secret_sauce | sauce-labs-backpack | sauce-labs-bike-light | Coffe     | Fatimaria  | 17036      |
      | error_user              | secret_sauce | sauce-labs-backpack | sauce-labs-bike-light | Slayther  | Zamora     | 17036      |





