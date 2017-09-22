package helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Helper {
	
	public static WebDriver driver = new ChromeDriver();
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public void waitLoop(WebElement element) throws Exception{
		for(int second = 0; second<60;second++){
				Thread.sleep(1000);
				if(element.isDisplayed()){				
					break;
				}
		}	
	}
	
	public void browserNavigate() throws Exception{
		driver.manage().window().maximize();
		driver.get("http://cafetownsend-angular-rails.herokuapp.com/login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}
 