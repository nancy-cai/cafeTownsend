package stepDefinition;

import helper.Helper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.EmployeeDetailsPage;
import pageObject.LandingPage;
import pageObject.LoginPage;

public class EditStepDefinition {
	
	Helper helper = new Helper();
	LoginPage lp = new LoginPage(helper.getDriver());
	LandingPage landP = new LandingPage(helper.getDriver());
	EmployeeDetailsPage edp= new EmployeeDetailsPage(helper.getDriver());

	
	@Given("^user has logged in$")
	public void user_has_logged_in() throws Throwable {
		helper.browserNavigate();
	    lp.loginFormDisplay();
	    lp.enterUsername("Luke");
	    lp.enterPassword("Skywalker");
	    lp.clickLogin();
	}

	@Given("^Employee with name test updateSuccess exists$")
	public void employee_with_name_test_updateSuccess_exists() throws Throwable {
		landP.clickCreateButton();
    	edp.enterFirstName("test");
        edp.enterLastName("updateSuccess");
        edp.enterStartDate("2020-09-15");
        edp.enterEmail("test@test.com");
        edp.clickAddButton(); 
	    
	}

	@When("^user select test updateSuccess from the list$")
	public void user_select_test_updateSuccess_from_the_list() throws Throwable {
	    landP.selectNameFromList("test", "updateSuccess");
	}

	@When("^user clicks the Edit button$")
	public void user_clicks_the_Edit_button() throws Throwable {
	    landP.clickEditButton();
	}

	@When("^user changes firstname to \"(.*?)\"$")
	public void user_changes_firstname_to(String newFirstName) throws Throwable {
	    edp.enterFirstName(newFirstName);  
	}

	@When("^user changes lastname to \"(.*?)\"$")
	public void user_changes_lastname_to(String newLastName) throws Throwable {
	    edp.enterLastName(newLastName);    
	}

	@When("^user changes start date to \"(.*?)\"$")
	public void user_changes_start_date_to(String newStartDate) throws Throwable {
	    edp.enterStartDate(newStartDate);
	}

	@When("^user changes email to \"(.*?)\"$")
	public void user_changes_email_to(String newEmail) throws Throwable {
	    edp.enterEmail(newEmail);
	}

	@When("^user submit the Updated form$")
	public void user_submit_the_Updated_form() throws Throwable {
	    edp.clickUpdateButton();   
	    edp.acceptAlert();
	}

	@When("^user select new full name from the list \"(.*?)\", \"(.*?)\"$")
	public void user_select_new_full_name_from_the_list(String newFirstName, String newLastName) throws Throwable {
	    landP.doubleClickNameFromList(newFirstName, newLastName);   
	}

	@Then("^user should see updated  details \"(.*?)\", \"(.*?)\", \"(.*?)\",\"(.*?)\"$")
	public void user_should_see_updated_details(String newFirstName, String newLastName, String newStartDate, String newEmail) throws Throwable {
		edp.assertFirstName(newFirstName);
	    edp.assertLastName(newLastName);
	    edp.assertStartDate(newStartDate);
	    edp.assertEmail(newEmail);    
	}

	@Given("^Employee with name test updateFail exists$")
	public void employee_with_name_test_updateFail_exists() throws Throwable {
		landP.clickCreateButton();
    	edp.enterFirstName("test");
        edp.enterLastName("updateFail");
        edp.enterStartDate("2020-09-15");
        edp.enterEmail("test@test.com");
        edp.clickAddButton();
	}

	@When("^user select test updateFail$")
	public void user_select_test_updateFail() throws Throwable {
		landP.selectNameFromList("test", "updateFail");
	}

	@Then("^user should be unable to proceed with update$")
	public void user_should_be_unable_to_proceed_with_update() throws Throwable {
	    edp.checkUpdateBtnDisable();	    
	}

	@Given("^Employee with name test updateCancel exists$")
	public void employee_with_name_test_updateCancel_exists() throws Throwable {
		landP.clickCreateButton();
    	edp.enterFirstName("test");
        edp.enterLastName("updateCancel");
        edp.enterStartDate("2020-09-15");
        edp.enterEmail("test@test.com");
        edp.clickAddButton();
	}

	@When("^user select test updateCancel$")
	public void user_select_test_updateCancel() throws Throwable {
	    landP.selectNameFromList("test", "updateCancel");	    
	}

	@When("^user clicks the Back button$")
	public void user_clicks_the_Back_button() throws Throwable {
	    edp.clickBackButton();	    
	}

	@Then("^user should go back to the landing page$")
	public void user_should_go_back_to_the_landing_page() throws Throwable {
	    landP.employeeListDisplay();	    
	}


	

}
