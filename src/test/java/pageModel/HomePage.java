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

    @FindBy(xpath = "//a[@href='Logout.php']")
    WebElement logoutBTN;

    public void Logout(){
        logoutBTN.click();
    }

    public void addNewCustomer(){
        newCustomerBTN.click();
    }
}
