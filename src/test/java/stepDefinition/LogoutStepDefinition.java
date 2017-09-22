package stepDefinition;

import org.junit.After;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.Helper;
import pageObject.LandingPage;
import pageObject.LoginPage;

public class LogoutStepDefinition {
	
	Helper helper = new Helper();
	LoginPage lp = new LoginPage(helper.getDriver());
	LandingPage landP = new LandingPage(helper.getDriver());
	
	@Given("^user logged in with coorect credentials$")
	public void user_logged_in_with_coorect_credentials() throws Throwable {
		helper.browserNavigate();
	    lp.loginFormDisplay();
	    lp.enterUsername("Luke");
	    lp.enterPassword("Skywalker");
	    lp.clickLogin();    
	}

	@When("^user clicks the Logout button$")
	public void user_clicks_the_Logout_button() throws Throwable {
	    landP.clickLogout();	    
	}

	@Then("^user should be taken to the Login page$")
	public void user_should_be_taken_to_the_Login_page() throws Throwable {
	    lp.loginFormDisplay();    
	}
	
	@After
	public void waitBtwTests() throws Exception{
		Thread.sleep(1000);
	}

}
