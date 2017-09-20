package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {
	public void waitLoop(WebDriver driver, WebElement element) throws Exception{
		for(int second = 0; second<60;second++){

				Thread.sleep(1000);
				if(element.isDisplayed()){				
					break;
				}
		}	
	}

}
