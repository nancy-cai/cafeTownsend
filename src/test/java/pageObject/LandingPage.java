package pageObject;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helper.Helper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LandingPage {
	
	public static WebDriver driver;
	Helper wait = new Helper();

	public LandingPage(WebDriver driver) {
		this.driver = driver; 
        PageFactory.initElements(driver, this);
	}
	
	public void checkGreetingMsg(String name) throws Throwable {    
	    String greetMsg = greeting.getText();
	    assertEquals("Hello"+ " " + name, greetMsg);
	    Thread.sleep(3000);
	}
	
	public void clickLogout(){
		logoutButton.click();
	}
	
	public void clickCreateButton(){
		createButton.click();
	}
	
	public void clickEditButton(){
		editButton.click();
	}
	
	public void clickDeleteButton(){
		deleteButton.click();
	}
	
	public void employeeListDisplay() throws Exception{
		wait.waitLoop(employeeList);
		employeeList.isDisplayed();
	}
	
	public void selectNameFromList(String firstName, String lastName) throws Exception{
		wait.waitLoop(employeeList);
		for (WebElement empName: employeeNames){
			String fullName = empName.getText();
			if(fullName.equals(firstName+" "+lastName)){
				empName.click();
				Thread.sleep(2000);
				break;
				}
			}
	}
	
	
	public void selectLastNameFromList(String lastName) throws Exception{
		wait.waitLoop(employeeList);
		for (WebElement empName: employeeNames){
			String fullName = empName.getText();
			if(fullName.contains(lastName)){
				empName.click();
				Thread.sleep(2000);
				break;
				}
			}
	}
	
	public void doubleClickNameFromList(String firstName, String lastName) throws Exception{
		wait.waitLoop(employeeList);
		Actions action = new Actions(driver);
		for (WebElement empName: employeeNames){
			String fullName = empName.getText();
			if(fullName.equals(firstName+" "+lastName)){
				action.doubleClick(empName).perform();
				Thread.sleep(1000);
				break;
				}
			}
	}
	
	public void assertNameNotExist(String firstName, String lastName) throws Exception{
		wait.waitLoop(employeeList);
		for (WebElement empName: employeeNames){
			String fullName = empName.getText();
			assertTrue(fullName != (firstName+" "+lastName));
		}
	}
	
	@FindBy(id="greetings")
	WebElement greeting;
	
	@FindBy(xpath="//*[@class='header-container']/p[1]")
	WebElement logoutButton;
	
	@FindBy(id="bAdd")
	WebElement createButton;
	
	@FindBy(id="bEdit")
	WebElement editButton;
	
	@FindBy(id="bDelete")
	WebElement deleteButton;
	
	@FindBy(id="employee-list")
	WebElement employeeList;
	
	@FindBy(xpath="//*[@id='employee-list']/li")
	List<WebElement> employeeNames;

}
