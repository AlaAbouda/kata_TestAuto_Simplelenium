/*
 * Name of class : MenuHeader
 *
 * Description   : The navigation of the menu
 *
 * Version       : 1.0
 *
 * Date          : 15/12/2015
 * 
 * Copyright     : Talan Tunis
 */


package net.diegolemos.bankapp.all;

import java.io.IOException;

import net.codestory.simplelenium.SeleniumTest;

import org.openqa.selenium.By;

public class MenuHeader extends SeleniumTest {

	
	//Click Clients
	public void clickClients() throws InterruptedException, IOException {
		System.out.println("Click Clients");
		find(By.xpath(Reposetory.getPathClients())).click();
	}
	
	//Click Accounts
	public void clickAccounts() throws InterruptedException, IOException {
		System.out.println("Click Accounts");
		find(By.xpath(Reposetory.getPathAccounts())).click();
	}
	
	//Click BankApp
	public void clickBankApp() throws InterruptedException, IOException {
		System.out.println("Click BankApp");
		find(By.xpath(Reposetory.getPathBankApp())).click();
	}
	
	
	public static class Reposetory {

		
		public static String getPathClients()
		{
			return ".//*[@href='#/clients']";
		}
		
		public static String getPathAccounts()
		{
			return ".//*[@href='#/accounts']";
		}
		
		public static String getPathBankApp()
		{
			return ".//*[@href='#']";
		}

	}


	@Override
	protected String getDefaultBaseUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
