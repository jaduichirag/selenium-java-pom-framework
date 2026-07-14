package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class LoggerUtility {

    private LoggerUtility() {
    }

    private static Logger logger;

    public static Logger getLogger(Class<?> clazz) {

        logger = LogManager.getLogger(clazz);

        return logger;
    }

}