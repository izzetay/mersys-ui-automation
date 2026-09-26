package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class US018_AssignmentsFeatureRunner {

    @CucumberOptions(
            features = "src/test/resources/features/US_18_Assignments.feature",
            glue = "stepDefinitions")

    public class TestRunner extends AbstractTestNGCucumberTests {

    }
}

