package main.java.org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {
    @FindBy(xpath = "//input[@id='ap_customer_name']")
    private WebElement nameField;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@name='passwordCheck']")
    private WebElement reEnterPassword;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement createAccountButton;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void fillNameField(String nameValue) {
        actionHelper.fillField(this.nameField, nameValue);
    }

    public void fillEmailField(String emailValue) {
        actionHelper.fillField(this.emailField, emailValue);
    }

    public void fillPasswordField(String passwordValue) {
        actionHelper.fillField(this.passwordField, passwordValue);
    }

    public void fillReEnterPasswordField(String password2Value) {
        actionHelper.fillField(this.reEnterPassword, password2Value);
    }

    public void clickOnCreateAccountButton() {
        actionHelper.clickOnElement(this.createAccountButton);
    }

    public boolean pageIsLoaded() {
        return waitHelper.waitUntilElementsWillBeVisible(this.nameField, this.emailField,
                this.passwordField, this.reEnterPassword, this.createAccountButton);
    }
}
