@tag
Feature: 
Product Validation
Background:
Given I land on the e commercr website

@tag2
 Scenario Outline: Product Validation Before placing order
    Given I log in with <name> and <password>
    When I add product in the cart
    Then I verify the ordered product

    Examples: 
      | name                       | password    | status  |
      | 72vivekpandey72@gmail.com  |Vivek12345@  | fail    |