package main.java.org.example.pages;

import main.java.org.example.helpers.ActionHelper;
import main.java.org.example.helpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected WaitHelper waitHelper;
    protected ActionHelper actionHelper;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
        this.actionHelper = new ActionHelper(waitHelper, driver);
        PageFactory.initElements(driver, this);
    }
}
