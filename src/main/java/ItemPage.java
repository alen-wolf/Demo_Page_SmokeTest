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

    @FindBy(xpath = "//*[@id=\"product\"]/div[2]/div/div[1]/a[2]")
    private WebElement nextImg;

    @FindBy(className = "fancybox-image" )
    private WebElement largeImg;

    @FindBy(css = "#product > div.fancybox-overlay.fancybox-overlay-fixed > div > div > a")
    private WebElement imgClose;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span")
    private WebElement addCart;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    private WebElement checkout;

    @FindBy(id = "our_price_display")
    private WebElement price;

    @FindBy(id = "layer_cart_product_quantity")
    private WebElement popUpQuantity;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[3]/span")
    private WebElement popUpFullPrice;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[2]/span")
    private WebElement popUpShippingPrice;

    @FindBy(id = "layer_cart_product_attributes")
    private WebElement popUpItemDetails;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    private int smallRandInt(){
        Random rand = new Random();
        return rand.nextInt(3);
    }

    public void imgClick(){this.img.click();}

    public boolean getItemImg(){return this.img.isDisplayed();}

    public Boolean imgEqualityTest () throws InterruptedException {
        String currentImg = this.largeImg.getAttribute("src");
        this.nextImg.click();
        Thread.sleep(2000);
        return currentImg.equals(this.largeImg.getAttribute("src"));
    }

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

    public String getPopUpFullPrice(){return this.popUpFullPrice.getText();}

    public String getPopUpQuantity(){return this.popUpQuantity.getText();}

    public String getPopUpShippingPrice(){return this.popUpShippingPrice.getText();}

    public String getPopUpItemDetails(){return this.popUpItemDetails.getText();}

}
