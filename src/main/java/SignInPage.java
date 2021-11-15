import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.yaml.snakeyaml.events.Event;

import java.util.Random;

public class SignInPage extends PageObject{

    @FindBy(id = "email_create")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]/span")
    private WebElement createAccount;

    @FindBy(id = "id_gender1")
    private WebElement title;

    @FindBy(id = "customer_firstname")
    private WebElement name;

    @FindBy(id = "customer_lastname")
    private WebElement surname;

    @FindBy(id = "passwd")
    private WebElement pass;

    @FindBy(id = "days")
    private WebElement dayDate;

    @FindBy(id = "months")
    private WebElement monthDate;

    @FindBy(id = "years")
    private WebElement yearDate;

    @FindBy(id = "newsletter")
    private WebElement newsletter;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "address1")
    private WebElement adress;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement zipCode;

    @FindBy(id = "id_country")
    private WebElement country;

    @FindBy(id = "phone_mobile")
    private WebElement mobilephone;

    @FindBy(xpath = "//*[@id=\"submitAccount\"]/span")
    private WebElement register;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    private String randomEmail(){
        Random rand = new Random();
        int length = rand.nextInt(11-5)+5;
        String CHARSEQ = "abcdefghijklmnopqrstuvwxyz-._1234567890";
        StringBuilder name = new StringBuilder();

        for(int i=0; i<length; i++){
            Character r = CHARSEQ.charAt(rand.nextInt(39));
            if(i==0 || i==length-1){
                while(r == '-' || r == '.' || r == '_'){
                    r = CHARSEQ.charAt(rand.nextInt(39));
                }
            }
            name.append(r);
        }
        return name.toString();
    }

    public void enterEmail(){
        this.emailInput.sendKeys(randomEmail()+"@email.com");
    }

    public void createAnAccount(){this.createAccount.click();}

    public void selectTitle(){this.title.click();}

    public void enterName(){this.name.sendKeys("Allen");}

    public void enterSurname(){this.surname.sendKeys("Wollf");}

    public void inputPassword(){this.pass.sendKeys(randomEmail());}

    public void setDate(){
        Random rand = new Random();
        Select selectDay = new Select(this.dayDate);
        Select selectMonth = new Select(this.monthDate);
        Select selectYear = new Select(this.yearDate);

        selectDay.selectByIndex(rand.nextInt(31-1)+1);
        selectMonth.selectByIndex(rand.nextInt(13-1)+1);
        selectYear.selectByIndex(rand.nextInt(122-10)+10);
    }

    public void checkNewsletter(){this.newsletter.click();}

    public void enterCompany(){this.company.sendKeys("AtlantBH");}

    public void enterAdress(){this.adress.sendKeys("Fifth Avenue");}

    public void enterCity(){this.city.sendKeys("New York");}

    public void setState(){
        Select selectState = new Select(this.state);
        selectState.selectByIndex(33);
    }

    public void enterZipCode(){this.zipCode.sendKeys("10001");}

    public void enterCountry(){
        Select selectCountry = new Select(this.country);
        selectCountry.selectByIndex(1);
    }

    public void enterPhoneNumber(){
        Random rand = new Random();
        int number = rand.nextInt(999999999-100000000)+100000000;
        this.mobilephone.sendKeys(String.valueOf(number));
    }

    public void registerUser(){this.register.click();}

    public String getPhoneNumber(){return this.mobilephone.getAttribute("value");}
}
