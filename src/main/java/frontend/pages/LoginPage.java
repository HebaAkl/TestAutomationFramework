package frontend.pages;

import frontend.actions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final ElementActions elementActions;

    public LoginPage(WebDriver driver) {
        elementActions = new ElementActions(driver);
    }

    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector("button[type=\"submit\"]");


    public void fillInEmail(String email) {
        elementActions.findAndFillInputField(emailField, email);
    }

    public void fillInPassword(String password) {
        elementActions.findAndFillInputField(passwordField, password);
    }

    public void clickLoginButton() {
        elementActions.clickElement(loginButton);
    }

}
