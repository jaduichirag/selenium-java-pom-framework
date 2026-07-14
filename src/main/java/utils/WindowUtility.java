package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class WindowUtility {

    private final WebDriver driver;
    private final WaitUtility wait;

    public WindowUtility(WebDriver driver) {

        this.driver = driver;
        this.wait = new WaitUtility(driver);

    }

    // =====================================================
    // Current Window
    // =====================================================

    public String getCurrentWindow() {

        return driver.getWindowHandle();

    }

    // =====================================================
    // All Windows
    // =====================================================

    public Set<String> getAllWindows() {

        return driver.getWindowHandles();

    }

    // =====================================================
    // Window Count
    // =====================================================

    public int getWindowCount() {

        return driver.getWindowHandles().size();

    }

    // =====================================================
    // Open New Tab
    // =====================================================

    public void openNewTab() {

        driver.switchTo().newWindow(WindowType.TAB);

    }

    // =====================================================
    // Open New Window
    // =====================================================

    public void openNewWindow() {

        driver.switchTo().newWindow(WindowType.WINDOW);

    }

    // =====================================================
    // Switch To Latest Window
    // =====================================================

    public void switchToLatestWindow() {

        List<String> windows =
                new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(
                windows.get(windows.size() - 1));

    }

    // =====================================================
    // Switch To Parent Window
    // =====================================================

    public void switchToParentWindow(String parentWindow) {

        driver.switchTo().window(parentWindow);

    }

    // =====================================================
    // Switch By Title
    // =====================================================

    public boolean switchToWindowByTitle(String title) {

        for (String window : driver.getWindowHandles()) {

            driver.switchTo().window(window);

            if (driver.getTitle().equalsIgnoreCase(title)) {

                return true;

            }

        }

        return false;

    }

    // =====================================================
    // Switch By Partial Title
    // =====================================================

    public boolean switchToWindowContainsTitle(String title) {

        for (String window : driver.getWindowHandles()) {

            driver.switchTo().window(window);

            if (driver.getTitle().contains(title)) {

                return true;

            }

        }

        return false;

    }

    // =====================================================
    // Switch By URL
    // =====================================================

    public boolean switchToWindowByUrl(String url) {

        for (String window : driver.getWindowHandles()) {

            driver.switchTo().window(window);

            if (driver.getCurrentUrl().equalsIgnoreCase(url)) {

                return true;

            }

        }

        return false;

    }

    // =====================================================
    // Switch By Partial URL
    // =====================================================

    public boolean switchToWindowContainsUrl(String url) {

        for (String window : driver.getWindowHandles()) {

            driver.switchTo().window(window);

            if (driver.getCurrentUrl().contains(url)) {

                return true;

            }

        }

        return false;

    }

    // =====================================================
    // Wait And Switch To New Window
    // =====================================================

    public void waitAndSwitchToNewWindow(int expectedWindows) {

        wait.waitForNumberOfWindows(expectedWindows);

        switchToLatestWindow();

    }

    // =====================================================
    // Close Current Window
    // =====================================================

    public void closeCurrentWindow() {

        driver.close();

    }

    // =====================================================
    // Close All Child Windows
    // =====================================================

    public void closeAllChildWindows(String parentWindow) {

        for (String window : driver.getWindowHandles()) {

            if (!window.equals(parentWindow)) {

                driver.switchTo().window(window);

                driver.close();

            }

        }

        driver.switchTo().window(parentWindow);

    }

    // =====================================================
    // Close All Windows
    // =====================================================

    public void closeAllWindows() {

        driver.quit();

    }

    // =====================================================
    // Check Window Exists
    // =====================================================

    public boolean isWindowPresent(String windowHandle) {

        return driver.getWindowHandles()
                .contains(windowHandle);

    }

}