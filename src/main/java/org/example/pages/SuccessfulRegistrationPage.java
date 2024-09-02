package main.java.org.example.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessfulRegistrationPage extends BasePage {
    @FindBy(xpath = "//*[@class='actionLink']")
    WebElement skipLink;

    public SuccessfulRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSkipThisStepLink() {
        actionHelper.clickOnElement(this.skipLink);
    }

    public boolean pageIsLoaded() {
        return waitHelper.waitUntilElementsWillBeVisible(this.skipLink);
    }
}
