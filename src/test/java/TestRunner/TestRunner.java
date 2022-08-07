package TestRunner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


/**
 * Execution starts from Here Run as Junit
 * 
 * @author Kamal Raj
 **/

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", 
                 glue = { "stepDefinations" }, 
                 plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                 tags = "@SmokeTest" )

public class TestRunner {

	@BeforeClass
	public static void Loader() {

		// We can make use of this class to Initialize the Data load in Excel , SQL connection 

	}
}
