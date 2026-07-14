package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScreenshotUtility {

    private final WebDriver driver;
    private final WaitUtility wait;

    public ScreenshotUtility(WebDriver driver) {

        this.driver = driver;
        this.wait = new WaitUtility(driver);

    }

    // =====================================================
    // Create Screenshot Folder
    // =====================================================

    private void createFolder(String folderPath) {

        File folder = new File(folderPath);

        if (!folder.exists()) {

            folder.mkdirs();

        }

    }

    // =====================================================
    // Timestamp
    // =====================================================

    private String getTimestamp() {

        return new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());

    }

    // =====================================================
    // Capture Full Screenshot
    // =====================================================

    public String capture(String testName) {

        String folder =
                System.getProperty("user.dir")
                        + File.separator
                        + "screenshots";

        createFolder(folder);

        String filePath =
                folder
                        + File.separator
                        + testName
                        + "_"
                        + getTimestamp()
                        + ".png";

        File source =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        try {

            Files.copy(source.toPath(),
                    new File(filePath).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

        }

        catch (IOException e) {

            throw new RuntimeException(
                    "Unable to capture screenshot", e);

        }

        return filePath;

    }

    // =====================================================
    // Capture Element Screenshot
    // =====================================================

    public String captureElement(By locator,
                                 String elementName) {

        return captureElement(
                wait.waitForVisibility(locator),
                elementName);

    }

    public String captureElement(WebElement element,
                                 String elementName) {

        String folder =
                System.getProperty("user.dir")
                        + File.separator
                        + "screenshots";

        createFolder(folder);

        String filePath =
                folder
                        + File.separator
                        + elementName
                        + "_"
                        + getTimestamp()
                        + ".png";

        File source =
                element.getScreenshotAs(OutputType.FILE);

        try {

            Files.copy(source.toPath(),
                    new File(filePath).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

        }

        catch (IOException e) {

            throw new RuntimeException(
                    "Unable to capture element screenshot", e);

        }

        return filePath;

    }

    // =====================================================
    // Capture PASS Screenshot
    // =====================================================

    public String capturePass(String testName) {

        return capture("PASS_" + testName);

    }

    // =====================================================
    // Capture FAIL Screenshot
    // =====================================================

    public String captureFail(String testName) {

        return capture("FAIL_" + testName);

    }

}