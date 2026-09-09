package stepDefinitions;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.GradingPage;
import pages.ParentPage;
import java.time.Duration;
import static utilities.GWD.getDriver;

public class GradingSteps {

    GradingPage gp = new GradingPage(getDriver());
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    @Then("User verifies being successfully redirected to the {string} page")
    public void userVerifiesSuccessfullyRedirectedToThePage(String pageName) {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("grading"));
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(pageName.toLowerCase()), "URL beklenen sayfa adını içermiyor!");

        System.out.println("Doğrulama Başarılı: " + pageName + " sayfasına ulaşıldı.");

    }

    @Then("User verifies that the {string} button on the page is visible and clickable")
    public void userVerifiesThatTheButtonOnThePageIsVisibleAndClickable(String buttonName) {

        if (buttonName.contains("Transcript")) {
            ParentPage.click(gp.reportsTab, 10);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }

        WebElement targetButton = null;

        switch (buttonName) {
            case "Course Grade":
                targetButton = (WebElement) gp.letterGradesList;
                break;
            case "Student Transcript":
                targetButton = gp.studentTranscriptButton;
                break;
            case "Transcript By Subject":
                targetButton = gp.transcriptBySubjectButton;
                break;
        }

        if (targetButton == null) {
            Assert.fail("HATA: " + buttonName + " isminde bir buton Page sınıfında tanımlanmamış!");
        }

        wait.until(ExpectedConditions.visibilityOf(targetButton));
        Assert.assertTrue(targetButton.isDisplayed(), buttonName + " butonu ekranda görünmüyor!");

        wait.until(ExpectedConditions.elementToBeClickable(targetButton));
        Assert.assertTrue(targetButton.isEnabled(), buttonName + " butonu şu an aktif/tıklanabilir değil!");

        System.out.println("Başarılı: " + buttonName + " butonu görünür ve tıklanabilir durumda.");
    }

    @Then("User verifies that the course grades are successfully displayed in the list")
    public void userVerifiesThatTheCourseGradesAreSuccessfullyDisplayedInTheList() {

        wait.until(ExpectedConditions.visibilityOfAllElements(gp.letterGradesList));
        Assert.assertFalse(gp.letterGradesList.isEmpty(), "ERROR: The grade list is empty, no grades are displayed!");

        for (WebElement grade : gp.letterGradesList) {
            Assert.assertTrue(grade.isDisplayed(), "ERROR: One of the grades in the list is not visible on the screen!");
        }

        System.out.println("Success: A total of " + gp.letterGradesList.size() + " course grades are displayed on the screen.");
    }
}
