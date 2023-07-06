
  @tag1
  Feature: Purchasing the product on e commerce website
  
  Background:
  Given I landed on the e commerce website
  

  @tag2
  Scenario Outline: Purchasing the product on e commerce website
    Given I logged in with <name> and <password>
    When I added product in the cart
    Then I verify the product

    Examples: 
      | name                       | password    | status  |
      | 72vivekpandey72@gmail.com  |Vivek12345@  | success |
  
