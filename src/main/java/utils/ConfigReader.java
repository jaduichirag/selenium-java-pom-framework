package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties properties = new Properties();

    private ConfigReader() {
    }

    static {

        try {

            FileInputStream file = new FileInputStream(
                    System.getProperty("user.dir")
                            + "/src/main/resources/config.properties");

            properties.load(file);

            file.close();

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to load config.properties", e);

        }

    }

    public static String getProperty(String key) {

        return properties.getProperty(key);

    }

    public static String getBrowser() {

        return getProperty("browser");

    }

    public static String getUrl() {

        return getProperty("url");

    }

    public static int getImplicitWait() {

        return Integer.parseInt(getProperty("implicitWait"));

    }

    public static int getExplicitWait() {

        return Integer.parseInt(getProperty("explicitWait"));

    }

    public static int getPageLoadTimeout() {

        return Integer.parseInt(getProperty("pageLoadTimeout"));

    }

}