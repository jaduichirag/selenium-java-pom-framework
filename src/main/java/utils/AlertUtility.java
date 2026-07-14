package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertUtility {

    private final WebDriver driver;
    private final WaitUtility wait;

    public AlertUtility(WebDriver driver) {

        this.driver = driver;
        this.wait = new WaitUtility(driver);

    }

    // =====================================================
    // Private Helper
    // =====================================================

    private Alert getAlert() {

        wait.waitForAlert();

        return driver.switchTo().alert();

    }

    // =====================================================
    // Accept Alert
    // =====================================================

    public void acceptAlert() {

        getAlert().accept();

    }

    // =====================================================
    // Dismiss Alert
    // =====================================================

    public void dismissAlert() {

        getAlert().dismiss();

    }

    // =====================================================
    // Get Alert Text
    // =====================================================

    public String getAlertText() {

        return getAlert().getText();

    }

    // =====================================================
    // Send Text
    // =====================================================

    public void sendText(String text) {

        getAlert().sendKeys(text);

    }

    // =====================================================
    // Accept Prompt
    // =====================================================

    public void acceptPrompt(String text) {

        Alert alert = getAlert();

        alert.sendKeys(text);

        alert.accept();

    }

    // =====================================================
    // Dismiss Prompt
    // =====================================================

    public void dismissPrompt(String text) {

        Alert alert = getAlert();

        alert.sendKeys(text);

        alert.dismiss();

    }

    // =====================================================
    // Verify Alert Text
    // =====================================================

    public boolean verifyAlertText(String expectedText) {

        return getAlertText()
                .equals(expectedText);

    }

    // =====================================================
    // Verify Partial Alert Text
    // =====================================================

    public boolean verifyAlertContains(String expectedText) {

        return getAlertText()
                .contains(expectedText);

    }

    // =====================================================
    // Is Alert Present
    // =====================================================

    public boolean isAlertPresent() {

        try {

            driver.switchTo().alert();

            return true;

        }

        catch (NoAlertPresentException e) {

            return false;

        }

    }

    // =====================================================
    // Accept And Return Text
    // =====================================================

    public String acceptAndGetText() {

        Alert alert = getAlert();

        String text = alert.getText();

        alert.accept();

        return text;

    }

    // =====================================================
    // Dismiss And Return Text
    // =====================================================

    public String dismissAndGetText() {

        Alert alert = getAlert();

        String text = alert.getText();

        alert.dismiss();

        return text;

    }

    // =====================================================
    // Switch To Alert
    // =====================================================

    public Alert switchToAlert() {

        return getAlert();

    }

}