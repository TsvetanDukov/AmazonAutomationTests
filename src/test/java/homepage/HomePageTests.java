package homepage;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.SignInPage;

import static org.testng.Assert.*;

public class HomePageTests extends BaseTest {

    @Test
    public void testAccountAndListsMenu() {
        assertTrue(homePage.isAccountAndListsLinkDisplayed(), "Account & Lists link is not displayed!");
        homePage.hoverOverAccountList();
        SignInPage signInPage = homePage.clickSignInThroughAccountsMenu();
        assertEquals(signInPage.getPageTitle(), "Amazon Sign-In", "Page title is incorrect!");
    }
}
