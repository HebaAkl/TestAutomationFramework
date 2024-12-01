package frontend.actions;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BrowserActions {

    private final WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void fullscreenWindow() {
        ((JavascriptExecutor)driver).executeScript("window.open('','_self').close();");
    }

    public void minimizeWindow() {
        ((JavascriptExecutor)driver).executeScript("window.open('','_self').close();");
    }

    public void resizeWindow(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }
}
