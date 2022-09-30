#Author: ram222mohan@gmail.com
#Keywords Summary :
@tag
Feature: Calculator Test
  This tests the calculator operations

  @tag1
  Scenario: Add operation
    Given Create a calculator
    When I call a add operation with 1 and 2
    Then I get result as 3
