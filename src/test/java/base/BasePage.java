package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Wait until element is visible
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait until element is clickable
    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Click
    public void click(By locator) {
        waitForClickable(locator).click();
    }

    // Enter Text
    public void sendKeys(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        element.sendKeys(text);
    }

    // Clear Text
    public void clear(By locator) {
        waitForVisibility(locator).clear();
    }

    // Clear and Enter Text
    public void type(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    // Get Text
    public String getText(By locator) {
        return waitForVisibility(locator).getText().trim();
    }

    // Check Displayed
    public boolean isDisplayed(By locator) {
        try {
            return waitForVisibility(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Scroll Into View
    public void scrollIntoView(By locator) {
        WebElement element = waitForVisibility(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // JavaScript Click
    public void jsClick(By locator) {
        WebElement element = waitForVisibility(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // Hover
    public void hover(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(waitForVisibility(locator)).perform();
    }

    // Wait for Invisibility
    public void waitForInvisibility(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // Get Attribute
    public String getAttribute(By locator, String attribute) {
        return waitForVisibility(locator).getAttribute(attribute);
    }

    // Check Checkbox
    public void check(By locator) {
        WebElement element = waitForVisibility(locator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    // Uncheck Checkbox
    public void uncheck(By locator) {
        WebElement element = waitForVisibility(locator);
        if (element.isSelected()) {
            element.click();
        }
    }
}