package StepDefinitions.HomePage;

import com.hybridframework.pagegenerator.Page;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePage_SD {

	@Given("^I  launch the application url$")
	public void i_launch_the_application_url() throws Throwable {
		Page.homePage.printMessage();
		Page.homePage.launchURL("http://www.seleniumeasy.com/test/");
	}
	
	@When("^the page is loaded$")
	public void the_page_is_loaded() throws Throwable {
	 Page.homePage.waitForInputFormPageToBeLoaded();
	}


	@Then("^the page title should be displayed$")
	public void the_page_title_should_be_displayed() throws Throwable {
		System.out.println(Page.homePage.getPageTitle());
	}

}
