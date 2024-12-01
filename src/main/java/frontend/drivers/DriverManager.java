package frontend.drivers;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public abstract class DriverManager {

    protected WebDriver driver;
    private final Dotenv dotenv = Dotenv.load();
    protected final String hostUrl = dotenv.get("HOST_URL");


    protected abstract void createDriver() throws MalformedURLException;

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }

    }

    public WebDriver getDriver() throws MalformedURLException {
        if (null == driver) {
            createDriver();
        }
        return driver;
    }
}