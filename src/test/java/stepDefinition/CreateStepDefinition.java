package stepDefinition;

import helper.Helper;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.EmployeeDetailsPage;
import pageObject.LandingPage;
import pageObject.LoginPage;

public class CreateStepDefinition {
	
	Helper helper = new Helper();
	LoginPage lp = new LoginPage(helper.getDriver());
	LandingPage landP = new LandingPage(helper.getDriver());
	EmployeeDetailsPage edp= new EmployeeDetailsPage(helper.getDriver());

	
	@Given("^user is logged in$")
	public void user_is_logged_in() throws Throwable {
		helper.browserNavigate();
	    lp.loginFormDisplay();
	    lp.enterUsername("Luke");
	    lp.enterPassword("Skywalker");
	    lp.clickLogin();
	}
	
	@Given("^user is on the landing page$")
	public void user_is_on_the_landing_page() throws Throwable {
	    landP.employeeListDisplay();
	}

	@When("^user clicks the Create button$")
	public void user_clicks_the_Create_button() throws Throwable {
	    landP.clickCreateButton();
	}

	@When("^user enters firstname \"(.*?)\"$")
	public void user_enters_firstname(String firstName) throws Throwable {
	    edp.enterFirstName(firstName);
	}

	@When("^user enters lastname \"(.*?)\"$")
	public void user_enters_lastname(String lastName) throws Throwable {
	    edp.enterLastName(lastName);
		
	}

	@When("^user enters startDate \"(.*?)\"$")
	public void user_enters_startDate(String startDate) throws Throwable {
	    edp.enterStartDate(startDate);
	}

	@When("^user enters email \"(.*?)\"$")
	public void user_enters_email(String email) throws Throwable {
	   edp.enterEmail(email);
	}

	@When("^user submit the Create form$")
	public void user_submit_the_Create_form() throws Throwable {
	    edp.clickAddButton();
	}

	@When("^user select full name from the list\"(.*?)\", \"(.*?)\"$")
	public void user_select_full_name_from_the_list(String firstName, String lastName) throws Throwable {
	    landP.doubleClickNameFromList(firstName, lastName);
	}

	@Then("^user should see correct details \"(.*?)\", \"(.*?)\", \"(.*?)\",\"(.*?)\"$")
	public void user_should_see_correct_details(String firstName, String lastName, String startDate, String email) throws Throwable {
	    edp.assertFirstName(firstName);
	    edp.assertLastName(lastName);
	    edp.assertStartDate(startDate);
	    edp.assertEmail(email);
	}

	@Then("^user is unable to proceed with creation$")
	public void user_is_unable_to_proceed_with_creation() throws Throwable {
	    edp.checkAddBtnDisable();
	    edp.acceptAlert();
	}
	
	@When("^user click the Cancel button$")
	public void user_click_the_Cancel_button() throws Throwable {
	    edp.clickCancelButton();
	}

	@Then("^user should be taken back to the landing page$")
	public void user_should_be_taken_back_to_the_landing_page() throws Throwable {
	    landP.employeeListDisplay();
	}
	
	@After({"@update-happy-case","@cancel-delete-employee"})
	public void deleteCreatedEmployee(String lastName){
		try {
			landP.selectLastNameFromList(lastName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		landP.clickDeleteButton();
		edp.acceptDeleteAlert();
	}
	
	@After({"@create-happy-case","@update-fail-case","@cancel-update-employee"})
	public void deleteCreateEmployeeOnUpdatePage(){
		edp.clickDeleteButton();
		edp.acceptDeleteAlert();
	}
	
	@After
	public void waitBtwTest() throws InterruptedException{
		Thread.sleep(1000);
	}
	

}
