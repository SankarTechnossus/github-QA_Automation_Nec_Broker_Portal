package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GeneralPage extends BasePage {

    public GeneralPage(WebDriver driver) {
        super(driver);
    }

    // Search History Hours
    private final By txtHours =
            By.xpath("(//input[@class='hours-input'])[1]");

    private final By btnHoursSave =
            By.xpath("(//button[contains(text(),'Save')])[1]");

    private final By txtSimilarity =
            By.xpath("(//input[@class='hours-input'])[2]");

    private final By btnSimilaritySave =
            By.xpath("(//button[contains(text(),'Save')])[2]");

    public void enterSearchHistoryHours(String value) {
        type(txtHours, value);
    }

    public void saveSearchHistoryHours() {
        click(btnHoursSave);
    }

    public void enterSimilarityScore(String value) {
        type(txtSimilarity, value);
    }

    public void saveSimilarityScore() {
        click(btnSimilaritySave);
    }

    private final By txtSearchHistoryHours =
            By.xpath("//span[text()='Search History Hours Limit']/ancestor::div[contains(@class,'search-history-section')]//input");

    private final By btnSearchHistorySave =
            By.xpath("//span[text()='Search History Hours Limit']/ancestor::div[contains(@class,'search-history-section')]//button");

    // Similarity Score

    private final By txtSimilarityScore =
            By.xpath("//span[text()='Similarity Score Label']/ancestor::div[contains(@class,'search-history-section')]//input");



    public void updateSearchHistoryHours(String hours) {

        type(txtSearchHistoryHours, hours);
        click(btnSearchHistorySave);

    }

    public void updateSimilarityScore(String score) {

        type(txtSimilarityScore, score);
        click(btnSimilaritySave);

    }

}