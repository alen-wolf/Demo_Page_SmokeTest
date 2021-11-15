import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class ItemPage extends PageObject {

    @FindBy(id = "quantity_wanted")
    private WebElement quantity;

    @FindBy(id = "group_1")
    private WebElement size;

    @FindBy(id = "color_14")
    private WebElement color;

    @FindBy(id = "bigpic")
    private WebElement img;

    @FindBy(xpath = "//*[@id=\"product\"]/div[3]")
    private WebElement imgClose;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span")
    private WebElement addCart;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    private WebElement checkout;

    @FindBy(id = "our_price_display")
    private WebElement price;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    private int smallRandInt(){
        Random rand = new Random();
        return rand.nextInt(3);
    }

    public void imgClick(){this.img.click();}

    public void imgCloseClick(){this.imgClose.click();}

    public void addItemToCart(){this.addCart.click();}

    public void colorSelect(){this.color.click();}

    public void enterQuantity(){
        String rand = String.valueOf(smallRandInt()+1);
        this.quantity.clear();
        this.quantity.sendKeys(rand);
    }

    public void selectSizeRand(){
        Select select = new Select(size);
        select.selectByIndex(smallRandInt());
    }

    public void proceedCheckout(){this.checkout.click();}

    public String getQuantity(){return this.quantity.getAttribute("value");}

    public String getSize(){
        Select select = new Select(size);
        return select.getFirstSelectedOption().getText();
    }

    public String getPrice(){return this.price.getText();}

}
