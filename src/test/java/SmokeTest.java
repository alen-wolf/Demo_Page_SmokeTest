import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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
        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        OrderDetails details = new OrderDetails();
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
        details.setQuantity(item.getQuantity());
        details.setSize(item.getSize());
        details.setUnitPrice(item.getPrice());
        item.addItemToCart();
        item.proceedCheckout();
//Summary page
        SummaryPage summary = new SummaryPage(driver);
        Thread.sleep(5000);
        summary.addItem();
        Thread.sleep(5000);
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
        details.setPhone(sign.getPhoneNumber());
        sign.registerUser();
//Address page
        AddressPage address = new AddressPage(driver);
        address.enterComment();
        address.proceedCheckout();
//Shipping page
        ShippingPage shipping = new ShippingPage(driver);
        shipping.acceptTermsOfService();
        shipping.openTermsOfService();
        Thread.sleep(10000);
        shipping.closeTermsOfService();
        shipping.proceedCheckout();
//PaymentPage
        PaymentPage payment = new PaymentPage(driver);
        payment.selectPayment();
        payment.confirmOrder();
        payment.toOrders();
//Orders page
        OrdersPage order = new OrdersPage(driver);
        order.openOrderDetails();
        Thread.sleep(2000);
        Assert.assertEquals(order.getFirstName(), details.getFirstName(),"Error Order Details First Name is incorrect");
        Assert.assertEquals(order.getLastName(), details.getLastName(),"Error Order Details Last Name is incorrect");
        Assert.assertEquals(order.getCompanyName(), details.getCompany(),"Error Order Details Company Name is incorrect");
        Assert.assertEquals(order.getAddressName(), details.getAddress(),"Error Order Details Address Name is incorrect");
        Assert.assertEquals(order.getCityName(), details.getCity(),"Error Order Details City Name is incorrect");
        Assert.assertEquals(order.getStateName(), details.getState(),"Error Order Details State Name is incorrect");
        Assert.assertEquals(order.getZipCode(), details.getZipCode(),"Error Order Details Zip Code is incorrect");
        Assert.assertEquals(order.getCountryName(), details.getCountry(),"Error Order Details Country Name is incorrect");
        Assert.assertEquals(order.getShippingPrice(), details.getShippingPrice(),"Error Order Details Shipping Price is incorrect");
        Assert.assertEquals(order.getComment(), details.getComment(),"Error Order Details Comment is incorrect");
        Assert.assertEquals(order.getPhoneNumber(), details.getPhone(),"Error Order Details Phone Number is incorrect");
        Assert.assertEquals(order.getUnitPrice(), details.getUnitPrice(),"Error Order Details Unit Price is incorrect");
        Assert.assertEquals(order.getQuantity(), details.getQuantity(),"Error Order Details Quantity is incorrect");
        Assert.assertEquals(order.getFullPrice(), details.getFullPrice(),"Error Order Details Full Price is incorrect");
        Assert.assertTrue(order.getProductDetails().contains(details.getColor()),"Error Order Details Color is incorrect");
        Assert.assertTrue(order.getProductDetails().contains(details.getSize()),"Error Order Details Size is incorrect");
    }

    @AfterSuite
    public static void exit(){
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
