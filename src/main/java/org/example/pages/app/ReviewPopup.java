package main.java.org.example.pages.app;

import main.java.org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewPopup extends BasePage {

    @FindBy(xpath = "//div[@class='reviewFormEdit']//div[@class='stars']")
    private WebElement stars;
    @FindBy(xpath = "(//textarea)[1]")
    private WebElement feedbackInput;
    @FindBy(xpath = "//select[@class='rereadDatePicker smallPicker startYear']")
    private WebElement startYear;
    @FindBy(xpath = "//select[@class='rereadDatePicker largePicker startMonth']")
    private WebElement startMonth;
    @FindBy(xpath = "//select[@class='rereadDatePicker smallPicker startDay']")
    private WebElement startDay;
    @FindBy(xpath = "//select[@class='rereadDatePicker smallPicker endYear']")
    private WebElement endYear;
    @FindBy(xpath = "//select[@class='rereadDatePicker largePicker endMonth']")
    private  WebElement endMonth;
    @FindBy(xpath = "//select[@class='rereadDatePicker smallPicker endDay']")
    private WebElement endDay;
    @FindBy(xpath = "//input[@type='submit'][@value='Post']")
    private WebElement postButton;

    public ReviewPopup(WebDriver driver) {
        super(driver);
    }

    public void enterFeedback(String text) {
        actionHelper.fillField(this.feedbackInput, text);
    }

    public void selectOptionFromStartYear(String value) {
        actionHelper.selectOption(this.startYear, value);
    }

    public void selectOptionFromStartMonth(String value) {
        actionHelper.selectOption(this.startMonth, value);
    }

    public void selectOptionFromStartDay(String value) {
        actionHelper.selectOption(this.startDay, value);
    }

    public void selectOptionFromEndYear(String value) {
        actionHelper.selectOption(this.endYear, value);
    }

    public void selectOptionFromEndMonth(String value) {
        actionHelper.selectOption(this.endMonth, value);
    }

    public void selectOptionFromEndDay(String value) {
        actionHelper.selectOption(this.endDay, value);
    }

    public void clickOnPostButton(){
        actionHelper.clickOnElement(this.postButton);
    }

    public void rateWithStars(int starCount) {
        if (starCount < 1 || starCount > 5) throw new RuntimeException("You can rate 1 - 5 points");
        actionHelper.clickOnElement(
                this.stars.findElement(By.xpath("../a[" + starCount + "]")));
    }

    public boolean pageIsLoaded() {
        return waitHelper.waitUntilElementsWillBeVisible(
                this.stars, this.feedbackInput, this.endDay, this.endMonth, this.endYear,
                this.postButton, this.startDay, this.startYear, this.startMonth);
    }
}
