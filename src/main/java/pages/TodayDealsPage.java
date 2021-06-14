package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TodayDealsPage {

    private final WebDriver driver;
    JavascriptExecutor executor;
    private final WebDriverWait wait;
    private final Actions action;
    private final By sortByDropdown = By.xpath("//select[@name = 'sortOptions']");
    private final By pageHeader = By.cssSelector("div.fst-h1-st.pageBanner h1");
    private final By expandDepartmentMenu = By.cssSelector("span.a-expander-prompt");
    private final By availabilityFilterHeader = By.xpath("//span[text() = 'Availability']");
    private final By availabilityActiveCheckbox = By.xpath("//span[contains(text(), 'Active')]/preceding-sibling::input");
    private final By availabilityUpcomingCheckbox = By.xpath("//span[contains(text(), 'Upcoming')]/preceding-sibling::input");
    private final By availabilityMissedCheckbox = By.xpath("//span[contains(text(), 'Missed')]/preceding-sibling::input");
    private final By availabilityClearButton = By.xpath("//a[text() = 'Clear']/parent::div");


    public TodayDealsPage(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        this.wait = new WebDriverWait(driver, 20);
        this.action = new Actions(driver);
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

    public String availabilityHeader() {
        return driver.findElement(availabilityFilterHeader).getText();
    }

    public boolean isActiveCheckboxDisplayed() {
        return driver.findElement(availabilityActiveCheckbox).isDisplayed();
    }
    public boolean isUpcomingCheckboxDisplayed() {
        return driver.findElement(availabilityUpcomingCheckbox).isDisplayed();
    }
    public boolean isMissedCheckboxDisplayed() {
        return driver.findElement(availabilityMissedCheckbox).isDisplayed();
    }

    public void clickActiveCheckbox() {
        driver.findElement(availabilityActiveCheckbox).click();
    }

    public void clickUpcomingCheckbox() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(availabilityUpcomingCheckbox)).click();
    }

    public void clickMissedCheckbox() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(availabilityMissedCheckbox)).click();
    }

    public boolean isActiveCheckboxUnselected() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(availabilityActiveCheckbox))
                .isSelected();
    }

    public boolean isUpcomingCheckboxUnselected() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(availabilityUpcomingCheckbox))
                .isSelected();
    }

    public boolean isMissedCheckboxUnselected() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(availabilityMissedCheckbox))
                .isSelected();
    }

    public boolean isClearButtonDisplayed() {
        return driver.findElement(availabilityClearButton).isDisplayed();
    }

    public void clickAvailabilityClearButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(availabilityClearButton)).click();
    }
}

