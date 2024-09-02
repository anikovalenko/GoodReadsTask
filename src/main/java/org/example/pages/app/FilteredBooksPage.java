package main.java.org.example.pages.app;

import main.java.org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FilteredBooksPage extends BasePage {
    @FindBy(tagName = "tr")
    private List<WebElement> results;

    public FilteredBooksPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnInnerElement(WebElement innerElement) {
        actionHelper.clickOnElement(innerElement);
    }

    public List<WebElement> getResults() {
        return results;
    }

    public WebElement findInnerWantToReadButton(WebElement book) {
        return book.findElement(By.xpath(".//button[@class='wtrToRead']"));
    }

    public WebElement findInnerReadButton(WebElement book) {
        WebElement innerOpenMenuIcon = book.findElement(By.xpath(".//button[@class='wtrShelfButton']"));
        actionHelper.hoverOverElement(innerOpenMenuIcon);
        return book.findElement(By.xpath("//button[@value='read']"));
    }

    public boolean pageIsLoaded() {
        return waitHelper.waitUntilElementsWillBeVisible(this.results);
    }
}
