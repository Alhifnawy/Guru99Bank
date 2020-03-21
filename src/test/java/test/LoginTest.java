package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageModel.LoginPage;

public class LoginTest extends TestBase{

    LoginPage logPage;

    @Test
    public void verifySuccessfullLogin(){

        logPage = new LoginPage(driver);

        logPage.SubmitLoginCredentials("mngr251101","dYrYhun");

        Assert.assertTrue(driver.findElement(By.xpath("//td[@style='color: green']")).getText().contains("Manger Id : mng"));
        Assert.assertEquals(driver.findElement(By.xpath("//td[@style='color: green']")).getText(),"Manger Id : mngr251101");
    }
}
