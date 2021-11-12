import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends PageObject{

    @FindBy(xpath = "//*[@id=\"ordermsg\"]/textarea")
    private WebElement comment;

    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span")
    private WebElement checkout;

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public void enterComment(){this.comment.sendKeys("This is a test.");}

    public void proceedCheckout(){this.checkout.click();}

}
