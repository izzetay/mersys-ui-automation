package stepDefinitions;

import io.cucumber.java.en.Given;
import pages.LoginPage;
import pages.ParentPage;
import utilities.GWD;

public class LoginSteps {

    LoginPage lp = new LoginPage(GWD.getDriver());

    @Given("User navigates to the {string} page")
    public void userNavigatesWebsite(String url) {
        GWD.getDriver().get(url);
    }

    @Given("User logs in with valid credentials")
    public void userLogsInWithValidCredentials() {
        ParentPage.click(lp.usernameBox,10);
        ParentPage.mySendKeys(lp.usernameBox, "student10");
        ParentPage.click(lp.passwordBox,10);
        ParentPage.mySendKeys(lp.passwordBox, "pass.s10");
        ParentPage.click(lp.loginButton,10);
    }
}
