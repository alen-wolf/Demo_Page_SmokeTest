import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject{

    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a")
    private WebElement woman;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void pressNavButton(){this.woman.click();}
}