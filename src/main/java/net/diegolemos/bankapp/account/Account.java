/*
 * Name of class : Account
 *
 * Description   : Accounts management
 *
 * Version       : 1.0
 *
 * Date          : 15/12/2015
 * 
 * Copyright     : Talan Tunis
 */



package net.diegolemos.bankapp.account;

import java.io.IOException;

import net.codestory.simplelenium.SeleniumTest;

import org.openqa.selenium.By;

import bibliotheque.Report;
import bibliotheque.VerifElement;

public class Account extends SeleniumTest {
	
		//Search client and verification
		public void searchClient(String nameClient, Report rapport) throws Exception {
			System.out.println( "Search client and verification");
			find(Reposetory.getTxtIdClient()).sendKeys(nameClient);
			find(By.name(Reposetory.getBtnNameSearch())).click();
			
			VerifElement verification=new VerifElement();
			boolean Resultat_ObtenuMsg1 = verification.IsTestElementPresent_True(Reposetory.getLblPathNameClient(nameClient));
		    verification.ValidResultat_obtenu_attendu(Resultat_ObtenuMsg1, true,rapport,"Verify the name of client = "+nameClient);
		
		}
		
		//Search client
				public void searchClientSimple(String nameClient) throws Exception {
					System.out.println( "Search client");
					find(Reposetory.getTxtIdClient()).sendKeys(nameClient);
					find(By.name(Reposetory.getBtnNameSearch())).click();
				}
		
		
			//Add an account
			public void addNewTransaction(String amount, String type, String position) throws InterruptedException, IOException {
				System.out.println( "Add account");
				find(By.name(Reposetory.getBtnNameAddTransaction())).click();
				find(By.xpath(Reposetory.getTxtNameAmount(position))).fill(amount);
				find(By.xpath(Reposetory.getCmbNameType(position))).selectByValue(type);
				find(By.name(Reposetory.getBtnNameSave())).click();
				Thread.sleep(2000L);
			}
			
			
			//Verify balance value 
			public void verificationValueBalance(String valueBalance, Report rapport) throws Exception {
				System.out.println( "Verify balance value = "+valueBalance);
				VerifElement verification=new VerifElement();
				boolean Resultat_ObtenuMsg1 = verification.IsTestElementPresent_True(Reposetory.getLblPathBalance(valueBalance));
			    verification.ValidResultat_obtenu_attendu(Resultat_ObtenuMsg1, true,rapport,"Verify balance value = "+valueBalance);
			}
			
			//Get the number of rows of transactions 
			public  int getNBTransaction() {
			   int xpathCount =  find(By.xpath(Reposetory.getTxtNameAmountAll())).driver().findElements(By.xpath(Reposetory.getTxtNameAmountAll())).size();
			   return (xpathCount);
			}
			
			
	public static class Reposetory {
		
		public static String getTxtIdClient()
		{
			return "#input-username";
		}
		
		public static String getBtnNameSearch()
		{
			return "searchUserBtn";
		}
		
		public static String getBtnNameAddTransaction()
		{
			return "addTransactionBtn";
		}
		
		public static String getTxtNameAmount(String position)
		{
			return "(//*[@name='amount'])["+position+"]";
		}
		
		public static String getCmbNameType(String position)
		{
			return "(//*[@name='type'])["+position+"]";
		}
		
		public static String getBtnNameSave()
		{
			return "saveNewTransactionBtn";
		}
		
		public static String getLblPathBalance(String valueBalance)
		{
			return ".//*[@class='ng-binding' and (text() = '"+valueBalance+" EUR')]";
		}
		
		public static String getLblPathNameClient(String nameClient)
		{
			return ".//*[@class='panel-heading ng-binding' and contains(text(),'"+nameClient+"')]";
		}
		
		public static String getTxtNameAmountAll()
		{
			return ".//*[@name='amount']";
		}

	}


	@Override
	protected String getDefaultBaseUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
