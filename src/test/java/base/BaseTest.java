package base;

import org.openqa.selenium.WebDriver;
import utils.DriverManager;

/** Thin access point kept for compatibility; the driver is owned by DriverManager (one per thread). */
public class BaseTest {

    public static WebDriver getDriver() {
        WebDriver driver = DriverManager.getDriver();
        return driver != null ? driver : DriverManager.startChrome();
    }

    public static void quitDriver() {
        DriverManager.quitDriver();
    }
}
