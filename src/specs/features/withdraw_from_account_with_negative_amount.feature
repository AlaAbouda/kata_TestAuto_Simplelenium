Feature: Withdraw from account with negative amount
   As a client of the bank
   I want to withdraw money from my account
   In order to have cash
 
     Scenario: An existing client withdraws from his account
       Given an existing client named pierre-jean with 20.0 EUR in his account
       When he deposit -10.0 EUR from his account
       Then the new balance is 20 EUR     