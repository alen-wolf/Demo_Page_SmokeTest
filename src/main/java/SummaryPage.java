import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SummaryPage extends PageObject{

    @FindBy(className = "icon-plus")
    private WebElement plusIcon;

    @FindBy(className = "icon-minus")
    private WebElement minusIcon;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
    private WebElement checkout;

    public SummaryPage(WebDriver driver) {
        super(driver);
    }

    public void addItem(){this.plusIcon.click();}

    public void subtractFromItem(){this.minusIcon.click();}

    public void proceedCheckout(){this.checkout.click();}

}
