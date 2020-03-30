package pageModel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteCustomerPage extends pageBase {
    public DeleteCustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "cusid")
    WebElement customerID;

    @FindBy (xpath = "//input[@type='submit']")
    WebElement submit;

    public void deleteCustomer(String ID){
        customerID.sendKeys(ID);
        submit.click();
    }

}
