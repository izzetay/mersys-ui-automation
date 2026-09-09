package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage extends ParentPage {

    public NavigationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "ms-layout-menu-button[page='GRADING']")
    public WebElement gradingLink;

    @FindBy(css = "ms-layout-menu-button[page='CALENDAR']")
    public WebElement calenderLink;


}
