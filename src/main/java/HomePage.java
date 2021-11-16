import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject{

    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a")
    private WebElement woman;

    @FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(2) > a")
    private WebElement signOut;

    @FindBy(css = "#header_logo > a > img")
    private WebElement pageLogo;

    @FindBy(className = "login")
    private WebElement signIn;

    public HomePage(WebDriver driver){super(driver);}

    public void pressNavButton(){this.woman.click();}

    public boolean getPageLogo(){return this.pageLogo.isDisplayed();}

    public boolean isUserLoggedOut(){return this.signIn.isDisplayed();}

    public void signOutUser(){this.signOut.click();}
}