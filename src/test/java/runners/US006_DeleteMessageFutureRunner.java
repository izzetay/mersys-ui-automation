package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class US006_DeleteMessageFutureRunner {

    @CucumberOptions(
            features = "src/test/resources/features/US_06_DeleteMessage.feature",
            glue = "stepDefinitions")

    public class TestRunner extends AbstractTestNGCucumberTests {

    }
}
