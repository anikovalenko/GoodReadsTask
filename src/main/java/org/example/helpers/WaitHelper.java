package main.java.org.example.helpers;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitHelper {

    WebDriverWait wait;

    public WaitHelper(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean waitUntilElementWillBeClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public boolean waitUntilElementWillBeVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public boolean waitUntilElementsWillBeVisible(WebElement... elements) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public boolean waitUntilElementsWillBeVisible(List<WebElement> elements) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
}
