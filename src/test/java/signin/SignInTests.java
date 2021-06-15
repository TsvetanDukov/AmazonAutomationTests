package signin;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CustomerServicePage;
import pages.RegistrationPage;
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

    @Test
    public void testHelpLink() {
        homePage.hoverOverAccountList();
        SignInPage signInPage = homePage.clickSignInThroughAccountsMenu();
        assertTrue(signInPage.isHelpLinkDisplayed(), "Bottom help link is not displayed!");
        CustomerServicePage servicePage = signInPage.clickHelpLink();
    }

    @Test(dataProvider = "setData")
    public void testEmailFieldWithInvalidData(String input) {
        homePage.hoverOverAccountList();
        SignInPage signInPage = homePage.clickSignInThroughAccountsMenu();
        signInPage.setEmailField(input);
        signInPage.clickContinueButton();
    }

    @DataProvider
    public Object [] setData() {
        Object [] input = new Object [3];
        input [0] = " ";
        input [1] = "1";
        input [2] = "@";
        return input;
    }

    @Test
    public void testErrorEmptyFieldErrorMessage() {
        homePage.hoverOverAccountList();
        SignInPage signInPage = homePage.clickSignInThroughAccountsMenu();
        signInPage.setEmailField(" ");
        signInPage.clickContinueButton();
        assertEquals(signInPage.verifyEmptyFieldErrorMessage(), "Enter your email or mobile phone number");
    }

    @Test
    public void testIncorrectPhoneNumber() {
        homePage.hoverOverAccountList();
        SignInPage signInPage = homePage.clickSignInThroughAccountsMenu();
        signInPage.setEmailField("123");
        signInPage.clickContinueButton();
        assertEquals(signInPage.verifyIncorrectPhoneNumberMessage(), "Incorrect phone number");
    }

    @Test
    public void testCreateAccountButton() {
        homePage.hoverOverAccountList();
        SignInPage signInPage = homePage.clickSignInThroughAccountsMenu();
        RegistrationPage registrationPage = signInPage.clickCreateAccountButton();
        assertEquals(registrationPage.verifyPageTitle(), "Amazon Registration");
    }
}
