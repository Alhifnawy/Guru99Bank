package test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Util {

    //Specify the driver to be firefox driver
    public static final String DRIVER_TYPE = "webdriver.chrome.driver";

    //Specify the firefox driver location
    public static final String DRIVER_PATH = "src/test/resources/chromedriver.exe";

    // Setting Base URL
    public static final String BASE_URL = "http://www.demo.guru99.com/V4/";

    // Time to wait when searching for a GUI element
    public static final int WAIT_TIME = 30;



    // Destination of the screenshot & its name
    public static String ssPath;

    //Method to take a screenshot
    public static void takeScreenshot(WebDriver driver, String filePath) throws IOException {

        // Create object to take the exact date and time of the screenshot
        Date d = new Date();

        // Define the screenshot location, replace any ":" with "-" & replace any " " with "_" to be formatted correctly
        ssPath = "src/test/java/Screenshot/"+"screenshot_" + d.toString().replace(":", "-").replace(" ", "_") + ".png";

        // Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot)driver);

        // Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        // Move image file to new destination
        File DestFile = new File(filePath);

        // Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);

    }
}
