import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends PageObject{

    @FindBy(id = "cgv")
    private WebElement checkTerms;

    @FindBy(xpath = "//*[@id=\"form\"]/div/p[2]/a")
    private WebElement inspectTerms;

    @FindBy(xpath = "/html/body/div[2]/div/div/a")
    private WebElement closeTerms;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
    private WebElement checkout;

    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    public void acceptTermsOfService(){this.checkTerms.click();}

    public void openTermsOfService(){this.inspectTerms.click();}

    public void closeTermsOfService(){this.closeTerms.click();}

    public void proceedCheckout(){this.checkout.click();}

}
