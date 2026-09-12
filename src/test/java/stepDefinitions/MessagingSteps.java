package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.MessagingPage;
import pages.ParentPage;
import java.time.Duration;

import static utilities.GWD.getDriver;

public class MessagingSteps {

    MessagingPage mp = new MessagingPage(getDriver());
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    @Given("User clicks on the New Message button")
    public void userClicksOnNewMessageButton() {
        ParentPage.click(mp.hamburgerMenu,10);
        ParentPage.click(mp.messagingLink,10);
        ParentPage.click(mp.newMessageButton,10);
    }

    @And("User closes the error message")
    public void userClosesTheErrorMessage() {
        ParentPage.click(mp.closeErrorButton,10);
    }

    @When("User clicks on the {string} icon, searches for {string} and selects a receiver")
    public void userClicksOnIconAndSelectsReceiver(String icon, String searchText) {
        wait.until(ExpectedConditions.elementToBeClickable(mp.receiversIcon));
        ParentPage.click(mp.receiversIcon,10);
        mp.receiverSearchBox.sendKeys(searchText);

        wait.until(ExpectedConditions.visibilityOfAllElements(mp.receiverOption));
        ParentPage.click(mp.receiverOption,10);
        ParentPage.click(mp.addAndCloseButton,10);
    }

    @When("User enters {string} as the message subject")
    public void userEntersMessageSubject(String subject) {
        mp.subjectBox.sendKeys(subject);
    }

    @When("User types {string} into the text editor")
    public void userEntersTheTextEditor(String text) {
        mp.textEditorBox.sendKeys(text);
    }
    @When("User attaches a sample file from the {string} section")
    public void userAttachesSampleFile(String attachText) {
        String projeYolu = System.getProperty("user.dir");
        String dosyaYolu = projeYolu + "\\src\\test\\resources\\files\\blank.png";

        mp.fileUploadInput.sendKeys(dosyaYolu);
    }
    @When("User clicks the {string} button")
    public void userClicksOnButton(String sendStr) {
        ParentPage.click(mp.sendButton,10);
    }

    @Then("User should see a {string} message on the screen")
    public void userShouldSeeSuccesMessageOnScreen(String successText) {
        wait.until(ExpectedConditions.visibilityOf(mp.successMessage));
        Assert.assertTrue(mp.successMessage.getText().contains(successText), "Başarı mesajı alınamadı!");
    }

    @Then("User navigates to the {string} page from the hamburger menu and verifies that the sent message is in the list")
    public void userNavigatesToOutboxAndVerifiesTheSentMessage(String outboxStr) {
        ParentPage.click(mp.hamburgerMenu,10);
        ParentPage.click(mp.messagingLink,10);
        ParentPage.click(mp.outboxLink,10);
    }
}
