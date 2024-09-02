package main.java.org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInOptionsPage extends BasePage {
    @FindBy(xpath = "//button[contains(text(), 'Sign in with email')]")
    WebElement signInWithEmailButton;

    public SignInOptionsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignInWithEmailButton() {
        actionHelper.clickOnElement(this.signInWithEmailButton);
    }

    public boolean pageIsLoaded() {
        return waitHelper.waitUntilElementsWillBeVisible(this.signInWithEmailButton);
    }
}
