Feature: transfer money from a client to another
   As a client of the bank
   I want to transfer money from my account
   to another account

#1
   Scenario: client transfers money from his account to another when he have enought 
       Given an existing client named pierre-jean with 100.0 EUR in his account 	
        	 And an existing client named François with 50.0 EUR in his account	
       When pierre-jean  transfers 10.0 EUR from his account to François account
       Then  the new balance of pierre-jean will be 90.0 EUR 
			 And the new balance of François will be 60.0 EUR

#2
 Scenario: client transfers money from his account to another when he dont have enought
       Given an existing client named pierre-jean with 0.0 EUR in his account 	
        	 And an existing client named François with 50.0 EUR in his account	
       When pierre-jean  transfers 10.0 EUR from his account to François account
       Then  the new balance of pierre-jean will be 0.0 EUR 
			 And the new balance of François will be 50.0 EUR