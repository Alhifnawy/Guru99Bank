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
import pageModel.NewCustomerPage;

import java.io.IOException;

public class Tests extends TestBase{

    @DataProvider(name = "LoginData")
    public Object[][] userLoginData() throws IOException {

        //Get data from ExcelReader Class
        ExcelReader ER = new ExcelReader();

        return ER.getExcelData();
    }

    @Test(priority = 1, dataProvider = "LoginData")
    public void verifyLogin(String username, String Password) throws IOException {

        logPage = new LoginPage(driver);
        HP = new HomePage(driver);

        logPage.SubmitLoginCredentials(username, Password);

        try {
            Alert alt = driver.switchTo().alert();
            Assert.assertEquals(alt.getText().toLowerCase(),"user or password is not valid");
            driver.switchTo().alert().accept();

        } catch (NoAlertPresentException var8) {
            Assert.assertTrue(driver.findElement(By.xpath("//td[@style='color: green']")).getText().contains("Manger Id : "+username));
            Assert.assertEquals(driver.findElement(By.xpath("//td[@style='color: green']")).getText(),"Manger Id : "+username);
            Util.takeScreenshot(driver,Util.ssPath);
            HP.Logout();
            driver.switchTo().alert().accept();
        }
    }

    @Test(priority = 2)
    public void addCustomer(){
        NCP = new NewCustomerPage(driver);
        HP = new HomePage(driver);

        HP.addNewCustomer();
        NCP.addNewCustomer("Abdurahman","male","2731995","address123","Cairo","Nasr City","123456","023143242542","abc@abc.com","qwerty12345");
    }
}
