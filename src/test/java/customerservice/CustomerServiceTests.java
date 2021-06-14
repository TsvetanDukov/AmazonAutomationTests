package customerservice;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CustomerServicePage;
import pages.SignInPage;

import static org.testng.Assert.*;

public class CustomerServiceTests extends BaseTest {

    @Test
    public void checkPageHeader() {
        CustomerServicePage servicePage = homePage.clickCustomerServiceLink();
        assertEquals(servicePage.verifyPageHeader(), "Hello. What can we help you with?",
                "Page header is incorrect!");
    }

    @Test
    public void testYourOrdersLinkWithoutRegistration() {
        CustomerServicePage servicePage = homePage.clickCustomerServiceLink();
        assertTrue(servicePage.isYourOrdersLinkDisplayed(), "Your orders link is not displayed!");
        //If we are not registered user or not logged in, we should be redirect to "Sign-In page"
        SignInPage signInPage = servicePage.clickYourOrdersLinkWithoutRegistration();
        assertEquals(signInPage.verifyPageHeader(), "Sign-In", "Page header is incorrect!");
    }

    @Test
    public void testReturnAndRefundsLinkWithoutRegistration() {
        CustomerServicePage servicePage = homePage.clickCustomerServiceLink();
        assertTrue(servicePage.isReturnAndRefundsLinkDisplayed(), "Returns & Refunds link is not displayed!");
        //If we are not registered user or not logged in, we should be redirect to "Sign-In page"
        SignInPage signInPage = servicePage.clickReturnAndRefundsWithoutRegistration();
        assertEquals(signInPage.verifyPageHeader(), "Sign-In", "Page header is incorrect!");
    }

    @Test
    public void testSearchFieldAndNextAndPreviousPageButtons() {
        CustomerServicePage servicePage = homePage.clickCustomerServiceLink();
        assertTrue(servicePage.isSearchFieldDisplayed(), "Search field is not displayed");
        servicePage.enterTextInSearchField("test");
        assertEquals(servicePage.searchResults(), "109 search results for test",
                "Wrong search results field message!");
        assertTrue(servicePage.isNextResultPageButtonDisplayed(), "Next page result button is not displayed!");
        servicePage.clickNextResultPageButton();
        assertTrue(servicePage.isPreviousResultButtonDisplayed(),
                "Previous page results button is not displayed!");
        servicePage.clickPreviousResultButton();
    }
}
