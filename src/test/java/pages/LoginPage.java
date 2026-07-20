package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//button[contains(text(),'Login')]");

    public void enterUsername(String username) {
        type(txtUsername, username);
    }

    public void enterPassword(String password) {
        type(txtPassword, password);
    }

    public void clickLogin() {
        click(btnLogin);
    }

    public void LoginIntoApplication(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // Complete Login Method
    public void launchApplicationAndLogin(String url, String username, String password) {

        driver.get(url);

        enterUsername(username);
        enterPassword(password);
        clickLogin();

    }
}