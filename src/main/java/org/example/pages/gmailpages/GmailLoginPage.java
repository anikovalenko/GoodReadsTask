package main.java.org.example.pages.gmailpages;

import main.java.org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailLoginPage extends BasePage {
    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//div[@class='SxkrO']")
    private WebElement notNowButton;

    public GmailLoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginToGmail(String email, String pass) {
        actionHelper.fillField(this.emailInput, email);
        actionHelper.pressEnter();
        actionHelper.fillField(this.passwordInput, pass);
        actionHelper.pressEnter();

        if (this.notNowButton != null) {
            actionHelper.clickOnElement(this.notNowButton);
        }
    }
}
