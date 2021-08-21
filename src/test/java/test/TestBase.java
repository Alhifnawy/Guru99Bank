package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pageModel.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    LoginPage logPage;
    HomePage homePage;
    NewCustomerPage newCustomerPage;
    EditCustomerPage editCustomerPage;
    DeleteCustomerPage deleteCustomerPage;

    @BeforeSuite
    public void startDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @BeforeTest
    public void goToWebsite(){
        driver.get(Util.BASE_URL);

        logPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        newCustomerPage = new NewCustomerPage(driver);
        editCustomerPage = new EditCustomerPage(driver);
        deleteCustomerPage = new DeleteCustomerPage(driver);
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) throws IOException {

        if(ITestResult.FAILURE == result.getStatus()){
            Util.takeScreenshot(driver,Util.ssPath);
        }
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
