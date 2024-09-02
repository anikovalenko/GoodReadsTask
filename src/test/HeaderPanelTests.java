package test;

import main.java.org.example.pages.app.HeaderPanel;
import main.java.org.example.pages.app.ProfileManu;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderPanelTests extends BaseTest {

    @Test
    public void successFulLogOut() {
        headerPanel = new HeaderPanel(driver);
        Assert.assertTrue(headerPanel.pageIsLoaded());
        headerPanel.clickOnProfileIcon();
        profileManu = new ProfileManu(driver);
        Assert.assertTrue(profileManu.pageIsLoaded());
        profileManu.clickOnSignOut();
    }
}
