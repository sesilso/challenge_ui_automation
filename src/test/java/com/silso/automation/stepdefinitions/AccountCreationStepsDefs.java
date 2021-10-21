package com.silso.automation.stepdefinitions;

import com.silso.automation.builders.data.AccountBuilder;
import com.silso.automation.models.Account;
import com.silso.automation.questions.RegisterQuestions;
import com.silso.automation.tasks.NavigateTo;
import com.silso.automation.tasks.Register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountCreationStepsDefs {

	@Autowired
	private NavigateTo navigateTo;

	@Autowired
	private Register registerTask;

	@Autowired
	private RegisterQuestions registerQuestions;

	private Account newAccount;

	@Given("A client wants to create an account in the platform")
	public void a_Client_Wants_To_Create_An_Account_In_The_Platform() {
		navigateTo.homePage();
		navigateTo.accountSignIn();
	}

	@When("the client completes the creation process")
	public void the_Client_Completes_The_Creation_Process() {
		newAccount = AccountBuilder.anAccount().withDefaultInfo().build();
		registerTask.withInfo(newAccount);
	}

	@Then("the account should be created successfully")
	public void the_Account_Should_Be_Created_Successfully() {
		registerQuestions.isUsernameCorrect(newAccount);
		registerQuestions.isLogOutOptionAvailable();
		registerQuestions.isCurrentUrlCorrect();
	}
}
