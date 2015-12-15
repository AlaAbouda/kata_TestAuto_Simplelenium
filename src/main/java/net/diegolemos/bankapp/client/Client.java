/*
 * Name of class : Client
 *
 * Description   : Clients management
 *
 * Version       : 1.0
 *
 * Date          : 15/12/2015
 * 
 * Copyright     : Talan Tunis
 */


package net.diegolemos.bankapp.client;

import java.io.IOException;

import net.codestory.simplelenium.SeleniumTest;

import org.openqa.selenium.By;


public class Client extends SeleniumTest {

	
	
	//Add client
		public void addNewClient(String nameClient) throws InterruptedException, IOException {
			System.out.println( "Add client");
			find(By.name(Reposetory.getTxtNameClient())).sendKeys(nameClient);
			find(By.name(Reposetory.getBtnNameAdd())).click();
		}
	
	
	
	public static class Reposetory {

		
		
		public static String getTxtNameClient()
		{
			return "addClientInput";
		}
		
		public static String getBtnNameAdd()
		{
			return "addClientBtn";
		}
		
		

	}


	@Override
	protected String getDefaultBaseUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
