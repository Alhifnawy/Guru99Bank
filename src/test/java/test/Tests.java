package test;

import data.ExcelReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Tests extends TestBase{

    String customerID;

    @DataProvider(name = "LoginData")
    public Object[][] userLoginData() throws IOException {

        //Get data from ExcelReader Class
        ExcelReader ER = new ExcelReader();

        return ER.getLoginData();
    }

    @Test(priority = 1, dataProvider = "LoginData")
    public void verifyLogin(String username, String Password) throws IOException {

        logPage.SubmitLoginCredentials(username, Password);

        try {
            Alert alt = driver.switchTo().alert();
            Assert.assertEquals(alt.getText().toLowerCase(),"user or password is not valid");
            driver.switchTo().alert().accept();

        } catch (NoAlertPresentException var8) {
            Assert.assertTrue(driver.findElement(By.xpath("//td[@style='color: green']")).getText().contains("Manger Id : "+username));
            Assert.assertEquals(driver.findElement(By.xpath("//td[@style='color: green']")).getText(),"Manger Id : "+username);
        }
    }

    @Test(priority = 2)
    public void addCustomer(){

        homePage.addNewCustomerBTN();
        newCustomerPage.addNewCustomer("Abdurahman","male","273","1995","address123","Cairo","Nasr City","425244","12345678912","abcdefghiklopkm@abcd.com","sdgdf4w35");

        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='heading3']")).getText(),"Customer Registered Successfully!!!");
        this.customerID = newCustomerPage.getCustomerID();
    }

    @Test(priority = 3)
    public void editCustomer(){

        homePage.editCustomerBTN();
        editCustomerPage.enterCustomerID(this.customerID);
        editCustomerPage.editCustomerDetails("address123","Alexandria","Kamb Shizar","425243","12345678912","abcdefghiklopkm@abcd.com");

        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='heading3']")).getText(),"Customer details updated Successfully!!!");
    }

    @Test(priority = 4)
    public void deleteCustomer(){

        homePage.deleteCustomerBTN();
        deleteCustomerPage.deleteCustomer(this.customerID);
        Alert alt = driver.switchTo().alert();
        alt.accept();
        alt.accept();
    }
}
