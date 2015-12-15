package net.diegolemos.bankapp.steps.account.AccountStepdefs;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/specs/features/withdraw_from_account.feature" }, format = { "html:target/cucumber-report/ScenAddClientAccountBDD" })
public class ScenAddClientAccountBDDLuncher {

}
