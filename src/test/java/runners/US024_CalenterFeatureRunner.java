package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class US024_CalenterFeatureRunner {

    @CucumberOptions(
            features = "src/test/resources/features/US_24_Calendar.feature",
            glue = "stepDefinitions")

    public class TestRunner extends AbstractTestNGCucumberTests {

    }
}

