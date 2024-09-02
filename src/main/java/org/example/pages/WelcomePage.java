package main.java.org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BasePage {
    @FindBy(xpath = "//a[contains(@href, 'register')]")
    private WebElement signUpWithEmailButton;
    @FindBy(xpath = "//div[@id='signIn']//a")
    private WebElement signInLink;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignUpButton() {
        actionHelper.clickOnElement(signUpWithEmailButton);
    }

    public void clickOnSignInLink() {
        actionHelper.clickOnElement(signInLink);
    }

    public boolean pageIsLoaded() {
        return waitHelper.waitUntilElementsWillBeVisible(
                this.signUpWithEmailButton, this.signInLink);
    }
}
