package stepDefinitions;
import io.cucumber.java.en.When;
import pages.NavigationPage;
import pages.ParentPage;
import utilities.GWD;

public class NavigationSteps {

    NavigationPage np = new NavigationPage(GWD.getDriver());

    @When("User navigates to {string} page")
    public void userNavigatesToPage(String linkName) {
        switch (linkName) {
            case "Grading":
                ParentPage.click(np.gradingLink, 10);
                break;
            case "Calendar":
                ParentPage.click(np.calenderLink,10);

        }
    }

}
