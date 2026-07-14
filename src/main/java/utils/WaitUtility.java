package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public WaitUtility(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(ConfigReader.getExplicitWait()));

    }

    // ======================================================
    // Visibility
    // ======================================================

    public WebElement waitForVisibility(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public WebElement waitForVisibility(WebElement element) {

        return wait.until(
                ExpectedConditions.visibilityOf(element));

    }

    // ======================================================
    // Presence
    // ======================================================

    public WebElement waitForPresence(By locator) {

        return wait.until(
                ExpectedConditions.presenceOfElementLocated(locator));

    }

    // ======================================================
    // Clickable
    // ======================================================

    public WebElement waitForClickable(By locator) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator));

    }

    public WebElement waitForClickable(WebElement element) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(element));

    }

    // ======================================================
    // Invisibility
    // ======================================================

    public boolean waitForInvisibility(By locator) {

        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator));

    }

    // ======================================================
    // Text
    // ======================================================

    public boolean waitForText(By locator,
                               String text) {

        return wait.until(
                ExpectedConditions.textToBePresentInElementLocated(
                        locator,
                        text));

    }

    // ======================================================
    // Attribute
    // ======================================================

    public boolean waitForAttribute(By locator,
                                    String attribute,
                                    String value) {

        return wait.until(
                ExpectedConditions.attributeContains(
                        locator,
                        attribute,
                        value));

    }

    // ======================================================
    // Title
    // ======================================================

    public boolean waitForTitleContains(String title) {

        return wait.until(
                ExpectedConditions.titleContains(title));

    }

    public boolean waitForTitleIs(String title) {

        return wait.until(
                ExpectedConditions.titleIs(title));

    }

    // ======================================================
    // URL
    // ======================================================

    public boolean waitForUrlContains(String url) {

        return wait.until(
                ExpectedConditions.urlContains(url));

    }

    public boolean waitForUrlToBe(String url) {

        return wait.until(
                ExpectedConditions.urlToBe(url));

    }

    // ======================================================
    // Alert
    // ======================================================

    public void waitForAlert() {

        wait.until(
                ExpectedConditions.alertIsPresent());

    }

    // ======================================================
    // Frame
    // ======================================================

    public void waitForFrame(By locator) {

        wait.until(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));

    }

    // ======================================================
    // Number Of Windows
    // ======================================================

    public boolean waitForNumberOfWindows(int count) {

        return wait.until(
                ExpectedConditions.numberOfWindowsToBe(count));

    }

    // ======================================================
    // Selection
    // ======================================================

    public boolean waitForSelection(By locator) {

        return wait.until(
                ExpectedConditions.elementToBeSelected(locator));

    }

    // ======================================================
    // List Of Elements
    // ======================================================

    public List<WebElement> waitForAllVisible(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

    }

    // ======================================================
    // Presence Of All Elements
    // ======================================================

    public List<WebElement> waitForAllPresent(By locator) {

        return wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

    }

    // ======================================================
    // Fluent Wait
    // ======================================================

    public WebElement fluentWait(By locator,
                                 int timeout,
                                 int polling) {

        FluentWait<WebDriver> fluentWait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(timeout))
                        .pollingEvery(Duration.ofSeconds(polling))
                        .ignoring(NoSuchElementException.class)
                        .ignoring(StaleElementReferenceException.class);

        return fluentWait.until(
                driver -> driver.findElement(locator));

    }

    // ======================================================
    // Custom Wait
    // ======================================================

    public void waitUntil(ExpectedCondition<?> condition) {

        wait.until(condition);

    }

    // ======================================================
    // Safe Wait
    // ======================================================

    public boolean waitUntilVisible(By locator) {

        try {

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator));

            return true;

        } catch (TimeoutException e) {

            return false;

        }

    }

}