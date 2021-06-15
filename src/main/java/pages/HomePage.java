package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions action;
    private final By leftNavigationPanel = By.id("nav-hamburger-menu");
    private final By todayDeals = By.linkText("Today's Deals");
    private final By customerService = By.linkText("Customer Service");
    private final By giftCards = By.xpath("//a[text() = 'Gift Cards']");
    private final By accountAndListMenu = By.id("nav-link-accountList");
    private final By sigInFromAccountDropdown = By.xpath("//span[text() = 'Sign in']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.action = new Actions(driver);
    }

    public void clickLeftNavigationPanel() {
        driver.findElement(leftNavigationPanel).click();
    }

    public TodayDealsPage clickTodayDealsLink() {
        driver.findElement(todayDeals).click();
        return new TodayDealsPage(driver);
    }

    public  boolean isTodayDealsLinkDisplayed() {
        return driver.findElement(todayDeals).isDisplayed();
    }

    public CustomerServicePage clickCustomerServiceLink() {
        driver.findElement(customerService).click();
        return new CustomerServicePage(driver);
    }

    public boolean isAccountAndListsLinkDisplayed() {
        return driver.findElement(accountAndListMenu).isDisplayed();
    }

    public void hoverOverAccountList() {
        action.moveToElement(driver.findElement(accountAndListMenu)).perform();
    }

    public SignInPage clickSignInThroughAccountsMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sigInFromAccountDropdown)).click();
        return new SignInPage(driver);
    }

    public boolean isGiftCardsLinkDisplayed() {
        return driver.findElement(giftCards).isDisplayed();
    }
    public GiftCardsPage clickGiftCardsLink() {
        driver.findElement(giftCards).click();
        return new GiftCardsPage(driver);
    }
}
