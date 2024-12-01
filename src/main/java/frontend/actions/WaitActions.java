package frontend.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitActions {
    private final WebDriver driver;
    private final Duration timeoutInSeconds = Duration.ofSeconds(30);
    private final Duration pollingFrequency = Duration.ofSeconds(5);

    public WaitActions(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitingForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitingForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitingForClickability(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitingForInvisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public WebElement waitForElement(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(timeoutInSeconds)
                .pollingEvery(pollingFrequency)
                .ignoring(NoSuchElementException.class);

        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForVisibility(WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(timeoutInSeconds)
                .pollingEvery(pollingFrequency)
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(timeoutInSeconds)
                .pollingEvery(pollingFrequency)
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForInvisibility(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(timeoutInSeconds)
                .pollingEvery(pollingFrequency)
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }


}
