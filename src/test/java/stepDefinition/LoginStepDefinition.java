package stepDefinition;

import helper.Helper;
import pageObject.LoginPage;
import pageObject.LandingPage;

import org.junit.After;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition {

	Helper helper = new Helper();
	LoginPage lp = new LoginPage(helper.getDriver());
	LandingPage landP = new LandingPage(helper.getDriver());
	

	
	@Given("^user is on Login page$")
	public void user_is_on_Login_page() throws Throwable {
		helper.browserNavigate();
	    lp.assertTitle();
	}

	@Given("^Login form displayed$")
	public void login_form_displayed() throws Throwable {
	    lp.loginFormDisplay();
	}

	@When("^user enters username \"(.*?)\"$")
	public void user_enters_username(String name) throws Throwable {
	    lp.enterUsername(name);
	}

	@When("^user enters password\"(.*?)\"$")
	public void user_enters_password(String pass) throws Throwable {
	    lp.enterPassword(pass);
	}

	@When("^user clicks the Login button$")
	public void user_clicks_the_Login_button() throws Throwable {
	    lp.clickLogin();
	}

	@Then("^user should see \"(.*?)\" as the username in greeting message$")
	public void user_should_see_as_username_in_greeting_message(String name) throws Throwable {
	    landP.checkGreetingMsg(name);
	}
	
	@Then("^user should be unable to proceed with login$")
	public void user_should_be_unable_to_proceed_with_login() throws Throwable {
		lp.checkPopupError();
	}
	
	@Then("^user should see \"(.*?)\"$")
	public void user_should_see(String error) throws Throwable {
		lp.checkErrorMsg(error);
	}
	


}
