Feature: Withdraw from account with negative balance
   As a client of the bank
   I want to withdraw money from my account
   In order to have cash

Scenario: An existing client withdraws from his account with negative balance
       Given an existing client named pierre-jean with 0.0 EUR in his account
       When he withdraws 50.0 EUR from his account
       Then the new balance is 0 EUR    
       
