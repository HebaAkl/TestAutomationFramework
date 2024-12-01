package frontend.actions;

import org.openqa.selenium.WebDriver;

public class NavigationActions {

    private final WebDriver driver;

    public NavigationActions(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void forward() {
        driver.navigate().forward();
    }

    public void refresh() {
        driver.navigate().refresh();
    }

}
