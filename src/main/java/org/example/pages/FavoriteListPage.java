package main.java.org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FavoriteListPage extends BasePage {
    @FindBy(xpath = "//input[@id='favorites_Business']")
    WebElement businessOption;
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    public FavoriteListPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnBusinessOption() {
        actionHelper.clickOnElement(this.businessOption);
    }

    public void clickOnContinueButton() {
        actionHelper.clickOnElement(this.continueButton);
    }

    public boolean pageIsLoaded() {
        return waitHelper.waitUntilElementsWillBeVisible(this.businessOption);
    }
}
