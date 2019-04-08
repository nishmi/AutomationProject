package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/java/features/search.feature", 
		glue = { "stepDefinitions" }, 
		plugin = {"pretty", "html:target/test-outout" }, 
		monochrome = true, 
		strict = true, 
		dryRun = false
		)

public class TestRunner {

}
