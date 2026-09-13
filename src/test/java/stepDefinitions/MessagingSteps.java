package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.MessagingPage;
import pages.ParentPage;
import utilities.GWD;
import java.awt.*;
import java.io.File;
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

    @When("User clicks on the icon, searches for 'Teac' and selects a receiver")
    public void userClicksOnIconAndSelectsReceiver() {
        wait.until(ExpectedConditions.elementToBeClickable(mp.receiversIcon));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", mp.receiversIcon);
        wait.until(ExpectedConditions.elementToBeClickable(mp.receiverSearchBox));
        ParentPage.mySendKeys(mp.receiverSearchBox,"Teac");
        ParentPage.click(mp.receiverOption,10);
        ParentPage.click(mp.addAndCloseButton,10);
    }

    @When("User enters {string} as the message subject")
    public void userEntersMessageSubject(String subject) {
        wait.until(ExpectedConditions.elementToBeClickable(mp.subjectBox));
        ParentPage.mySendKeys(mp.subjectBox,subject);

    }

    @When("User types {string} into the text editor")
    public void userEntersTheTextEditor(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe.tox-edit-area__iframe")));
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("tinyMCE.activeEditor.setContent('<p>"+text+"</p>');");
        ParentPage.click(mp.textEditorBox,10);

    }

    @When("User attaches a sample file from the 'Attach Files' section")
    public void userAttachesSampleFile() {
        ParentPage.click(mp.succesMsgCloseButton,10);
        wait.until(ExpectedConditions.elementToBeClickable(mp.attachFilesButton));
        ParentPage.click(mp.attachFilesButton,10);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        File file = new File("src/test/resources/features/files/blank.png");
        String filePath = file.getAbsolutePath();

        WebElement gizliInput = GWD.getDriver().findElement(By.cssSelector("input[type='file']"));
        gizliInput.sendKeys(filePath);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).perform();
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
    }

    @When("User clicks the {string} button")
    public void userClicksOnButton(String sendStr) {
        ParentPage.click(mp.sendButton,10);
    }

    @Then("User should see a {string} message on the screen")
    public void userShouldSeeSuccesMessageOnScreen(String successText) {
        wait.until(ExpectedConditions.visibilityOf(mp.successMessage));
        Assert.assertTrue(mp.successMessage.getText().contains(successText), "No message has shown!");
    }

    @Then("User navigates to the {string} page from the hamburger menu and verifies that the sent message is in the list")
    public void userNavigatesToOutboxAndVerifiesTheSentMessage(String outboxStr) {
        ParentPage.click(mp.hamburgerMenu,10);
        ParentPage.click(mp.messagingLink,10);
        ParentPage.click(mp.outboxLink,10);
        String allDisplayedMessages = mp.allMessagesCount.getText();
        System.out.println("all displayed messages:" + allDisplayedMessages);

    }
}
