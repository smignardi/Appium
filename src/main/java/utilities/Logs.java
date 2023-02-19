package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {
    private static final Logger log = LogManager.getLogger("AUTOMATION");

    public static void printSeparator() {
        log.info("------------------------------------------------------------------------------------------");
    }
    private final static String smallSeparator = "**********************************************************";

    public static void preconditionStart() {
        printSeparator();
        log.info("SETUP");
        printSeparator();
    }

    public static void postConditionStart() {
        printSeparatorDebug();
        log.debug("TEARDOWN");
        printSeparatorDebug();
    }

    public static void postConditionFinish() {
        printSeparatorDebug();
    }
    private static void printSeparatorDebug() {
        log.debug(smallSeparator);
    }

    private static void printNewLine() {
        log.info("");
    }

    public static void startTest(String testName) {
        printSeparator();
        log.info("Test: " + testName);
        printSeparator();
    }

    public static void endTest(String status) {
        printSeparator();
        log.info(status);
        printSeparator();
        printNewLine();
        printNewLine();
    }

    public static void startSuite(String suiteName) {
        printNewLine();
        printSeparator();
        printSeparator();
        log.info("Beginning: " + suiteName);
        printSeparator();
        printSeparator();
        printNewLine();
    }

    public static void info(String message) {
        log.info(message);
    }

    public static void warn(String message) {
        log.warn(message);
    }

    public static void error(String message) {
        log.error(message);
    }

    public static void debug(String message) {
        log.debug(message);
    }
}
