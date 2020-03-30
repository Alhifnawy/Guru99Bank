package pageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditCustomerPage extends pageBase {
    public EditCustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "cusid")
    WebElement customerID;

    @FindBy(name = "AccSubmit")
    WebElement submit;

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

    @FindBy (xpath = "//input[@type='submit']")
    WebElement submitBTN;

    public void enterCustomerID(String ID){
        customerID.sendKeys(ID);
        submit.click();
    }

    public void editCustomerDetails(String address, String city, String state, String pinNum, String mobileNum, String email){
        this.address.clear();
        this.city.clear();
        this.state.clear();
        pinNumber.clear();
        phoneNumber.clear();
        this.email.clear();

        this.address.sendKeys(address);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        pinNumber.sendKeys(pinNum);
        phoneNumber.sendKeys(mobileNum);
        this.email.sendKeys(email);
        submitBTN.click();
    }
}
