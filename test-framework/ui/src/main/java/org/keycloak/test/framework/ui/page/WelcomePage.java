package org.keycloak.test.framework.ui.page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends AbstractPage {

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "password-confirmation")
    private WebElement passwordConfirmationInput;

    @FindBy(css = "[type=submit]")
    private WebElement submitButton;

    @FindBy(css = ".pf-v5-c-alert")
    private WebElement pageAlert;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo() {
        driver.get("http://localhost:8080");
    }

    public void fillRegistration(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        passwordConfirmationInput.sendKeys(password);
    }

    public void submit() {
        submitButton.click();
    }

    public void assertUserCreated() {
        Assertions.assertTrue(pageAlert.getText().contains("User created"));
    }

}
