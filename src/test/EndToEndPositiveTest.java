package test;

import main.java.org.example.pages.app.FilteredBooksPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class EndToEndPositiveTest extends BaseTest {
    HeaderPanelTests headerPanelTests;
    AuthTests authTests;
    ReviewPopupTests reviewPopupTests;

    @Test()
    public void endToEndReviewBookScenario() {
        authTests = new AuthTests();
        authTests.signUpWithValidCredentials();
        headerPanelTests = new HeaderPanelTests();
        headerPanelTests.successFulLogOut();

        authTests.navigateToSignInWithEmailPage();
        authTests.loginWithOutEnteringLoginPassword();
        authTests.verifyLoginWithWrongPasswordIsForbidden();
        authTests.verifyLoginWithNonRegisteredEmailIsForbidden();
        authTests.loginWithValidCredentials();

        Assert.assertTrue(headerPanel.pageIsLoaded());
        headerPanel.enterSearchText("crime and mystery books");
        headerPanel.clickOnSearchIcon();

        filteredBooksPage = new FilteredBooksPage(driver);
        Assert.assertTrue(filteredBooksPage.pageIsLoaded());
        List<WebElement> results = filteredBooksPage.getResults();
        for (int i = 0; i < 3; i++) {
            WebElement book = results.get(i);
            WebElement innerWantToReadButton = filteredBooksPage.findInnerWantToReadButton(book);
            filteredBooksPage.clickOnInnerElement(innerWantToReadButton);

            WebElement innerReadButton = filteredBooksPage.findInnerReadButton(book);
            filteredBooksPage.clickOnInnerElement(innerReadButton);

            reviewPopupTests = new ReviewPopupTests();
            reviewPopupTests.leasePositiveReview();

            filteredBooksPage = new FilteredBooksPage(driver);
            Assert.assertTrue(filteredBooksPage.pageIsLoaded());

            headerPanelTests.successFulLogOut();
        }
    }
}
