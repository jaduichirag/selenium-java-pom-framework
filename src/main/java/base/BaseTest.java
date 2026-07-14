package base;

import java.lang.reflect.Method;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;
import utils.DriverFactory;
import utils.LoggerUtility;

public abstract class BaseTest {

    public WebDriver driver;

    protected final Logger log =
            LoggerUtility.getLogger(getClass());

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {

        log.info("========================================");
        log.info("Starting Test : {}", method.getName());

        DriverFactory.initializeDriver(
                ConfigReader.getBrowser());

        driver = DriverFactory.getDriver();

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.get(ConfigReader.getUrl());

        log.info("Browser : {}", ConfigReader.getBrowser());

        log.info("URL : {}", ConfigReader.getUrl());

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (driver != null) {

            DriverFactory.quitDriver();

            log.info("Browser Closed");

        }

        log.info("========================================");

    }

    public WebDriver getDriver() {

        return driver;

    }

}