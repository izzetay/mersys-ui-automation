package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class US005_MessagingFeatureRunner {
    @CucumberOptions(
            features = "src/test/resources/features/US_05_Messaging.feature",
            glue = "stepDefinitions")

    public class TestRunner extends AbstractTestNGCucumberTests {

    }
}

