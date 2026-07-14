package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameUtility {

    private final WebDriver driver;
    private final WaitUtility wait;

    public FrameUtility(WebDriver driver) {

        this.driver = driver;
        this.wait = new WaitUtility(driver);

    }

    // =====================================================
    // Switch By Index
    // =====================================================

    public void switchToFrame(int index) {

        driver.switchTo().frame(index);

    }

    // =====================================================
    // Switch By Name Or ID
    // =====================================================

    public void switchToFrame(String nameOrId) {

        driver.switchTo().frame(nameOrId);

    }

    // =====================================================
    // Switch By WebElement
    // =====================================================

    public void switchToFrame(WebElement frameElement) {

        wait.waitForClickable(frameElement);

        driver.switchTo().frame(frameElement);

    }

    // =====================================================
    // Switch By Locator
    // =====================================================

    public void switchToFrame(By locator) {

        driver.switchTo().frame(
                wait.waitForVisibility(locator));

    }

    // =====================================================
    // Parent Frame
    // =====================================================

    public void switchToParentFrame() {

        driver.switchTo().parentFrame();

    }

    // =====================================================
    // Default Content
    // =====================================================

    public void switchToDefaultContent() {

        driver.switchTo().defaultContent();

    }

    // =====================================================
    // Verify Frame Exists By Locator
    // =====================================================

    public boolean isFrameAvailable(By locator) {

        try {

            driver.switchTo().frame(
                    wait.waitForVisibility(locator));

            driver.switchTo().defaultContent();

            return true;

        }

        catch (Exception e) {

            return false;

        }

    }

    // =====================================================
    // Verify Frame Exists By Index
    // =====================================================

    public boolean isFrameAvailable(int index) {

        try {

            driver.switchTo().frame(index);

            driver.switchTo().defaultContent();

            return true;

        }

        catch (NoSuchFrameException e) {

            return false;

        }

    }

    // =====================================================
    // Verify Frame Exists By Name
    // =====================================================

    public boolean isFrameAvailable(String nameOrId) {

        try {

            driver.switchTo().frame(nameOrId);

            driver.switchTo().defaultContent();

            return true;

        }

        catch (NoSuchFrameException e) {

            return false;

        }

    }

    // =====================================================
    // Get Current Frame Count
    // =====================================================

    public int getFrameCount() {

        return driver.findElements(By.tagName("iframe")).size();

    }

    // =====================================================
    // Switch To First Frame
    // =====================================================

    public void switchToFirstFrame() {

        driver.switchTo().frame(0);

    }

    // =====================================================
    // Switch To Last Frame
    // =====================================================

    public void switchToLastFrame() {

        int count = getFrameCount();

        if (count > 0) {

            driver.switchTo().frame(count - 1);

        }

    }

    // =====================================================
    // Switch To Nested Frame
    // =====================================================

    public void switchToNestedFrame(int parentFrame,
                                    int childFrame) {

        driver.switchTo().defaultContent();

        driver.switchTo().frame(parentFrame);

        driver.switchTo().frame(childFrame);

    }

    // =====================================================
    // Switch To Nested Frame By Name
    // =====================================================

    public void switchToNestedFrame(String parent,
                                    String child) {

        driver.switchTo().defaultContent();

        driver.switchTo().frame(parent);

        driver.switchTo().frame(child);

    }

}