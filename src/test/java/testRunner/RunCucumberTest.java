package testRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@CucumberOptions(
        features = {"src/test/resources/features/CreateAccount.feature",
        			"src/test/resources/SignIn.feature"},
        glue = "stepDefinition",
        		plugin = { "pretty" },
        		
                		
        		monochrome = true)
@RunWith(Cucumber.class)
public class RunCucumberTest {
	
}