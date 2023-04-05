package iSkillo_tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    public static final String TEST_RESOURCES_DIR = "src" + File.separator + "test" + File.separator + "resources" + File.separator;
    public static final String SCREENSHOT_DIR = TEST_RESOURCES_DIR.concat("screenshots" + File.separator);

    @BeforeMethod
    public void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) {
        makeScreenShot(testResult);
        if (driver != null) {
            driver.close();
        }
    }

    private void makeScreenShot(ITestResult testResult){
        if (ITestResult.FAILURE == testResult.getStatus()){
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
            String testName = testResult.getName();
            try {
                FileUtils.copyFile(screenshot, new File(SCREENSHOT_DIR.concat(testName).concat(".jpg")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
