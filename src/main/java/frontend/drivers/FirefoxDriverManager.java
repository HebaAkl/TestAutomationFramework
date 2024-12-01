package frontend.drivers;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxDriverManager extends DriverManager {

    @Override
    public void createDriver() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
        driver = new RemoteWebDriver(new URL(hostUrl), options);
        driver.manage().window().maximize();
    }

}