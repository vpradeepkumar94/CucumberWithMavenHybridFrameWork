package StepDefinitions.InputForms;

import com.hybridframework.pagegenerator.Page;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InputForms_SD {

	@Given("^I  Navigate to inputForms page$")
	public void i_Navigate_to_inputForms_page() throws Throwable {
	 Page.homePage.navigateToInputFormPage();
	}

	@Then("^the input fields is displayed$")
	@When("^the input fields are displayed$")
	public void the_input_fields_is_displayed() throws Throwable {
	 Page.inputFormPage.waitForInputFormPageToBeLoaded();
	}
	@Then("^I should be able to enter message in the field$")
	public void i_should_be_able_to_enter_message_in_the_field() throws Throwable {
		Page.inputFormPage.enterText("Hie");
	}

	@Then("^I enter (\\d+) and (\\d+) in the input fields$")
	public void i_enter_and_in_the_input_fields(int arg1, int arg2) {
	Page.inputFormPage.findTheSumeOfTwoNumbers(20,30);
	}

	@Then("^The result should be sum of the entered two numbers$")
	public void the_result_should_be_sum_of_the_entered_two_numbers(){
	
	}

}
