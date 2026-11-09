package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Hooks {

    @Before
    public void setup() {
        DriverManager.startChrome();
    }

    /** Kept so existing step classes keep working; the driver itself lives in DriverManager (per thread). */
    public static WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverManager.getDriver();
        try {
            if (scenario.isFailed() && driver != null) {
                byte[] png = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(png, "image/png", "FAILED_" + scenario.getName());

                Path dir = Paths.get("target", "screenshots");
                Files.createDirectories(dir);
                String name = "FAILED_" + scenario.getName().replaceAll("[^A-Za-z0-9-]+", "_");
                Files.write(dir.resolve(name + ".png"), png);

                String html = driver.getPageSource();
                scenario.attach(html, "text/html", "Page source at failure (" + driver.getCurrentUrl() + ")");
                Files.writeString(dir.resolve(name + ".html"), "<!-- " + driver.getCurrentUrl() + " -->\n" + html);
            }
        } catch (Exception e) {
            System.err.println("Could not save failure screenshot: " + e.getMessage());
        } finally {
            DriverManager.quitDriver();
        }
    }
}
