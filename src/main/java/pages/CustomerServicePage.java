package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CustomerServicePage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By pageHeader = By.xpath("//h1[contains(text(), 'What can we')]");
    private final By yourOrders = By.xpath("//h3[normalize-space()='Your Orders']");
    private final By returnsAndRefunds = By.xpath("//h3[normalize-space()='Returns & Refunds']/parent::div");
    private final By searchField = By.id("helpsearch");
    private final By searchResultsField = By.xpath("//p[contains(text(), 'search results for' )]");
    private final By nextPageResultsButton = By.xpath("//li[@class='a-last']//a[1]");
    private final By previousResultButton = By.xpath("//ul[@class = 'a-pagination']/li[1]");

    public CustomerServicePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    public String verifyPageTitle() {
        return driver.getTitle();
    }

    public String verifyPageHeader() {
        return driver.findElement(pageHeader).getText();
    }

    public boolean isYourOrdersLinkDisplayed() {
        return driver.findElement(yourOrders).isDisplayed();
    }

    public SignInPage clickYourOrdersLinkWithoutRegistration() {
        driver.findElement(yourOrders).click();
        return new SignInPage(driver);
    }

    public boolean isReturnAndRefundsLinkDisplayed() {
        return driver.findElement(returnsAndRefunds).isDisplayed();
    }

    public SignInPage clickReturnAndRefundsWithoutRegistration() {
        driver.findElement(returnsAndRefunds).click();
        return new SignInPage(driver);
    }
    public boolean isSearchFieldDisplayed() {
        return driver.findElement(searchField).isDisplayed();
    }
    public void enterTextInSearchField(String text) {
        driver.findElement(searchField).sendKeys(text);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
    }

    public String searchResults() {
        return driver.findElement(searchResultsField).getText();
    }

    public boolean isNextResultPageButtonDisplayed() {
        return driver.findElement(nextPageResultsButton).isDisplayed();
    }

    public void clickNextResultPageButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextPageResultsButton)).click();
    }

    public boolean isPreviousResultButtonDisplayed() {
        return driver.findElement(previousResultButton).isDisplayed();
    }

    public void clickPreviousResultButton() {
        driver.findElement(previousResultButton).click();
    }

}
