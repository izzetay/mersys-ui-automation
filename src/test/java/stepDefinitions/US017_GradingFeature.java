package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.GradingPage;
import pages.HeaderMenu;
import utilities.GWD;

import java.time.Duration;

import static pages.ParentPage.click;


public class US017_GradingFeature extends GWD {

    HeaderMenu header = new HeaderMenu(getDriver());
    GradingPage grading = new GradingPage(getDriver());


    @When("User navigates to the 'Grading' page.")
    public void navigateToGradingPage() {
        click(header.headerGradingButton, 4);

    }

    @Then("User should see a 'Print' icon on the page.")
    public void checkPrintIconVisible() {
        Assert.assertTrue(grading.printButton.isDisplayed());

    }

    @When("User clicks the 'Print' icon.")
    public void clickPrintIcon() {
        click(grading.printButton, 4);

    }

    @Then("User should see the transcript document in PDF format.")
    public void checkTranscriptPdfVisible(){
        String originalWindow = getDriver().getWindowHandle();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(d -> d.getWindowHandles().size() > 1);

        for (String handle : getDriver().getWindowHandles()) {
            if (!handle.equals(originalWindow)) {
                getDriver().switchTo().window(handle);
                break;
            }
        }

    }

}
