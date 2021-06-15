package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private final WebDriver driver;
    private final By pageHeader = By.xpath("//h1[normalize-space()='Create account']");
    private final By signInLink = By.xpath("//a[normalize-space() = 'Sign-In']");
    private final By businessAccount = By.cssSelector("#ab-registration-link");
    private final By nameField = By.id("ap_customer_name");
    private final By emailField = By.id("ap_email");
    private final By passwordField = By.id("ap_password");
    private final By reEnterPasswordField = By.id("ap_password_check");
    private final By continueButton = By.id("continue");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String verifyPageTitle() {
        return driver.getTitle();
    }

    public String getPageHeader() {
        return driver.findElement(pageHeader).getText();
    }

    public boolean isAlreadyHaveAnAccountLinkDisplayed() {
        return driver.findElement(signInLink).isDisplayed();
    }

    public void clickSignInLink() {
        driver.findElement(signInLink).click();
    }

    public boolean isCreateBusinessAccountDisplayed() {
        return driver.findElement(businessAccount).isDisplayed();
    }

    public AmazonBusinessPage clickCreateBusinessAccountLink() {
        driver.findElement(businessAccount).click();
        return new AmazonBusinessPage(driver);
    }

    public boolean isYourNameFieldDisplayed() {
        return driver.findElement(nameField).isDisplayed();
    }

    public boolean isEmailFieldDisplayed() {
        return driver.findElement(emailField).isDisplayed();
    }
    public boolean isPasswordFieldDisplayed() {
        return driver.findElement(passwordField).isDisplayed();
    }

    public boolean isReEnterPasswordFieldDisplayed() {
        return driver.findElement(reEnterPasswordField).isDisplayed();
    }

    public boolean isContinueButtonDisplayed() {
        return driver.findElement(continueButton).isDisplayed();
    }

    public void setNameField(String input) {
        driver.findElement(nameField).sendKeys(input);
    }

    public void setEmailField(String input) {
        driver.findElement(emailField).sendKeys(input);
    }

    public void setPasswordField(String input) {
        driver.findElement(passwordField).sendKeys(input);
    }

    public void setReEnterPasswordField(String input) {
        driver.findElement(reEnterPasswordField).sendKeys(input);
    }

    public AuthenticationPage clickContinueButton() {
        driver.findElement(continueButton).click();
        return new AuthenticationPage(driver);
    }
}
