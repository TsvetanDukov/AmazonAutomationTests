package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class GiftCardsPage {

    private final WebDriver driver;
    private final By pageHeader = By.xpath("//h1[text() = 'Gift Cards']");
    private final By eventsAndCelebrationSection = By.xpath("//button[normalize-space() = 'Events & Celebrations']");
    private final By eventsLinks = By.cssSelector
            ("div[class='acs-ln-nav-section acs-ln-nav-expanded'] div[class='acs-ln-links'] li a");
    private final By specialFeaturesSection = By.xpath("//button[normalize-space() = 'Amazon Gift Cards: Special Features']");
    private final By specialFeaturesLinks = By.cssSelector
            ("div[class='acs-ln-nav-section acs-ln-nav-expanded'] div[class='acs-ln-links'] li a");

    public GiftCardsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String verifyPageHeader() {
        return driver.findElement(pageHeader).getText();
    }

    public boolean isEventsAndCelebrationSectionDisplayed() {
        return driver.findElement(eventsAndCelebrationSection).isDisplayed();
    }

    public void expandEventsSection() {
        driver.findElement(eventsAndCelebrationSection).click();
    }

    public void openEventsSectionLinksInNewTab() {
        List<WebElement> links = driver.findElements(eventsLinks);
        for (WebElement link : links) {
            link.sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
        }
    }

    public void getLinksPageTitles() {
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            String titles = driver.switchTo().window(window).getTitle();
            if (titles.equalsIgnoreCase("Amazon.com Birthday Gift Cards")
                    || titles.equalsIgnoreCase("Amazon.com: Thank You and Appreciation Gift Cards: Gift Cards")
                    || titles.equalsIgnoreCase("Amazon.com: Holiday Gift Cards: Gift Cards")
                    || titles.equalsIgnoreCase("Amazon.com: Occasions: Gift Cards")
                    || titles.equalsIgnoreCase("Amazon.com: Congratulations - Occasions: Gift Cards")
                    || titles.equalsIgnoreCase("Amazon.com Gift Cards")) {
                System.out.println("Title is correct!");
            } else
                System.out.println("Incorrect title!");
        }
    }

    public void expandSpecialFeaturesSection() {
        driver.findElement(specialFeaturesSection).click();
    }

    public boolean isSpecialFeaturesSectionDisplayed() {
        return driver.findElement(specialFeaturesSection).isDisplayed();
    }

    public void openSpecialFeaturesLinksInNewTab() {
        List<WebElement> links = driver.findElements(specialFeaturesLinks);
        for (WebElement link : links) {
            link.sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
        }
    }
}
