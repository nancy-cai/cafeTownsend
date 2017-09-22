package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.Helper;
import pageObject.EmployeeDetailsPage;
import pageObject.LandingPage;
import pageObject.LoginPage;

public class DeleteStepDefinition {
	
	Helper helper = new Helper();
	LoginPage lp = new LoginPage(helper.getDriver());
	LandingPage landP = new LandingPage(helper.getDriver());
	EmployeeDetailsPage edp= new EmployeeDetailsPage(helper.getDriver());
    
    @Given("^user is logged in to page$")
    public void user_is_logged_in_to_page() throws Throwable {        
    	helper.browserNavigate();
	    lp.loginFormDisplay();
	    lp.enterUsername("Luke");
	    lp.enterPassword("Skywalker");
	    lp.clickLogin();
    }

    @Given("^Employee with name \"(.*?)\", \"(.*?)\" exists$")
    public void employee_with_name_exists(String firstName, String lastName) throws Throwable {
    	landP.clickCreateButton();
    	edp.enterFirstName(firstName);
        edp.enterLastName(lastName);
        edp.enterStartDate("2020-09-15");
        edp.enterEmail("test@test.com");
        edp.clickAddButton(); 
    }

    @When("^user select name \"(.*?)\", \"(.*?)\" from the list$")
    public void user_select_name_from_the_list(String firstName, String lastName) throws Throwable {        
    	landP.selectNameFromList(firstName, lastName);
    }

    @When("^user clicks Delete on the landing page$")
    public void user_clicks_Delete_on_the_landing_page() throws Throwable {
    	landP.clickDeleteButton();
    }
    
    @When("^user accept the alert$")
    public void user_accept_the_alert() throws Throwable {
    	edp.acceptDeleteAlert();
    }

    @Then("^user should not see employee with name \"(.*?)\", \"(.*?)\" in the list$")
    public void user_should_not_see_employee_with_name_in_the_list(String firstName, String lastName) throws Throwable {
        landP.assertNameNotExist(firstName, lastName);
    }

    @When("^user clicks Edit on the landing page$")
    public void user_clicks_Edit_on_the_landing_page() throws Throwable {
        landP.clickEditButton();
    }

    @When("^user clicks Delete button on the edit page$")
    public void user_clicks_Delete_button_on_the_edit_page() throws Throwable {
        edp.clickDeleteButton();
    }

    @Given("^Employee with name test cancelDelete exists$")
    public void employee_with_name_test_cancelDelete_exists() throws Throwable {
    	landP.clickCreateButton();
    	edp.enterFirstName("test");
        edp.enterLastName("cancelDelete");
        edp.enterStartDate("2020-09-15");
        edp.enterEmail("test@test.com");
        edp.clickAddButton();            
    }

    @When("^user select name test cancelDelete from the list$")
    public void user_select_name_test_cancelDelete_from_the_list() throws Throwable {
        landP.selectNameFromList("test", "cancelDelete");
    }
    
 
    @When("^user decline the alert$")
    public void user_decline_the_alert() throws Throwable {
    	edp.declineDeleteAlert();
    }
    
    @When("^employee should still exists in the list$")
    public void employee_should_still_exists_in_the_list() throws Throwable {
    	landP.selectNameFromList("test", "cancelDelete");
    }
    

}
