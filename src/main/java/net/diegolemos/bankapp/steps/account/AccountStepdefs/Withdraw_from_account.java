package net.diegolemos.bankapp.steps.account.AccountStepdefs;


import org.assertj.core.api.Assertions;

import bibliotheque.ReadConfFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.codestory.simplelenium.SeleniumTest;
import net.diegolemos.bankapp.account.Account;
import net.diegolemos.bankapp.all.MenuHeader;
import net.diegolemos.bankapp.client.Client;


public class Withdraw_from_account extends SeleniumTest {
	
	//private   String nameClient="pierre-jean";
	private Account account = new Account();
	
	@Before
	  public void initializeSystem() throws Exception {
		String[] Param_Server = ReadConfFile.Get_Info("1");	
		String Url = Param_Server[0];
		goTo(Url);
	  }
	
	 public void initializeUser(String nameClient, String Amount) throws Exception {
		 MenuHeader menu = new MenuHeader();
			//Go To Client
			menu.clickClients();
			Client client = new Client();
			//Add Client
			client.addNewClient(nameClient);
			//Go To Accounts
			menu.clickAccounts();
			//search Client
			account.searchClientSimple(nameClient);
			account.addNewTransaction( Amount, "DEPOSIT", "1");
		  }
	
	
	@Given("^an existing client named (.*) with (.*) EUR in his account$")
	public void an_existing_client_named_pierre_jean_with_EUR_in_his_account(String nameClient, String Amount) throws Throwable {
		initializeUser( nameClient,  Amount) ;
		String totalBalance = account.getBalance();
		Assertions.assertThat(Boolean.TRUE);
		Assertions.assertThat(Float.parseFloat(totalBalance)).isEqualTo(Float.parseFloat(Amount));
	}
	
	
	
	@When("^he withdraws (.*) EUR from his account$")
	public void he_withdraws_EUR_from_his_account(String Amount) throws Throwable {
		Amount = "-" + Amount;
		int NB = account.getNBTransaction() + 1;
		account.addNewTransaction(Amount, "DEPOSIT",  Integer.toString(NB));
	}
	
	@When("^he deposit (.*) EUR from his account$")
	public void he_deposit_EUR_from_his_account(String Amount) throws Throwable {
		int NB = account.getNBTransaction() + 1;
		account.addNewTransaction(Amount, "DEPOSIT",  Integer.toString(NB));
	}
	
	@Then("^the new balance is (.*) EUR$")
	public void the_new_balance_is_EUR(String Amount) throws Throwable {
		String totalBalance = account.getBalance();
		Assertions.assertThat(Boolean.TRUE);
		Assertions.assertThat(Float.parseFloat(totalBalance)).isEqualTo(Float.parseFloat(Amount));
	}
	 
	@Override
	protected String getDefaultBaseUrl() {
		// TODO Auto-generated method stub
		return null;
	}

}
