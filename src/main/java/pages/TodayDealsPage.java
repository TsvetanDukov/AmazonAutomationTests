package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TodayDealsPage {

    private final WebDriver driver;
    private final By sortByDropdown = By.xpath("//select[@name = 'sortOptions']");
    private final By pageHeader = By.cssSelector("div.fst-h1-st.pageBanner h1");


    public TodayDealsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isSortByDisplayed() {
        return driver.findElement(sortByDropdown).isDisplayed();
    }

    public void selectSortByOrder(String text) {
        WebElement dropdownMenu = driver.findElement(sortByDropdown);
        Select select = new Select(dropdownMenu);
        select.selectByVisibleText(text);
    }

    public String getPageHeader() {
        return driver.findElement(pageHeader).getText();
    }
}
