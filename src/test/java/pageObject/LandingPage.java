package pageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public static WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver; 
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="greetings")
	WebElement greeting;

}
