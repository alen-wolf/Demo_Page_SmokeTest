import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends PageObject{

    @FindBy(className = "bankwire")
    private WebElement payBankWire;

    @FindBy(css = "#cart_navigation > button > span")
    private WebElement confirmOrder;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p/a")
    private WebElement backToOrders;

    @FindBy(css = "#center_column > form > div")
    private WebElement orderInfo;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded(){return this.payBankWire.isDisplayed();}

    public boolean isOrderInfoDisplayed(){return this.orderInfo.isDisplayed();}

    public boolean isOrderComplete(){return this.backToOrders.isDisplayed();}

    public void selectPayment(){this.payBankWire.click();}

    public void confirmOrder(){this.confirmOrder.click();}

    public void toOrders(){this.backToOrders.click();}
}
