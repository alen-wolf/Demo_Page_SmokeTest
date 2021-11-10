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
    public static void endToEnd() {
        driver.manage().window().maximize();
        driver.get(Utils.HOME_URL);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        HomePage homePage = new HomePage(driver);
        homePage.pressNavButton();

        CatalogPage catalog = new CatalogPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(catalog.imgItem).perform();
        catalog.clickItem();

        ItemPage item = new ItemPage(driver);
        item.enterQuantity();
        item.colorSelect();
        item.selectSizeRand();
        item.imgClick();
        item.imgCloseClick();
        item.addItemToCart();
        item.proceedCheckout();


    }

    @AfterSuite
    public static void exit(){
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
