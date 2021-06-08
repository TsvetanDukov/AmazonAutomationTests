package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TodayDealsPage {

    private final WebDriver driver;
    JavascriptExecutor executor;
    private final By sortByDropdown = By.xpath("//select[@name = 'sortOptions']");
    private final By pageHeader = By.cssSelector("div.fst-h1-st.pageBanner h1");
    private final By expandDepartmentMenu = By.cssSelector("span.a-expander-prompt");


    public TodayDealsPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
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

    public boolean isExtendDepartmentLinkDisplayed() {
        return driver.findElement(expandDepartmentMenu).isDisplayed();
    }

    public void clickExtendDepartmentLink() {
        driver.findElement(expandDepartmentMenu).click();
    }

    public String departmentLinkIsExtended() {
        return driver.findElement(expandDepartmentMenu).getText();
    }

    public String departmentLinkIsFolded() {
        return driver.findElement(expandDepartmentMenu).getText();
    }
}

