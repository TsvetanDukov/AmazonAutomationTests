package pages;

import org.openqa.selenium.WebDriver;

public class AmazonBusinessPage {

    private final WebDriver driver;

    public AmazonBusinessPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
