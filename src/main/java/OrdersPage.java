import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrdersPage extends PageObject{

    @FindBy(xpath = "//*[@id=\"order-list\"]/tbody/tr/td[7]/a[1]/span")
    private WebElement details;

    @FindBy(className = "address_firstname")
    private WebElement FirstName;

    @FindBy(className = "address_lastname")
    private WebElement LastName;

    @FindBy(className = "address_company")
    private WebElement company;

    @FindBy(className = "address_address1")
    private WebElement address;

    @FindBy(className = "address_city")
    private WebElement city;

    @FindBy(xpath = "//*[@id=\"block-order-detail\"]/div[4]/div/div[1]/ul/li[5]/span[2]")
    private WebElement state;

    @FindBy(className = "address_postcode")
    private WebElement zipCode;

    @FindBy(xpath = "//*[@id=\"block-order-detail\"]/div[4]/div/div[1]/ul/li[6]/span")
    private WebElement country;

    @FindBy(className = "address_phone_mobile")
    private WebElement phoneNumber;

    @FindBy(xpath = "//*[@id=\"order-detail-content\"]/table/tbody/tr/td[2]/label")
    private WebElement product;

    @FindBy(xpath = "//*[@id=\"order-detail-content\"]/table/tbody/tr/td[4]/label")
    private WebElement unitPrice;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div/form[1]/div/table/tbody/tr/td[3]/label/span")
    private WebElement quantity;

    @FindBy(xpath = "//*[@id=\"order-detail-content\"]/table/tfoot/tr[4]/td[2]/span")
    private WebElement fullPrice;

    @FindBy(xpath = "//*[@id=\"block-order-detail\"]/table/tbody/tr/td[4]")
    private WebElement shippingPrice;

    @FindBy(xpath = "//*[@id=\"block-order-detail\"]/div[5]/table/tbody/tr/td[2]")
    private WebElement comment;

    public OrdersPage(WebDriver driver) {
        super(driver);
    }

    public void openOrderDetails(){this.details.click();}

    public String  getFirstName(){return this.FirstName.getText();}

    public String  getLastName(){return this.LastName.getText();}

    public String getCompanyName(){return  this.company.getText();}

    public String getAddressName(){return this.address.getText();}

    public String getCityName(){return this.city.getText();}

    public String getStateName(){return this.state.getText();}

    public String getZipCode(){return this.zipCode.getText();}

    public String getCountryName(){return this.country.getText();}

    public String getPhoneNumber(){return this.phoneNumber.getText();}

    public String getProductDetails(){return this.product.getText();}

    public String getUnitPrice(){return this.unitPrice.getText();}

    public String getQuantity(){return this.quantity.getText();}

    public String getFullPrice(){return this.fullPrice.getText();}

    public String getShippingPrice(){return this.shippingPrice.getText();}

    public String getComment(){return this.comment.getText();}
}
