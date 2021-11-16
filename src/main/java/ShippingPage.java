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

    @FindBy(css = "#order > div.fancybox-overlay.fancybox-overlay-fixed > div > div")
    private WebElement termsOfService;

    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded(){return this.inspectTerms.isDisplayed();}

    public void acceptTermsOfService(){this.checkTerms.click();}

    public void openTermsOfService(){this.inspectTerms.click();}

    public boolean checkTermsOfService(){return this.termsOfService.isDisplayed();}

    public void closeTermsOfService(){this.closeTerms.click();}

    public void proceedCheckout(){this.checkout.click();}
}
