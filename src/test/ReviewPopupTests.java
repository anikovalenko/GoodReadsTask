package test;

import main.java.org.example.pages.app.ReviewPopup;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class ReviewPopupTests extends BaseTest {

    @Test
    public void leasePositiveReview() {
        reviewPopup = new ReviewPopup(driver);
        Assert.assertTrue(reviewPopup.pageIsLoaded());
        reviewPopup.rateWithStars(5);
        reviewPopup.enterFeedback("The book was amazing");
        reviewPopup.selectOptionFromStartYear("2024");
        reviewPopup.selectOptionFromStartMonth("May");
        reviewPopup.selectOptionFromStartDay("2");
        reviewPopup.selectOptionFromEndYear("2024");
        reviewPopup.selectOptionFromEndMonth("July");
        reviewPopup.selectOptionFromEndDay("1");
        reviewPopup.clickOnPostButton();
        Assert.assertThrows(NoSuchElementException.class,
                () -> reviewPopup.clickOnPostButton());
    }
}
