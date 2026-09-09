package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AssignmentsPage;
import pages.ParentPage;
import utilities.GWD;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import static pages.ParentPage.hover;
import static pages.ParentPage.wait;

public class AssignmentsSteps {

    AssignmentsPage ap = new AssignmentsPage(GWD.getDriver());

    @Given("User hovers over the {string} link on the home page")
    public void userHoversOverLinkNameOnHomepage(String linkName) {
        wait.until(ExpectedConditions.visibilityOf(ap.assignmentsLink));

        hover(ap.assignmentsLink);
    }

    @Then("User verifies that the total number of assigned tasks is displayed")
    public void userVerifiesTotalNumberOfAssignedTasks(){
        wait.until(ExpectedConditions.visibilityOf(ap.assignmentsCountBadge));

        Assert.assertTrue(ap.assignmentsCountBadge.isDisplayed(), "Gorev sayisi (Badge) ekranda gorunmuyor!");
        String countText = ap.assignmentsCountBadge.getText();
        Assert.assertFalse(countText.isEmpty(), "Gorev sayisi bos donuyor!");
    }

    @When("User clicks on the {string} link on the home page")
    public void userClicksLinkOnHomepage(String linkName) {
        switch (linkName) {
            case "Assignments":
                wait.until(ExpectedConditions.visibilityOf(ap.assignmentsLink));

                JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

                js.executeScript("arguments[0].click();", ap.assignmentsLink);

            case "Another Menu":
                break;
        }
    }

    @Then("User verifies that all assigned tasks are listed")
    public void userVerifiesThatAllAssignedTasksAreListed() {
        wait.until(ExpectedConditions.visibilityOf(ap.assignments));

        Assert.assertTrue(ap.assignments.isDisplayed(), "Gorevler tablosu acilamadi!");
    }

    // US-19
    @When("User clicks on the {string} icon of a random assignment in the list")
    public void userClickOnRandomAssignmentOnTheList(String iconName) {

        wait.until(ExpectedConditions.visibilityOfAllElements(ap.discussionButtonsList));
        int buttonCount = ap.discussionButtonsList.size();
        int randomIndex = (int) (Math.random() * buttonCount);
        ParentPage.click(ap.discussionButtonsList.get(randomIndex), 10);
        System.out.println("Başarılı! Toplam " + buttonCount + " ödev arasından " + (randomIndex + 1) + ". sıradakine tıklandı.");
    }

    @Then("User verifies the chat area where they can view past discussions")
    public void userVerifiesDiscussionPage() {

        wait.until(ExpectedConditions.visibilityOf(ap.discussionChatArea));

        Assert.assertTrue(ap.discussionChatArea.isDisplayed(), "Sohbet alanı ekranda görünmüyor!");
    }

    @And("User types {string} into the text editor on the Assignment page")
    public void userTypesOnTextEditor(String text){
        ap.commentTextArea.sendKeys(text);

    }

    @When("User attaches a sample file for the assignment from the {string} section")
    public void userAttachesSampleFile(String attachText) throws AWTException {

        String dosyaYolu = "C:\\Users\\isTheVAC\\Downloads\\blank.png";
        StringSelection stringSelection = new StringSelection(dosyaYolu);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        ParentPage.click(ap.attachFilesButton, 10);
        try { Thread.sleep(2000); } catch (Exception e) {}

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        try { Thread.sleep(1000); } catch (Exception e) {}

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        try { Thread.sleep(2000); } catch (Exception e) {}
    }

    @And("User clicks the {string} button on the Assignment page")
    public void userClickSend(String text){
        ParentPage.click(ap.apSendButton,10);
    }

    @Then("User verifies that a {string} message is not displayed on the screen")
    public void userVerifiesNoSuccessDisplayed(String successText) {

        try {
            WebDriverWait shortWait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(3));
            shortWait.until(ExpectedConditions.visibilityOf(ap.successMessage));

            Assert.fail("HATA: Ekranda Success mesajı çıktı! (Kabul kriterine aykırı)");

        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Negatif Test Başarılı: Beklendiği gibi ekranda bildiri (Success) mesajı çıkmadı.");
        }
    }

    @Then("User verifies that the sent message, file name, and time information are displayed in the flow")
    public void userVerifiesMessageInformation() {
        wait.until(ExpectedConditions.visibilityOfAllElements(ap.commentTimeList));
        int sonMesajIndex = ap.commentTimeList.size() - 1;
        Assert.assertTrue(ap.commentTimeList.get(sonMesajIndex).isDisplayed(), "HATA: Gönderilen mesajın saati akışta görünmüyor!");
        System.out.println("Mesaj başarıyla gönderildi ve saati akışta teyit edildi: " + ap.commentTimeList.get(sonMesajIndex).getText());
    }
}




