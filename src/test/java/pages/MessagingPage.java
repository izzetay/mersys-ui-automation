package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagingPage extends ParentPage {
    public MessagingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //US_007
    @FindBy(css = "tbody.mdc-data-table__content")
    public WebElement trash;

    @FindBy(css = "input.mat-start-date")
    public WebElement date;

    @FindBy(css = "input.mat-end-date")
    public WebElement date2;

    @FindBy(xpath = "//*[text()=' This year ']")
    public WebElement dateThisYear;

    @FindBy(xpath = "//*[text()='Search']")
    public WebElement search;

    @FindBy(css = "div.ms-toast__headline")
    public WebElement successMessage;

    @FindBy(xpath = "//*[@icon='trash-restore']")
    public WebElement restoreButton;

    @FindBy(css = "button.error")
    public WebElement deleteButton;

    @FindBy(css = "mat-dialog-container")
    public WebElement confirmationDialog;

    @FindBy(xpath = "//button[.//*[normalize-space(text())='Delete']]")
    public WebElement dialogAnswer;

    @FindBy (xpath = "(//span[@class='mdc-button__label'])[6]")
    public WebElement hamburgerMenu;

    @FindBy(xpath = "//span[text()='Messaging']")
    public WebElement messagingLink;

    @FindBy(xpath = "//span[text()='Send Message']")
    public WebElement newMessageButton;

    @FindBy(css = "fa-icon[class='ng-fa-icon btn-fa btn-fa--table']")
    public WebElement receiversIcon;

    @FindBy(css = "(//div[@class='mat-mdc-form-field-flex'])[8]")
    public WebElement receiverSearchBox;

    @FindBy(css = "div[aria-describedby='cdk-describedby-message-ng-1-54']")
    public WebElement receiverOption;

    @FindBy(xpath = "//span[text()='Add & Close']")
    public WebElement addAndCloseButton;

    @FindBy(css = "ms-text-field[formcontrolname='title']")
    public WebElement subjectBox;

    @FindBy(id = "#tiny-angular_69952994311789242592362_ifr")
    public WebElement textEditorBox;

    @FindBy(css = "input[type='file']")
    public WebElement fileUploadInput;

    @FindBy(xpath = "//span[text()='Send']")
    public WebElement sendButton;

    @FindBy(xpath = "//span[text()='Send']")
    public WebElement outboxLink;

    @FindBy(css = "svg[data-icon='xmark']")
    public WebElement closeErrorButton;


}
