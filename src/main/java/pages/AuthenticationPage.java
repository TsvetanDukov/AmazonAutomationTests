package pages;

import org.openqa.selenium.WebDriver;

public class AuthenticationPage {

    private final WebDriver driver;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
