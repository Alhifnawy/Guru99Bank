package pageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends pageBase{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='addcustomerpage.php']")
    WebElement newCustomerBTN;

    @FindBy(xpath = "//a[@href='EditCustomer.php']")
    WebElement editCustomerBTN;

    @FindBy(xpath = "//a[@href='DeleteCustomerInput.php']")
    WebElement deleteCustomerBTN;

    @FindBy(xpath = "//a[@href='Logout.php']")
    WebElement logoutBTN;

    public void Logout(){
        logoutBTN.click();
    }

    public void addNewCustomerBTN(){
        newCustomerBTN.click();
    }

    public void editCustomerBTN(){
        editCustomerBTN.click();
    }

    public void deleteCustomerBTN(){
        deleteCustomerBTN.click();
    }
}
