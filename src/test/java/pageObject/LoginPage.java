package pageObject;

import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.Helper;

public class LoginPage {
	
	public static WebDriver driver;
	

	public LoginPage(WebDriver driver) {
		this.driver = driver; 
        PageFactory.initElements(driver, this);
	}

	public void assertTitle() throws Throwable {
	    String title = driver.getTitle();
		assertEquals("CafeTownsend-AngularJS-Rails",title);
	}
	
	public void loginFormDisplay() throws Throwable {
		loginForm.isDisplayed();
	}
	
	public void enterUsername(String name) throws Throwable {
	    username.clear();
	    username.sendKeys(name);
	    
	}
	
	public void enterPassword(String pass) throws Throwable {
	    password.clear();
	    password.sendKeys(pass);
	}

	public void clickLogin() throws Throwable {
	    loginButton.click();
	}
	
	public void checkPopupError(){
		String popError = loginButton.getAttribute("ng-disabled");
		assertEquals("true",popError);
	}
	
	public void checkErrorMsg(String expectMsg) throws Exception{
		Helper wait = new Helper();
		wait.waitLoop(errorMessage);
		String errorMsg = errorMessage.getText();
		assertEquals(expectMsg, errorMsg);
	}
	
	
	@FindBy(id="login-form")
	WebElement loginForm;
	
	@FindBy(xpath="//*[@id='login-form']/fieldset/label[1]/input")
	WebElement username;
	
	@FindBy(xpath="//*[@id='login-form']/fieldset/label[2]/input")
	WebElement password;
	
	@FindBy(xpath="//*[@id='login-form']/fieldset/button")
	WebElement loginButton;
	
	@FindBy(className="error-message")
	WebElement errorMessage;

}
