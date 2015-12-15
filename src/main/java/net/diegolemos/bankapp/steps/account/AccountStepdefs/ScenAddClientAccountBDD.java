package net.diegolemos.bankapp.steps.account.AccountStepdefs;


import bibliotheque.ReadConfFile;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.codestory.simplelenium.SeleniumTest;
import net.diegolemos.bankapp.account.Account;
import net.diegolemos.bankapp.all.MenuHeader;
import net.diegolemos.bankapp.client.Client;


public class ScenAddClientAccountBDD extends SeleniumTest {
	
	
	private   String nameClient="pierre-jean";
	
	@Given("an existing client named 'pierre-jean' with 100.0 EUR in his account")
	public void an_existing_client_named_pierre_jean_with_EUR_in_his_account() throws Throwable {
		String[] Param_Server = ReadConfFile.Get_Info("1");	
		String Url = Param_Server[0];
		goTo(Url);
		 MenuHeader menu = new MenuHeader();
		//GoToClient
		menu.clickClients();
		Account account = new Account();
		Client client = new Client();
		//AddClient
		client.addNewClient(nameClient);
		Thread.sleep(2000L);
		menu.clickAccounts();
		account.searchClientSimple(nameClient);
		Thread.sleep(2000L);
		account.addNewTransaction("100", "DEPOSIT", "1");
	}
	
	@When("he withdraws 10.0 EUR from his account")
	public void he_withdraws_EUR_from_his_account() throws Throwable {
		System.out.println("aaa");
		 Account account = new Account();
		 account.addNewTransaction("-10", "DEPOSIT", "2");
	}

	@Then("the new balance is 90.0 EUR")
	public void the_new_balance_is_EUR() throws Throwable {
		 find("#ng-binding").should().not().contain("90 EUR");
	}
	
	
	 
	@Override
	protected String getDefaultBaseUrl() {
		// TODO Auto-generated method stub
		return null;
	}

}
