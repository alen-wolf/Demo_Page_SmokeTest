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

    @FindBy(css = "#total_price")
    private WebElement totalPrice;

    @FindBy(className = "label")
    private WebElement inStock;

    public SummaryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isItemInStock(){
        return this.inStock.getText().equals("In stock");
    }

    public boolean isPageLoaded(){return this.plusIcon.isDisplayed();}

    public void addItem(){this.plusIcon.click();}

    public void subtractFromItem(){this.minusIcon.click();}

    public String getTotalPrice(){return this.totalPrice.getText();}

    public void proceedCheckout(){this.checkout.click();}
}
