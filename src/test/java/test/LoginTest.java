package test;

import data.ExcelReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageModel.HomePage;
import pageModel.LoginPage;
import java.io.IOException;

public class LoginTest extends TestBase{

    LoginPage logPage;
    HomePage HP;

    @DataProvider(name = "LoginData")
    public Object[][] userLoginData() throws IOException {

        //Get data from ExcelReader Class
        ExcelReader ER = new ExcelReader();

        return ER.getExcelData();
    }

    @Test(dataProvider = "LoginData")
    public void verifySuccessfulLogin(String username, String Password){

        logPage = new LoginPage(driver);
        HP = new HomePage(driver);

        logPage.SubmitLoginCredentials(username, Password);

        try {
            Alert alt = driver.switchTo().alert();
            Assert.assertEquals(alt.getText().toLowerCase(),"user or password is not valid");
            driver.switchTo().alert().accept();

        } catch (NoAlertPresentException var8) {
            Assert.assertTrue(driver.findElement(By.xpath("//td[@style='color: green']")).getText().contains("Manger Id : mng"));
            Assert.assertEquals(driver.findElement(By.xpath("//td[@style='color: green']")).getText(),"Manger Id : mngr251101");
            HP.Logout();
        }
    }
}
