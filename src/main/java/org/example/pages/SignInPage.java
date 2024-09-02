package main.java.org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@id='signInSubmit']")
    private WebElement signInButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String emailValue) {
        //verify email with some regexp
        actionHelper.fillField(this.emailField, emailValue);
    }

    public void enterPassword(String passwordValue) {
        actionHelper.fillField(this.passwordField, passwordValue);
    }

    public void clickOnSignInButton() {
        actionHelper.clickOnElement(this.signInButton);
    }

    public boolean pageIsLoaded() {
        return waitHelper.waitUntilElementsWillBeVisible(
                this.emailField, this.passwordField, this.signInButton);
    }

    public WebElement getSignInButton() {
        return signInButton;
    }
}
