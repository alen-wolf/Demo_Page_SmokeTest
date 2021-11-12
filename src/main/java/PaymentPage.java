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

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void selectPayment(){this.payBankWire.click();}

    public void confirmOrder(){this.confirmOrder.click();}

    public void toOrders(){this.backToOrders.click();}

}
