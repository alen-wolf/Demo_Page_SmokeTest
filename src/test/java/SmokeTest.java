import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmokeTest {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "End to end")
    public static void endToEnd() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(Utils.HOME_URL);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//Homepage
        HomePage homePage = new HomePage(driver);
        homePage.pressNavButton();
//Catalog page
        CatalogPage catalog = new CatalogPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(catalog.imgItem).perform();
        catalog.clickItem();
//Item inspect page
        ItemPage item = new ItemPage(driver);
        item.enterQuantity();
        item.colorSelect();
        item.selectSizeRand();
        item.imgClick();
        item.imgCloseClick();
        item.addItemToCart();
        item.proceedCheckout();
//Summary page
        SummaryPage summary = new SummaryPage(driver);
        summary.addItem();
        Thread.sleep(1000);
        summary.subtractFromItem();
        summary.proceedCheckout();
//Sign in page
        SignInPage sign = new SignInPage(driver);
        sign.enterEmail();
        sign.createAnAccount();
        sign.selectTitle();
        sign.enterName();
        sign.enterSurname();
        sign.inputPassword();
        sign.setDate();
        sign.checkNewsletter();
        sign.enterCompany();
        sign.enterAdress();
        sign.enterCity();
        sign.setState();
        sign.enterZipCode();
        sign.enterCountry();
        sign.enterPhoneNumber();
        sign.registerUser();

    }

    @AfterSuite
    public static void exit(){
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
