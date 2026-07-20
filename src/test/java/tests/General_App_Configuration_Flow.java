package tests;

import base.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.ExtentReportListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.GeneralPage;
import pages.LoginPage;
import utils.DriverManager;

import java.time.Duration;

@Listeners(ExtentReportListener.class)
public class General_App_Configuration_Flow {

    WebDriver driver;
    WebDriverWait wait;
    BasePage basePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    GeneralPage generalPage;

    @BeforeMethod
    public void setupBrowser() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        DriverManager.setDriver(driver);

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        generalPage = new GeneralPage(driver);

        // Open application
        driver.get("https://mobileidwebqanfw-phase2.azurewebsites.net");

        // Login
        loginPage.LoginIntoApplication("Sankar", "Sankar");

    }

    @Test(description = "Update General Configuration")
    public void updateGeneralConfiguration() {

        ExtentReportListener.getExtentTest().info("Updating Search History Hours");

        generalPage.enterSearchHistoryHours("200");
        generalPage.saveSearchHistoryHours();

        generalPage.enterSimilarityScore("20");
        generalPage.saveSimilarityScore();

        ExtentReportListener.getExtentTest().info("Updating Similarity Score Label");
        ExtentReportListener.getExtentTest().pass("General Configuration updated successfully.");
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}