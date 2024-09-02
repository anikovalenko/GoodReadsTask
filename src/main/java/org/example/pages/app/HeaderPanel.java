package main.java.org.example.pages.app;

import main.java.org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderPanel extends BasePage {
    @FindBy(xpath = "//span[@class='headerPersonalNav']")
    private WebElement profileIcon;
    @FindBy(xpath = "//header//input[@aria-label='Search books']")
    private WebElement searchField;
    @FindBy(xpath = "//div[@class='gr-bookSearchResults__item']/a")
    private List<WebElement> searchResults;
    @FindBy(xpath = "//button[@aria-label='Search']")
    private WebElement searchIcon;

    public HeaderPanel(WebDriver driver) {
        super(driver);
    }

    public void enterSearchText(String searchText) {
        actionHelper.fillField(this.searchField, searchText);
    }

    public void clickOnSearchIcon() {
        actionHelper.clickOnElement(this.searchIcon);
    }

    public void clickOnProfileIcon() {
        actionHelper.clickOnElement(this.profileIcon);
    }

    public boolean pageIsLoaded() {
        return waitHelper.waitUntilElementsWillBeVisible(
                this.profileIcon, this.searchField, this.searchIcon);
    }
}
