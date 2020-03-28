package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pageModel.HomePage;
import pageModel.LoginPage;
import pageModel.NewCustomerPage;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    LoginPage logPage;
    HomePage HP;
    NewCustomerPage NCP;

    @BeforeSuite
    public void startDriver() {
        System.setProperty(Util.DRIVER_TYPE, Util.DRIVER_PATH);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);

    }

    @BeforeTest
    public void goToWebsite(){
        driver.get(Util.BASE_URL);
    }

//    @AfterSuite
//    public void tearDown() {
//        driver.quit();
//    }
}
