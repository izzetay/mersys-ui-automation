package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AssignmentsPage extends ParentPage{

    public AssignmentsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//span[@class='mat-focus-indicator'])[4]")
    public WebElement assignmentsLink;

    @FindBy(css = "div[class='mat-mdc-tooltip-surface mdc-tooltip__surface']")
    public WebElement assignmentsCountBadge;

    @FindBy(css = "div[class='assignment']")
    public WebElement assignments;

    //US-19
    // Sayfadaki tüm Discussion (Mesaj) butonları
    @FindBy(css = "ms-icon-button[icon='comments-alt']")
    public List<WebElement> discussionButtonsList;

    @FindBy(css = "div[class='comments']")
    public WebElement discussionChatArea;

    @FindBy(xpath = "(//span[@class='mat-focus-indicator'])[45]")
    public WebElement attachFilesButton;

    @FindBy(css = "textarea[formcontrolname='commentText']")
    public WebElement commentTextArea;

    @FindBy(xpath = "(//span[@class='mat-focus-indicator'])[47]")
    public WebElement apSendButton;

    // Ekranda herhangi bir yerinde "Success", "successfully" veya "başarı" kelimesi geçen bir element
    @FindBy(xpath = "//*[contains(translate(text(), 'SUCCESS', 'success'), 'success')]")
    public WebElement successMessage;

    @FindBy(css = "div[class='comment-time secondary-text']")
    public List<WebElement> commentTimeList;

}
