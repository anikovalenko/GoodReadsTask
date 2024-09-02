package main.java.org.example.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionHelper {
    private WaitHelper waitHelper;
    private Actions actions;
    private JavascriptExecutor js;

    public ActionHelper(WaitHelper waitHelper, WebDriver driver) {
        this.waitHelper = waitHelper;
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    public void clickOnElement(WebElement element) {
        if (waitHelper.waitUntilElementWillBeClickable(element)) {
            element.click();
        }
    }

    public void fillField(WebElement element, String value) {
        if (waitHelper.waitUntilElementWillBeVisible(element) && value != null) {
            element.sendKeys(value);
        }
    }

    public void selectOption(WebElement element, String value) {
        if (value != null) {
            Select select = new Select(element);
            select.selectByVisibleText(value);
        }
    }

    public void hoverOverElement(WebElement element) {
        actions.moveToElement(element).build().perform();
    }

    public void pressEnter() {
        actions.sendKeys(Keys.ENTER).build().perform();
    }
}
