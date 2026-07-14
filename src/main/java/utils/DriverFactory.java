package utils;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

    private DriverFactory() {
    }

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initializeDriver(String browser) {

        if (browser == null || browser.isBlank()) {
            browser = "chrome";
        }

        switch (browser.toLowerCase()) {

            case "chrome":

                WebDriverManager.chromedriver().setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

                driver.set(new ChromeDriver(chromeOptions));
                break;

            case "firefox":

                WebDriverManager.firefoxdriver().setup();

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

                driver.set(new FirefoxDriver(firefoxOptions));
                break;

            case "edge":

                WebDriverManager.edgedriver().setup();

                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

                driver.set(new EdgeDriver(edgeOptions));
                break;

            default:
                throw new RuntimeException("Browser Not Supported : " + browser);
        }

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();
            driver.remove();

        }
    }

}