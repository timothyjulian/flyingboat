package me.timothy.flyingboat.util;

import me.timothy.flyingboat.constants.LogConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogConstant.LOG_ID);

    public static void debug (String message) {
        LOGGER.debug("DEBUG: " + message);
    }

    public static void info(String message) {
        LOGGER.info(message);
    }

    public static void warn(String message) { LOGGER.warn(message);}

    public static void error(String message) { LOGGER.error(message); }
}
