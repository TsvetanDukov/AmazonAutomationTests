package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By leftNavigationPanel = By.id("nav-hamburger-menu");
    private By todayDeals = By.linkText("Today's Deals");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLeftNavigationPanel() {
        driver.findElement(leftNavigationPanel).click();
    }

    public TodayDealsPage clickTodayDealsLink() {
        driver.findElement(todayDeals).click();
        return new TodayDealsPage(driver);
    }
}
