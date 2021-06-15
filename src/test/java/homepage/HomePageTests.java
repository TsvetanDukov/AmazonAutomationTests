package homepage;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CustomerServicePage;
import pages.GiftCardsPage;
import pages.SignInPage;
import pages.TodayDealsPage;

import static org.testng.Assert.*;

public class HomePageTests extends BaseTest {

    @Test
    public void testAccountAndListsMenu() {
        assertTrue(homePage.isAccountAndListsLinkDisplayed(), "Account & Lists link is not displayed!");
        homePage.hoverOverAccountList();
        SignInPage signInPage = homePage.clickSignInThroughAccountsMenu();
        assertEquals(signInPage.getPageTitle(), "Amazon Sign-In", "Page title is incorrect!");
    }

    @Test
    public void testTodayDealsLink() {
        TodayDealsPage dealsPage = homePage.clickTodayDealsLink();
        assertEquals(dealsPage.getPageHeader(), "Deals and Promotions", "Page Header is incorrect!");
        assertEquals(dealsPage.getPageTitle(),
                "International Shopping: Shop special offers and deals that ship internationally");
    }

    @Test
    public void testCustomerServiceLink() {
        CustomerServicePage servicePage = homePage.clickCustomerServiceLink();
        assertEquals(servicePage.verifyPageHeader(), "Hello. What can we help you with?",
                "Page header is incorrect!");
        assertEquals(servicePage.verifyPageTitle(), "Amazon.com Help: Help");
    }

    @Test
    public void testGiftCardsLink() {
        assertTrue(homePage.isGiftCardsLinkDisplayed(), "Gift Cards is not displayed!");
        GiftCardsPage cardsPage = homePage.clickGiftCardsLink();
        assertEquals(cardsPage.verifyPageHeader(), "Gift Cards");
        assertEquals(cardsPage.getPageTitle(), "Amazon.com Gift Cards");
    }
}
