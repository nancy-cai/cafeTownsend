package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import helper.Helper;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		
		plugin = { "html:target/cucumber-html-report",
				        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
				        "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml" },
		features = "src/test/resources/Feature/UpdateEmployee.feature",
			
		glue={"stepDefinition"}
		
		)


public class TestRunner {
	
	  @AfterClass
	    public static void tearDown(){
		  Helper helper = new Helper();
		  helper.getDriver().close();
	    }

}
