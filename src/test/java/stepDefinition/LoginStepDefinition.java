package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import helper.Helper;
import pageObject.LoginPage;
import pageObject.LandingPage;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition {
	
	public static WebDriver driver= new ChromeDriver();
	LoginPage lp = new LoginPage(driver);
	
	
	@Before
	public void navigateToPage(){		
		driver.manage().window().maximize();
		driver.get("http://cafetownsend-angular-rails.herokuapp.com/login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@Given("^user is on Login page$")
	public void user_is_on_Login_page() throws Throwable {
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

	@Then("^user should be logged in$")
	public void user_should_be_logged_in() throws Throwable {
	    lp.checkGreetingMsg();
	}
	
	@Then("^user should see popup error message$")
	public void user_should_see_popup_error_message() throws Throwable {
		lp.checkPopupError();
	}
	
	@Then("^user should see \"(.*?)\"$")
	public void user_should_see(String arg1) throws Throwable {
		lp.checkErrorMsg(arg1);
	}

}
