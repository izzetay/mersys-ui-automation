package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class US019_AssignmentDiscussionFeatureRunner {


    @CucumberOptions(
            features = "src/test/resources/features/US_19_AssignmentDiscussion.feature",
            glue = "stepDefinitions")

    public class TestRunner extends AbstractTestNGCucumberTests {

    }
}

