package pageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends pageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='uid']")
    WebElement userID;

    @FindBy(xpath = "//input[@name='password']")
    WebElement Pass;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement Submit;

    public void SubmitLoginCredentials(String user, String Password){
        userID.sendKeys(user);
        Pass.sendKeys(Password);
        Submit.click();
    }
}
