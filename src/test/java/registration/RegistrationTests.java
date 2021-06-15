package registration;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonBusinessPage;
import pages.AuthenticationPage;
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

    @Test(dataProvider = "setInvalidData")
    public void testRegistrationForm(String name, String email, String password, String reEnter) {
        //Four fields tests with invalid credentials, without "Continue" to prevent protection check
        homePage.hoverOverAccountList();
        SignInPage signInPage = homePage.clickSignInThroughAccountsMenu();
        RegistrationPage registrationPage = signInPage.clickCreateAccountButton();
        registrationPage.setNameField(name);
        registrationPage.setEmailField(email);
        registrationPage.setPasswordField(password);
        registrationPage.setReEnterPasswordField(reEnter);

    }

    @DataProvider
    public Object[] setInvalidData() {
        Object[][] input = new Object[4][4];
        input[0][0] = "Ceco";
        input[0][1] = "new_email@gmail.com";
        input[0][2] = "SecretPassword";
        input[0][3] = "SecretPassword";

        input[1][0] = "Dukov";
        input[1][1] = "another_new_email@gmail.com";
        input[1][2] = "SuperSecretPassword";
        input[1][3] = "SuperSecretPassword";

        input[2][0] = "Ceco Dukov";
        input[2][1] = "test.automation@gmail.com";
        input[2][2] = "UltraSuperSecretPassword";
        input[2][3] = "UltraSuperSecretPassword";

        input[3][0] = "Tsvetan Dukov";
        input[3][1] = "test.automation.egt@gmail.com";
        input[3][2] = "MegaSuperSecretPassword";
        input[3][3] = "MegaSuperSecretPassword";
        return input;
    }

    @Test(dataProvider = "setValidData")
    public void testMakeRegistration(String name, String email, String password, String reEnter) {
        homePage.hoverOverAccountList();
        SignInPage signInPage = homePage.clickSignInThroughAccountsMenu();
        RegistrationPage registrationPage = signInPage.clickCreateAccountButton();
        registrationPage.setNameField(name);
        registrationPage.setEmailField(email);
        registrationPage.setPasswordField(password);
        registrationPage.setReEnterPasswordField(reEnter);
        AuthenticationPage authenticationPage = registrationPage.clickContinueButton();
        assertEquals(authenticationPage.getPageTitle(), "Authentication required");
    }

    @DataProvider
    public Object[] setValidData() {
        Object[][] input = new Object[1][4];
        input [0][0] = "Tsvetan Dukov";
        input [0][1] = "test.automation.egt@gmail.com";
        input [0][2] = "SecretPassword";
        input [0][3] = "SecretPassword";
        return input;
    }
}
