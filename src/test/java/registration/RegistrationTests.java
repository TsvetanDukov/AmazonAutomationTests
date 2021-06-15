package registration;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AmazonBusinessPage;
import pages.RegistrationPage;
import pages.SignInPage;

import static org.testng.Assert.*;

public class RegistrationTests extends BaseTest {

    @Test
    public void verifyPageHeader() {
        homePage.hoverOverAccountList();
        SignInPage signInPage = homePage.clickSignInThroughAccountsMenu();
        RegistrationPage registrationPage = signInPage.clickCreateAccountButton();
        assertEquals(registrationPage.getPageHeader(), "Create account", "Page header is incorrect!");
    }

    @Test
    public void testSignInLink() {
        homePage.hoverOverAccountList();
        SignInPage signInPage = homePage.clickSignInThroughAccountsMenu();
        RegistrationPage registrationPage = signInPage.clickCreateAccountButton();
        assertTrue(registrationPage.isAlreadyHaveAnAccountLinkDisplayed(), "SignIn link is not displayed!");
        registrationPage.clickSignInLink();
        assertEquals(signInPage.getPageTitle(), "Amazon Sign-In", "Page title is incorrect!");
    }

    @Test
    public void testCreateBusinessAccountLink() {
        homePage.hoverOverAccountList();
        SignInPage signInPage = homePage.clickSignInThroughAccountsMenu();
        RegistrationPage registrationPage = signInPage.clickCreateAccountButton();
        assertTrue(registrationPage.isCreateBusinessAccountDisplayed(),
                "Create business account link is not displayed!");
        AmazonBusinessPage businessPage = registrationPage.clickCreateBusinessAccountLink();
        assertEquals(businessPage.getPageTitle(), "Amazon Business");
    }

    @Test
    public void verifyPageElements() {
        homePage.hoverOverAccountList();
        SignInPage signInPage = homePage.clickSignInThroughAccountsMenu();
        RegistrationPage registrationPage = signInPage.clickCreateAccountButton();
        assertTrue(registrationPage.isYourNameFieldDisplayed(), "Your name field is not displayed!");
        assertTrue(registrationPage.isEmailFieldDisplayed(), "Email field is not displayed!");
        assertTrue(registrationPage.isPasswordFieldDisplayed(), "Password field is not displayed!");
        assertTrue(registrationPage.isReEnterPasswordFieldDisplayed(),
                "Re-enter password field is not displayed!");
        assertTrue(registrationPage.isContinueButtonDisplayed(), "Continue button is not displayed!");
    }
}
