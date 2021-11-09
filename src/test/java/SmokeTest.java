import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class SmokeTest {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "End to end")
    public static void endToEnd(){
        driver.manage().window().maximize();
        driver.get(Utils.HOME_URL);
        HomePage homePage = new HomePage(driver);
        CatalogPage catalog = new CatalogPage(driver);
        Actions actions = new Actions(driver);
        homePage.pressNavButton();
        actions.moveToElement(catalog.imgItem).perform();
        catalog.clickItem();

    }

    @AfterSuite
    public static void exit(){
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
