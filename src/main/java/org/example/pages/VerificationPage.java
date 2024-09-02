package main.java.org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class VerificationPage extends BasePage {
    @FindBy(xpath = "//input[@name='code']")
    private WebElement verificationCodeInput;
    @FindBy(xpath = "//input[@aria-label='Verify OTP Button']")
    private WebElement submitButton;

    public VerificationPage(WebDriver driver) {
        super(driver);
    }

    public void fillInVerificationCode(String codeValue) {
        actionHelper.fillField(this.verificationCodeInput, codeValue);
    }

    public void clickOnSubmitButton() {
        actionHelper.clickOnElement(this.submitButton);
    }

    public boolean pageIsLoaded() {
        return waitHelper.waitUntilElementsWillBeVisible(
                this.verificationCodeInput, this.submitButton);
    }
}
