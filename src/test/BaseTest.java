package test;

import main.java.org.example.pages.*;
import main.java.org.example.pages.app.FilteredBooksPage;
import main.java.org.example.pages.app.HeaderPanel;
import main.java.org.example.pages.app.ProfileManu;
import main.java.org.example.pages.app.ReviewPopup;
import main.java.org.example.providers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    protected static WebDriver driver;
    private static DriverManager driverManager;
    protected WelcomePage welcomePage;
    protected SignUpPage signUpPage;
    protected VerificationPage verificationPage;
    protected SuccessfulRegistrationPage successfulRegistrationPage;
    protected FavoriteListPage favoriteListPage;
    protected RateBooksPage rateBooksPage;
    protected HeaderPanel headerPanel;
    protected ProfileManu profileManu;
    protected SignInOptionsPage signInOptionsPage;
    protected SignInPage signInPage;
    protected FilteredBooksPage filteredBooksPage;
    protected ReviewPopup reviewPopup;

    @BeforeClass
    public static void setup() {
        driverManager = new DriverManager();
        driver = driverManager.getDriver();
    }

//    @AfterClass
//    public static void closeBrowser() {
//        driverManager.closeBrowser();
//    }
}
