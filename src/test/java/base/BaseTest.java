package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.util.Iterator;
import java.util.Set;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        returnToHomePage();
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void returnToHomePage() {
        driver.get("https://www.amazon.com/");
    }

    @AfterClass
    public void tearDown() {

    }
}