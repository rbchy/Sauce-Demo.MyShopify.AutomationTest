package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitUtils {

    WebDriver driver;
    WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * The Shopify theme slides product cards in with a CSS animation ("animated fadeInUpBig").
     * Until it ends the cards are not displayed or clickable, so wait for every animation to finish.
     */
    public static void waitForAnimations(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(d -> {
            Object done = ((JavascriptExecutor) d).executeScript(
                    "return document.readyState === 'complete' && "
                    + "(!document.getAnimations || document.getAnimations()"
                    + ".every(a => a.playState === 'finished' || a.playState === 'idle'));");
            return Boolean.TRUE.equals(done);
        });
    }
}