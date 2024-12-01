package tests.frontend;

import frontend.drivers.DriverManager;
import frontend.drivers.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ScreenshotUtils;

import java.net.MalformedURLException;
import static frontend.drivers.DriverManagerFactory.DriverType.CHROME;

public class TestBase {
    protected static WebDriver driver = null;
    private DriverManager driverManager;

    @BeforeMethod
    public void startDriver() throws MalformedURLException {
        driverManager = DriverManagerFactory.getManager(CHROME);
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void stopDriver() {
        driverManager.quitDriver();
    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtils.captureFailureScreenshot(driver, result.getName());
        }
        stopDriver();
    }



}
