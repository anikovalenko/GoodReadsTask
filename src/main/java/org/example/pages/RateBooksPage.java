package main.java.org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RateBooksPage extends BasePage {
    @FindBy(xpath = "//a[@title='it was amazing']")
    private List<WebElement> _5starList;
    @FindBy(xpath = "//*[contains(text(), 'finished')]")
    private WebElement imFinishedLink;

    public RateBooksPage(WebDriver driver) {
        super(driver);
    }

    public void rate5StarsForMultipleBooks(int count) {
        for (int i = 0; i < count; i++) {
            actionHelper.clickOnElement(_5starList.get(i));
        }
    }

    public void clickOnImFinishedLink() {
        actionHelper.clickOnElement(this.imFinishedLink);
    }

    public boolean pageIsLoaded() {
        return waitHelper.waitUntilElementsWillBeVisible(this._5starList)
                && waitHelper.waitUntilElementsWillBeVisible(this.imFinishedLink);
    }
}
