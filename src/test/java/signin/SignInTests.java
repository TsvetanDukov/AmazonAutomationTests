package signin;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.SignInPage;

import static org.testng.Assert.*;

public class SignInTests extends BaseTest {

    @Test
    public void verifyPageTitle() {
        homePage.hoverOverAccountList();
        SignInPage signInPage = homePage.clickSignInThroughAccountsMenu();
        assertEquals(signInPage.getPageTitle(), "Amazon Sign-In", "Page title is incorrect!");
    }

    @Test
    public void verifyFieldsAndButtons() {
        homePage.hoverOverAccountList();
        SignInPage signInPage = homePage.clickSignInThroughAccountsMenu();
        assertTrue(signInPage.isEmailFieldDisplayed(), "Email field is not displayed!");
        assertTrue(signInPage.isContinueButtonDisplayed(), "Continue button is not displayed!");
        assertTrue(signInPage.isCreateAccountButtonDisplayed(), "Create account button is not displayed!");
        assertTrue(signInPage.isNeedHelpLinkDisplayed(), "Need help link is not displayed!");
    }

    @Test
    public void testNeedHelpLink() {
        homePage.hoverOverAccountList();
        SignInPage signInPage = homePage.clickSignInThroughAccountsMenu();
        signInPage.expandNeedHelpLink();
        assertTrue(signInPage.isForgotPasswordLinkDisplayed(),
                "Forgotten password link is not displayed, after expanding Need help? link");
        assertTrue(signInPage.isOtherIssuesLinkDisplayed(),
                "Other issues link is not displayed, after expanding Need help? link");
    }
}
