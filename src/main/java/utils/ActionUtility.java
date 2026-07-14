package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtility {

    private final Actions actions;
    private final WaitUtility wait;

    public ActionUtility(WebDriver driver) {

        this.actions = new Actions(driver);
        this.wait = new WaitUtility(driver);

    }

    // =====================================================
    // Click
    // =====================================================

    public void click(By locator) {

        actions.click(wait.waitForClickable(locator))
               .perform();

    }

    public void click(WebElement element) {

        actions.click(element)
               .perform();

    }

    // =====================================================
    // Hover
    // =====================================================

    public void hover(By locator) {

        actions.moveToElement(wait.waitForVisibility(locator))
               .perform();

    }

    public void hover(WebElement element) {

        actions.moveToElement(element)
               .perform();

    }

    // =====================================================
    // Double Click
    // =====================================================

    public void doubleClick(By locator) {

        actions.doubleClick(wait.waitForClickable(locator))
               .perform();

    }

    public void doubleClick(WebElement element) {

        actions.doubleClick(element)
               .perform();

    }

    // =====================================================
    // Right Click
    // =====================================================

    public void rightClick(By locator) {

        actions.contextClick(wait.waitForClickable(locator))
               .perform();

    }

    public void rightClick(WebElement element) {

        actions.contextClick(element)
               .perform();

    }

    // =====================================================
    // Click And Hold
    // =====================================================

    public void clickAndHold(By locator) {

        actions.clickAndHold(wait.waitForVisibility(locator))
               .perform();

    }

    public void clickAndHold(WebElement element) {

        actions.clickAndHold(element)
               .perform();

    }

    // =====================================================
    // Release
    // =====================================================

    public void release(By locator) {

        actions.release(wait.waitForVisibility(locator))
               .perform();

    }

    public void release(WebElement element) {

        actions.release(element)
               .perform();

    }

    // =====================================================
    // Drag And Drop
    // =====================================================

    public void dragAndDrop(By source,
                            By target) {

        actions.dragAndDrop(
                wait.waitForVisibility(source),
                wait.waitForVisibility(target))
                .perform();

    }

    public void dragAndDrop(WebElement source,
                            WebElement target) {

        actions.dragAndDrop(source, target)
               .perform();

    }

    // =====================================================
    // Drag And Drop By Offset
    // =====================================================

    public void dragAndDropByOffset(By locator,
                                    int x,
                                    int y) {

        actions.dragAndDropBy(
                wait.waitForVisibility(locator),
                x,
                y)
                .perform();

    }

    // =====================================================
    // Move To Element
    // =====================================================

    public void moveToElement(By locator) {

        actions.moveToElement(
                wait.waitForVisibility(locator))
                .perform();

    }

    public void moveToElement(By locator,
                              int x,
                              int y) {

        actions.moveToElement(
                wait.waitForVisibility(locator),
                x,
                y)
                .perform();

    }

    // =====================================================
    // Move By Offset
    // =====================================================

    public void moveByOffset(int x,
                             int y) {

        actions.moveByOffset(x, y)
               .perform();

    }

    // =====================================================
    // Scroll
    // =====================================================

    public void scrollToElement(By locator) {

        actions.scrollToElement(
                wait.waitForVisibility(locator))
                .perform();

    }

    public void scrollByAmount(int x,
                               int y) {

        actions.scrollByAmount(x, y)
               .perform();

    }

    // =====================================================
    // Keyboard
    // =====================================================

    public void pressEnter(By locator) {

        wait.waitForVisibility(locator)
                .sendKeys(Keys.ENTER);

    }

    public void pressTab(By locator) {

        wait.waitForVisibility(locator)
                .sendKeys(Keys.TAB);

    }

    public void pressEscape() {

        actions.sendKeys(Keys.ESCAPE)
               .perform();

    }

    public void pressKey(By locator,
                         Keys key) {

        wait.waitForVisibility(locator)
                .sendKeys(key);

    }

    // =====================================================
    // Ctrl + A
    // =====================================================

    public void selectAll(By locator) {

        WebElement element = wait.waitForVisibility(locator);

        actions.click(element)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .perform();

    }

    // =====================================================
    // Ctrl + C
    // =====================================================

    public void copy(By locator) {

        WebElement element = wait.waitForVisibility(locator);

        actions.click(element)
                .keyDown(Keys.CONTROL)
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .perform();

    }

    // =====================================================
    // Ctrl + V
    // =====================================================

    public void paste(By locator) {

        WebElement element = wait.waitForVisibility(locator);

        actions.click(element)
                .keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .perform();

    }

    // =====================================================
    // Send Keys
    // =====================================================

    public void sendKeys(String text) {

        actions.sendKeys(text)
               .perform();

    }

    public void sendKeys(WebElement element,
                         String text) {

        actions.sendKeys(element, text)
               .perform();

    }

    // =====================================================
    // Pause
    // =====================================================

    public void pause(int seconds) {

        actions.pause(Duration.ofSeconds(seconds))
               .perform();

    }

}