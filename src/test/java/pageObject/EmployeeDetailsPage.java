package pageObject;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import helper.Helper;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class EmployeeDetailsPage {
	
	public static WebDriver driver;
	public static JavascriptExecutor js;
	Helper wait = new Helper();
	
	public EmployeeDetailsPage(WebDriver driver){
		this.driver = driver; 
        PageFactory.initElements(driver, this);
	}
	
	
	public void enterFirstName(String firstName) throws Exception{
		
		wait.waitLoop(detailForm);
		firstNameInput.clear();
		firstNameInput.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName){
		lastNameInput.clear();
		lastNameInput.sendKeys(lastName);
	}
	
	public void enterStartDate(String startDate){
		startDateInput.clear();
		startDateInput.sendKeys(startDate);
	}
	
	public void enterEmail(String email){
		emailInput.clear();
		emailInput.sendKeys(email);
	}
	
	public void clickCancelButton(){
		cancelCreateButton.click();
	}
	
	public void clickAddButton(){
		addCreateButton.click();
	}
	
	public void clickBackButton(){
		backEditButton.click();
	}
	
	public void clickUpdateButton(){
		updateButton.click();
	}
	
	public void clickDeleteButton(){
		deleteButton.click();
	}
	
	public void checkAddBtnDisable(){
		String addBtnStatus = addCreateButton.getAttribute("ng-disabled");
		assertEquals("true",addBtnStatus);
	}
	
	public void checkUpdateBtnDisable(){
		String updateBtnStatus = updateButton.getAttribute("ng-disabled");
		assertEquals("true",updateBtnStatus);
	}
	
	public void acceptAlert(){
		try {
	        WebDriverWait wait = new WebDriverWait(driver, 2);
	        if(wait.until(ExpectedConditions.alertIsPresent())!=null){
		        wait.until(ExpectedConditions.alertIsPresent());
		        Alert alert = driver.switchTo().alert();
		        alert.accept();
		        } else {
		        }
	        
	    } catch (Exception e) {
	        //exception handling
	    }
	}
	
	
	public void acceptDeleteAlert(){
		try {
	        WebDriverWait wait = new WebDriverWait(driver, 2);
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        alert.accept();
	    } catch (Exception e) {
	        //exception handling
	    }
	}
	
	public void declineDeleteAlert(){
		try {
	        WebDriverWait wait = new WebDriverWait(driver, 2);
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        alert.dismiss();
	    } catch (Exception e) {
	        //exception handling
	    }
	}
	
	public void assertFirstName(String firstName){
		js = (JavascriptExecutor) driver;
		String actualFirstName = js.executeScript("return document.getElementsByTagName('input')[0].value").toString();
		assertEquals(firstName, actualFirstName);
	}
	
	public void assertLastName(String lastName){
		js = (JavascriptExecutor) driver;
		String actualLastName = js.executeScript("return document.getElementsByTagName('input')[1].value").toString();
		assertEquals(lastName, actualLastName);
	}
	
	public void assertStartDate(String startDate){
		js = (JavascriptExecutor) driver;
		String actualDate = js.executeScript("return document.getElementsByTagName('input')[2].value").toString();
		assertEquals(startDate, actualDate);
	}
	
	public void assertEmail(String email){
		js = (JavascriptExecutor) driver;
		String actualEmail = js.executeScript("return document.getElementsByTagName('input')[3].value").toString();
		assertEquals(email, actualEmail);
	}
	
	
	@FindBy(name="employeeForm")
	WebElement detailForm;
	
	@FindBy(xpath="//form[@name='employeeForm']/fieldset/label[1]/input")
	WebElement firstNameInput;
	
	@FindBy(xpath="//form[@name='employeeForm']/fieldset/label[2]/input")
	WebElement lastNameInput;
	
	@FindBy(xpath="//form[@name='employeeForm']/fieldset/label[3]/input")
	WebElement startDateInput;
	
	@FindBy(xpath="//form[@name='employeeForm']/fieldset/label[4]/input")
	WebElement emailInput;
	
	@FindBy(className="bCancel")
	WebElement cancelCreateButton;
	
	@FindBy(xpath="//*[@class='formFooter']/button[2]")
	WebElement addCreateButton;
	
	@FindBy(className="bBack")
	WebElement backEditButton;
	
	@FindBy(xpath="//*[@class='formFooter']/button[1]")
	WebElement updateButton;
	
	@FindBy(xpath="//*[@class='formFooter']/p")
	WebElement deleteButton;
	
	

}
