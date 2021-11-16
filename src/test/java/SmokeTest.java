import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class SmokeTest {
    private static final WebDriver driver = new ChromeDriver();

    //initializing Page Objects
    public static HomePage homePage = new HomePage(driver);
    public static CatalogPage catalog = new CatalogPage(driver);
    public static ItemPage item = new ItemPage(driver);
    public static SummaryPage summary = new SummaryPage(driver);
    public static SignInPage sign = new SignInPage(driver);
    public static AddressPage address = new AddressPage(driver);
    public static ShippingPage shipping = new ShippingPage(driver);
    public static PaymentPage payment = new PaymentPage(driver);
    public static OrdersPage order = new OrdersPage(driver);
    //initializing SELENIUM Actions
    public static Actions actions = new Actions(driver);

    @BeforeSuite
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @BeforeMethod
    public void setUp(){
        driver.manage().window().maximize();
        driver.get(Utils.HOME_URL);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    @Test(testName = "New user checkout flow",invocationCount = 20)
    public static void endToEnd() throws InterruptedException {
//Instantiate OrderDetails Data Class
        OrderDetails details = new OrderDetails();
//Homepage
        Assert.assertTrue(homePage.getPageLogo(),StringResources.pageDidntLoad("Home Page"));
        homePage.pressNavButton();
//Catalog page
        Assert.assertTrue(catalog.getWomenLogo(),StringResources.pageDidntLoad("Catalog Page"));
        actions.moveToElement(catalog.imgItemMouseover).perform();
        catalog.clickItemMore();
//Item inspect page
        Assert.assertTrue(item.getItemImg(),StringResources.pageDidntLoad("Item Page image"));
        item.enterQuantity();
        item.colorSelect();
        item.selectSizeRand();
        item.imgClick();
        //Asserting if the different item images are the same one
        Assert.assertFalse(item.imgEqualityTest(),StringResources.imgError);
        //end of assertion
        item.imgCloseClick();
        details.setQuantity(item.getQuantity());
        details.setSize(item.getSize());
        details.setUnitPrice(item.getPrice());
        item.addItemToCart();
        Thread.sleep(5000);
        //Asserting popUp window item information
        Assert.assertEquals(item.getPopUpFullPrice(), details.getFullPrice(), StringResources.itemInspectError("Full price"));
        Assert.assertEquals(item.getPopUpQuantity(), details.getQuantity(), StringResources.itemInspectError("Quantity"));
        Assert.assertEquals(item.getPopUpShippingPrice(), details.getShippingPrice(), StringResources.itemInspectError("Shipping price"));
        Assert.assertTrue(item.getPopUpItemDetails().contains(details.getColor()), StringResources.itemInspectError("Color"));
        Assert.assertTrue(item.getPopUpItemDetails().contains(details.getSize()), StringResources.itemInspectError("Size"));
        //end of assertion
        item.proceedCheckout();
//Summary page
        Assert.assertTrue(summary.isPageLoaded(),StringResources.pageDidntLoad("Summary Page"));
        Assert.assertTrue(summary.isItemInStock(),StringResources.itemStockError);
        summary.addItem();
        //Asserting if the price responds correctly to the add and subtract buttons
        Thread.sleep(5000);
        Assert.assertEquals(summary.getTotalPrice(),details.fullPricePlusOne(),StringResources.priceMatchAdditionError);
        summary.subtractFromItem();
        Thread.sleep(5000);
        Assert.assertEquals(summary.getTotalPrice(),details.getFullPrice(),StringResources.priceMatchSubtractionError);
        //end of assertion
        summary.proceedCheckout();
//Sign in page
        Assert.assertTrue(sign.isCreationPageLoaded(),StringResources.pageDidntLoad("Account Creation Page"));
        sign.enterEmail();
        sign.createAnAccount();
        Thread.sleep(1000);
        Assert.assertTrue(sign.isFormDisplayed(),StringResources.pageDidntLoad("Sing in form"));
        sign.selectTitle();
        sign.enterName();
        sign.enterSurname();
        sign.inputPassword();
        sign.setDate();
        sign.checkNewsletter();
        sign.enterCompany();
        sign.enterAddress();
        sign.enterCity();
        sign.setState();
        sign.enterZipCode();
        sign.enterCountry();
        sign.enterPhoneNumber();
        details.setPhone(sign.getPhoneNumber());
        sign.registerUser();
//Address page
        Assert.assertTrue(address.isPageLoaded(),StringResources.pageDidntLoad("Address Page"));
        address.enterComment();
        address.proceedCheckout();
//Shipping page
        Assert.assertTrue(shipping.isPageLoaded(),StringResources.pageDidntLoad("Shipping Page"));
        shipping.acceptTermsOfService();
        shipping.openTermsOfService();
        Thread.sleep(5000);
        //Asserting if the terms of service window opens correctly.
        Assert.assertTrue(shipping.checkTermsOfService(),StringResources.tosError);
        shipping.closeTermsOfService();
        shipping.proceedCheckout();
//PaymentPage
        Assert.assertTrue(payment.isPageLoaded(),StringResources.pageDidntLoad("Payment Page"));
        payment.selectPayment();
        Assert.assertTrue(payment.isOrderInfoDisplayed(),StringResources.pageDidntLoad("Order Info"));
        payment.confirmOrder();
        Assert.assertTrue(payment.isOrderComplete(),StringResources.pageDidntLoad("Order complete info"));
        payment.toOrders();
//Orders page
        Assert.assertTrue(order.isPageLoaded(),StringResources.pageDidntLoad("Orders Page"));
        order.openOrderDetails();
        Thread.sleep(2000);
        //Asserting important order details information
        Assert.assertEquals(order.getFirstName(), details.getFirstName(), StringResources.orderDetailsError("First Name"));
        Assert.assertEquals(order.getLastName(), details.getLastName(), StringResources.orderDetailsError("Last Name"));
        Assert.assertEquals(order.getCompanyName(), details.getCompany(), StringResources.orderDetailsError("Company"));
        Assert.assertEquals(order.getAddressName(), details.getAddress(), StringResources.orderDetailsError("Address"));
        Assert.assertEquals(order.getCityName(), details.getCity(), StringResources.orderDetailsError("City"));
        Assert.assertEquals(order.getStateName(), details.getState(), StringResources.orderDetailsError("State"));
        Assert.assertEquals(order.getZipCode(), details.getZipCode(), StringResources.orderDetailsError("Zip Code"));
        Assert.assertEquals(order.getCountryName(), details.getCountry(), StringResources.orderDetailsError("Country"));
        Assert.assertEquals(order.getShippingPrice(), details.getShippingPrice(), StringResources.orderDetailsError("Shipping price"));
        Assert.assertEquals(order.getComment(), details.getComment(), StringResources.orderDetailsError("Comment"));
        Assert.assertEquals(order.getPhoneNumber(), details.getPhone(), StringResources.orderDetailsError("Phone number"));
        Assert.assertEquals(order.getUnitPrice(), details.getUnitPrice(), StringResources.orderDetailsError("Unit Price"));
        Assert.assertEquals(order.getQuantity(), details.getQuantity(), StringResources.orderDetailsError("Quantity"));
        Assert.assertEquals(order.getFullPrice(), details.getFullPrice(), StringResources.orderDetailsError("Full price"));
        Assert.assertTrue(order.getProductDetails().contains(details.getColor()), StringResources.orderDetailsError("Color"));
        Assert.assertTrue(order.getProductDetails().contains(details.getSize()), StringResources.orderDetailsError("Size"));
        //end of details assertion
        homePage.signOutUser();
        Assert.assertTrue(homePage.isUserLoggedOut(),StringResources.pageDidntLoad("Sign out button"));
    }

    @AfterSuite
    public static void exit(){
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
