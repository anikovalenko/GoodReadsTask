package main.java.org.example.pages.gmailpages;

import main.java.org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailInboxPage extends BasePage {
    @FindBy(xpath = "(//span[text()='Goodreads'])[2]")
    WebElement emailFromGoodReads;

    public GmailInboxPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnReceivedEmail() {
        actionHelper.clickOnElement(this.emailFromGoodReads);
    }
}
