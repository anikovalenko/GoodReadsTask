package main.java.org.example.providers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

public class DriverManager {
    private WebDriver driver;

    private void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
    }

    public WebDriver getDriver() {
        if (driver == null) setUp();
        return driver;
    }

    public void closeBrowser() {
        if (driver != null) driver.close();
    }
}
