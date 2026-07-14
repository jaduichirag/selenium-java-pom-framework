package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {


    private final JavascriptExecutor js;
    private final WaitUtility wait;

    public JavaScriptUtility(WebDriver driver) {

        this.js = (JavascriptExecutor) driver;
        this.wait = new WaitUtility(driver);

    }

    // =========================================================
    // Click
    // =========================================================

    public void jsClick(By locator) {

        js.executeScript(
                "arguments[0].click();",
                wait.waitForClickable(locator));

    }

    public void jsClick(WebElement element) {

        js.executeScript(
                "arguments[0].click();",
                element);

    }

    // =========================================================
    // Send Keys
    // =========================================================

    public void jsSendKeys(By locator,
                           String text) {

        js.executeScript(
                "arguments[0].value=arguments[1];",
                wait.waitForVisibility(locator),
                text);

    }

    // =========================================================
    // Scroll Into View
    // =========================================================

    public void scrollToElement(By locator) {

        js.executeScript(
                "arguments[0].scrollIntoView({behavior:'smooth',block:'center'});",
                wait.waitForVisibility(locator));

    }

    public void scrollToElement(WebElement element) {

        js.executeScript(
                "arguments[0].scrollIntoView({behavior:'smooth',block:'center'});",
                element);

    }

    // =========================================================
    // Scroll
    // =========================================================

    public void scrollToTop() {

        js.executeScript(
                "window.scrollTo(0,0);");

    }

    public void scrollToBottom() {

        js.executeScript(
                "window.scrollTo(0,document.body.scrollHeight);");

    }

    public void scrollBy(int x,
                         int y) {

        js.executeScript(
                "window.scrollBy(arguments[0],arguments[1]);",
                x,
                y);

    }

    // =========================================================
    // Highlight
    // =========================================================

    public void highlightElement(By locator) {

        WebElement element =
                wait.waitForVisibility(locator);

        js.executeScript(
                "arguments[0].style.border='3px solid red';",
                element);

    }

    public void highlightElement(WebElement element) {

        js.executeScript(
                "arguments[0].style.border='3px solid red';",
                element);

    }

    // =========================================================
    // Flash Element
    // =========================================================

    public void flash(By locator) {

        WebElement element =
                wait.waitForVisibility(locator);

        String original =
                element.getCssValue("backgroundColor");

        for (int i = 0; i < 3; i++) {

            changeColor("yellow", element);

            changeColor(original, element);

        }

    }

    private void changeColor(String color,
                             WebElement element) {

        js.executeScript(
                "arguments[0].style.backgroundColor='"
                        + color
                        + "';",
                element);

        try {

            Thread.sleep(200);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        }

    }

    // =========================================================
    // Zoom
    // =========================================================

    public void zoom(int percentage) {

        js.executeScript(
                "document.body.style.zoom='"
                        + percentage
                        + "%';");

    }

    // =========================================================
    // Draw Border
    // =========================================================

    public void drawBorder(By locator) {

        js.executeScript(
                "arguments[0].style.border='3px solid blue';",
                wait.waitForVisibility(locator));

    }

    // =========================================================
    // Get Title
    // =========================================================

    public String getTitle() {

        return (String) js.executeScript(
                "return document.title;");

    }

    // =========================================================
    // Get URL
    // =========================================================

    public String getURL() {

        return (String) js.executeScript(
                "return document.URL;");

    }

    // =========================================================
    // Refresh
    // =========================================================

    public void refresh() {

        js.executeScript(
                "history.go(0);");

    }

    // =========================================================
    // Execute Custom JavaScript
    // =========================================================

    public Object executeScript(String script,
                                Object... args) {

        return js.executeScript(script, args);

    }

    // =========================================================
    // Execute Async Script
    // =========================================================

    public Object executeAsyncScript(String script,
                                     Object... args) {

        return js.executeAsyncScript(script, args);

    }

}