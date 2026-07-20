package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    // Menu
    private final By menuButton =
            By.xpath("//mat-icon[text()='menu']");

    // General Menu
    private final By generalMenu =
            By.xpath("//a[text()='General']");

    public void openMenu() {
        click(menuButton);
    }

    public void clickGeneral() {
        click(generalMenu);
    }

    public void navigateToGeneral() {

        openMenu();
        clickGeneral();

    }
}