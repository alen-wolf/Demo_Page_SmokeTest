import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    protected WebDriver driver;

    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a")
    private WebElement woman;

    public PageObject(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void pressNavButton(){this.woman.click();}
}
