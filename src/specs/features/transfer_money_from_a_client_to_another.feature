Feature: transfer money from a client to another
   As a client of the bank
   I want to transfer money from my account
   to another account

   Scenario: transfer client''s money from his account to another 
       Given an existing client named 'pierre-jean' with 100.0 EUR in his account 	
        	 and another existing client named 'François' with 50.0 EUR in his account	
       When 'pierre-jean'  transfers 10.0 EUR from his account to François's account
       Then  The new balance of 'pierre-jean' will be 90.0 EUR 
			 and the balance of 'François' will be 60.0 EUR


   Scenario: transfer client''s money from his account to another with with giver''s balance = 0.0 EUR
       Given an existing client named 'pierre-jean' with 0.0 EUR in his account 	
        	 and another existing client named 'François' with 50.0 EUR in his account	
       When 'pierre-jean'  transfers 10.0 EUR from his account to François's account
       Then The new balance of 'pierre-jean' will be 0.0 EUR,
			the balance of 'François' will be 50.0 EUR 
			and no transaction added.
