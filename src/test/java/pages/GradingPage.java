package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class GradingPage {
    public GradingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "ms-standard-button[icon='print']")
    public WebElement printButton;

    @FindBy(css = "#print")
    public WebElement downloadButton;

}