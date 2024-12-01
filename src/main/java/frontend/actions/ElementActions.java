package frontend.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementActions {

    private final WebDriver driver;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void findAndFillInputField(By locator, String text) {
        WebElement element = findElement(locator);
        Actions actions = new Actions(driver);
        actions.sendKeys(element, text);
    }

    public void clickElement(By locator) {
        WebElement element = findElement(locator);
        Actions actions = new Actions(driver);
        actions.click(element).perform();
    }

    public void hoverOverElement(By locator) {
        WebElement element = findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void doubleClickElement(By locator) {
        WebElement element = findElement(locator);
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public void rightClickElement(By locator) {
        WebElement element = findElement(locator);
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public void dragAndDropElement(By sourceLocator, By targetLocator) {
        WebElement source = findElement(sourceLocator);
        WebElement target = findElement(targetLocator);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(source, target.getLocation().x, target.getLocation().y).perform();
    }

}
