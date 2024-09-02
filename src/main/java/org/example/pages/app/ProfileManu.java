package main.java.org.example.pages.app;

import main.java.org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileManu extends BasePage {
    @FindBy(xpath = "//div[@role='menu']//li[@aria-label='Sign out']")
    private WebElement signOut;

    public ProfileManu(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignOut() {
        actionHelper.clickOnElement(this.signOut);
    }
    public boolean pageIsLoaded() {
        return waitHelper.waitUntilElementsWillBeVisible(this.signOut);
    }
}
