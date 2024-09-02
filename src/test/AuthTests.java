package test;

import main.java.org.example.pages.*;
import main.java.org.example.pages.gmailpages.GmailInboxPage;
import main.java.org.example.pages.gmailpages.GmailLoginPage;
import main.java.org.example.pages.gmailpages.ReceivedEmailPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class AuthTests extends BaseTest {
    private final String validEmail = "";
    private final String validPass = "";

    @Test()
    public void signUpWithValidCredentials() {
        driver.get("https://www.goodreads.com/");
        welcomePage = new WelcomePage(driver);
        Assert.assertTrue(welcomePage.pageIsLoaded());
        welcomePage.clickOnSignUpButton();
        signUpPage = new SignUpPage(driver);
        Assert.assertTrue(signUpPage.pageIsLoaded());
        signUpPage.fillNameField("Ani");
        signUpPage.fillEmailField(validEmail);
        signUpPage.fillPasswordField(validPass);
        signUpPage.fillReEnterPasswordField(validPass);
        signUpPage.clickOnCreateAccountButton();

        String verificationCode = getVerificationCode();

        verificationPage = new VerificationPage(driver);
        Assert.assertTrue(verificationPage.pageIsLoaded());
        verificationPage.fillInVerificationCode(verificationCode);
        verificationPage.clickOnSubmitButton();

        successfulRegistrationPage = new SuccessfulRegistrationPage(driver);
        Assert.assertTrue(successfulRegistrationPage.pageIsLoaded());
        successfulRegistrationPage.clickOnSkipThisStepLink();

        successfulRegistrationPage = new SuccessfulRegistrationPage(driver);
        Assert.assertTrue(successfulRegistrationPage.pageIsLoaded());
        successfulRegistrationPage.clickOnSkipThisStepLink();

        favoriteListPage = new FavoriteListPage(driver);
        Assert.assertTrue(favoriteListPage.pageIsLoaded());
        favoriteListPage.clickOnBusinessOption();
        favoriteListPage.clickOnContinueButton();

        rateBooksPage = new RateBooksPage(driver);
        Assert.assertTrue(rateBooksPage.pageIsLoaded());
        rateBooksPage.rate5StarsForMultipleBooks(20);
        rateBooksPage.clickOnImFinishedLink();
    }

    @Test
    public void loginWithOutEnteringLoginPassword() {
        signInPage = new SignInPage(driver);
        Assert.assertTrue(signInOptionsPage.pageIsLoaded());
        signInPage.clickOnSignInButton();
        Assert.assertTrue(signInPage.getSignInButton().isDisplayed(),
                "Login without entering email/password should not be allowed");
    }

    @Test
    public void verifyLoginWithWrongPasswordIsForbidden() {
        signInPage = new SignInPage(driver);
        Assert.assertTrue(signInOptionsPage.pageIsLoaded());
        signInPage.enterPassword(validEmail);
        signInPage.enterPassword("somepassword");
        signInPage.clickOnSignInButton();
        Assert.assertTrue(signInPage.getSignInButton().isDisplayed(),
                "Login with invalid password should not be allowed");
    }

    @Test
    public void verifyLoginWithNonRegisteredEmailIsForbidden() {
        signInPage = new SignInPage(driver);
        Assert.assertTrue(signInOptionsPage.pageIsLoaded());
        signInPage.enterPassword("testtest@gmail.com");
        signInPage.enterPassword("somepassword");
        signInPage.clickOnSignInButton();
        Assert.assertTrue(signInPage.getSignInButton().isDisplayed(),
                "Login with non-registered email should not be allowed");
    }

    @Test
    public void navigateToSignInWithEmailPage() {
        driver.get("https://www.goodreads.com/");
        Assert.assertTrue(welcomePage.pageIsLoaded());
        welcomePage.clickOnSignInLink();
        signInOptionsPage = new SignInOptionsPage(driver);
        Assert.assertTrue(signInOptionsPage.pageIsLoaded());
        signInOptionsPage.clickOnSignInWithEmailButton();
    }

    @Test
    public void loginWithValidCredentials() {
        signInPage = new SignInPage(driver);
        Assert.assertTrue(signInOptionsPage.pageIsLoaded());
        signInPage.enterPassword(validEmail);
        signInPage.enterPassword(validPass);
        signInPage.clickOnSignInButton();
        Assert.assertThrows(NoSuchElementException.class,
                () -> signInPage.clickOnSignInButton());
    }

    private String getVerificationCode() {
        String originalTab = driver.getWindowHandle();
        openAdditionalTab(originalTab);
        driver.get("https://gmail.com");
        GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);
        gmailLoginPage.loginToGmail(validEmail, validPass);

        GmailInboxPage gmailInboxPage = new GmailInboxPage(driver);
        gmailInboxPage.clickOnReceivedEmail();

        ReceivedEmailPage receivedEmailPage = new ReceivedEmailPage(driver);
        String code = receivedEmailPage.getCode();
        driver.switchTo().window(originalTab);
        return code;
    }

    private void openAdditionalTab(String originalTab) {
        ((JavascriptExecutor) driver).executeScript("window.open('about:blank', '_blank');");

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
}
