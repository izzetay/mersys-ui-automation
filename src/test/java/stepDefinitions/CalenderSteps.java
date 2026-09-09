package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.CalenderPage;
import utilities.GWD;
import static pages.ParentPage.wait;

public class CalenderSteps {

     CalenderPage cp = new CalenderPage(GWD.getDriver());

    @Then("User is able to see class names")
    public void userIsAbleToSeeClassNames() {
        wait.until(ExpectedConditions.visibilityOfAllElements(cp.courseNamesTab));

        Assert.assertFalse(cp.courseNamesTab.isEmpty(), "No classes are displayed on the calendar!");
    }

    @And("User clicks on the previous week button")
    public void userClicksOnThePreviousWeekButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cp.previusPageButton));
        cp.previusPageButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Success: Navigated to the previous week on the calendar.");
    }


    @And("User clicks on a completed class")
    public void userClicksOnACompletedClass() {
        wait.until(ExpectedConditions.elementToBeClickable(cp.completedClassEvent));

        cp.completedClassEvent.click();

        System.out.println("Success: Clicked on a completed class.");
    }

    @Then("User should see {string}, {string}, {string}, {string} tabs and confirm they are working")
    public void userShouldSeeTabsAndConfirmTheyAreWorking(String tab1, String tab2, String tab3, String tab4) {

        String[] expectedTabs = {tab1, tab2, tab3, tab4};

        for (String tabName : expectedTabs) {
            WebElement currentTab = null;

            switch (tabName) {
                case "Information":
                    currentTab = cp.informationTab;
                    break;
                case "Topic":
                    currentTab = cp.topicTab;
                    break;
                case "Attachments":
                    currentTab = cp.attachmentsTab;
                    break;
                case "Recent Events":
                    currentTab = cp.recentEventsTab;
                    break;
            }
            Assert.assertNotNull(currentTab, "Tab is not defined in the page class: " + tabName);

            wait.until(ExpectedConditions.visibilityOf(currentTab));
            Assert.assertTrue(currentTab.isDisplayed(), tabName + " tab is NOT visible!");

            Assert.assertTrue(currentTab.isEnabled(), tabName + " tab is NOT clickable!");

            currentTab.click();
            System.out.println("Verified: " + tabName + " tab is visible and working.");
        }
    }


}

