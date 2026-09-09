package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalenderPage extends ParentPage{
    public CalenderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "table[style='table-layout: fixed;']")
    public List<WebElement> courseNamesTab;

    @FindBy(xpath = "(//span[@class='mat-focus-indicator'])[17]")
    public WebElement previusPageButton;

    @FindBy(xpath = "(//div[@class='mat-elevation-z4'])[3]")
    public WebElement completedClassEvent;

    // Tabs inside the course details modal
    @FindBy(xpath = "(//div[@role='tab'])[4]")
    public WebElement informationTab;

    @FindBy(xpath = "(//div[@role='tab'])[5]")
    public WebElement topicTab;

    @FindBy(xpath = "(//div[@role='tab'])[6]")
    public WebElement attachmentsTab;

    @FindBy(xpath = "(//div[@role='tab'])[7]")
    public WebElement recentEventsTab;

}
