import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrdersPage extends PageObject{

    @FindBy(xpath = "//*[@id=\"order-list\"]/tbody/tr/td[7]/a[1]/span")
    private WebElement details;

    public OrdersPage(WebDriver driver) {
        super(driver);
    }

    public void openOrderDetails(){this.details.click();}

}
