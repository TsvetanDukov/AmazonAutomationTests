package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions action;
    private final By pageHeader = By.xpath("//h1[normalize-space() = 'Sign-In']");
    private final By emailField = By.id("ap_email");
    private final By continueButton = By.id("continue");
    private final By createAccount = By.id("createAccountSubmit");
    private final By needHelpLink = By.xpath("//span[@class = 'a-expander-prompt']");
    private final By forgotPasswordLink = By.id("auth-fpp-link-bottom");
    private final By otherIssuesLink = By.id("ap-other-signin-issues-link");
    private final By helpLink = By.xpath("//a[normalize-space() ='Help']");
    private final By emptyFieldErrorMessage = By.xpath("//div[contains(text(),'Enter your email or mobile phone number')]");
    private final By incorrectPhoneNumberError = By.xpath("//h4[contains(text(), 'Incorrect phone number')]");


    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.action = new Actions(driver);
    }

    public String verifyPageHeader() {
        return driver.findElement(pageHeader).getText();
    }

    public boolean isEmailFieldDisplayed() {
        return driver.findElement(emailField).isDisplayed();
    }

    public boolean isContinueButtonDisplayed() {
        return driver.findElement(continueButton).isDisplayed();
    }

    public boolean isCreateAccountButtonDisplayed() {
        return driver.findElement(createAccount).isDisplayed();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isNeedHelpLinkDisplayed() {
        return driver.findElement(needHelpLink).isDisplayed();
    }

    public void expandNeedHelpLink() {
        driver.findElement(needHelpLink).click();
    }

    public boolean isForgotPasswordLinkDisplayed(){
        return driver.findElement(forgotPasswordLink).isDisplayed();
    }

    public boolean isOtherIssuesLinkDisplayed() {
        return driver.findElement(otherIssuesLink).isDisplayed();
    }

    public boolean isHelpLinkDisplayed() {
        return driver.findElement(helpLink).isDisplayed();
    }

    public CustomerServicePage clickHelpLink() {
        driver.findElement(helpLink).click();
        return new CustomerServicePage(driver);
    }

    public void setEmailField(String input) {
        driver.findElement(emailField).sendKeys(input);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public String verifyEmptyFieldErrorMessage () {
        return driver.findElement(emptyFieldErrorMessage).getText();
    }

    public String verifyIncorrectPhoneNumberMessage() {
        return driver.findElement(incorrectPhoneNumberError).getText();
    }

    public RegistrationPage clickCreateAccountButton() {
        driver.findElement(createAccount).click();
        return new RegistrationPage(driver);
    }
}
