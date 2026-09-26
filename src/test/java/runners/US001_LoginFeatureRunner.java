package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class US001_LoginFeatureRunner {

    @CucumberOptions(
            features = "src/test/resources/features/US_01_Login.feature",
            glue = "stepDefinitions")

    public class TestRunner extends AbstractTestNGCucumberTests{

    }
}
