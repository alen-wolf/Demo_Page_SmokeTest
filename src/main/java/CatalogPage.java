import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends PageObject{

    @FindBy(xpath= "/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[2]/span")
    private WebElement storeItem;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img")
    public WebElement imgItem;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }


    public void clickItem(){this.storeItem.click();}

}
