package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/stepDefinitions/US009_HamMenuFinance.java",
        glue = "stepDefinitions")

public class US009_HamMenuFinanceRunner extends AbstractTestNGCucumberTests {

}
