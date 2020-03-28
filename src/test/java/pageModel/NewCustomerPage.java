package pageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewCustomerPage extends pageBase {
    public NewCustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (name = "name")
    WebElement customerName;

    @FindBy (xpath = "//input[@value='m']")
    WebElement male;

    @FindBy (xpath = "//input[@type='date']")
    WebElement date;

    @FindBy (xpath = "//input[@value='f']")
    WebElement female;

    @FindBy (name = "addr")
    WebElement address;

    @FindBy (name = "city")
    WebElement city;

    @FindBy (name = "state")
    WebElement state;

    @FindBy (name = "pinno")
    WebElement pinNumber;

    @FindBy (name = "telephoneno")
    WebElement phoneNumber;

    @FindBy (name = "emailid")
    WebElement email;

    @FindBy (name = "password")
    WebElement password;

    @FindBy (xpath = "//input[@type='submit']")
    WebElement submitBTN;

    @FindBy (xpath = "//input[@type='reset']")
    WebElement resetBTN;

    public void addNewCustomer(String name, String gender,String birth, String address, String city, String state, String pinNum, String mobileNum, String email, String pass){

        customerName.sendKeys(name);
        if(gender == "male"){
            male.click();
        }
        else{
            female.click();
        }
        date.sendKeys(birth);
        this.address.sendKeys(address);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        pinNumber.sendKeys(pinNum);
        phoneNumber.sendKeys(mobileNum);
        this.email.sendKeys(email);
        password.sendKeys(pass);
        submitBTN.click();
    }

}
