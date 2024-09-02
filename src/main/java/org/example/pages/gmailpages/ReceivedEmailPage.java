package main.java.org.example.pages.gmailpages;

import main.java.org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReceivedEmailPage extends BasePage {

    @FindBy(xpath = "(//p[string-length(normalize-space(text())) = 6 and translate(normalize-space(text()), '0123456789', '') = ''])[last()]")
    private WebElement codeElement;

    public ReceivedEmailPage(WebDriver driver) {
        super(driver);
    }

    public String getCode() {
        return this.codeElement.getText();
    }
}
