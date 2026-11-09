package steps;

import utils.ConfigReader;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginSteps {

    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    // ✅ STEP 1: Open Login Page
    @Given("the user is on the login page")
    public void openLoginPage() {

        driver.get(ConfigReader.get("saucedemo.url"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));

        System.out.println("Opened SauceDemo Login Page");
    }

    // ✅ STEP 2: Enter VALID credentials
    @When("the user enters valid login credentials")
    public void enterValidCredentials() {

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(ConfigReader.get("saucedemo.username"));

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(ConfigReader.get("saucedemo.password"));

        driver.findElement(By.id("login-button")).click();

        System.out.println("Entered valid credentials");
    }

    // ✅ STEP 3: Verify successful login
    @Then("the user should be logged in successfully")
    public void verifyLogin() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));

        System.out.println("Login Successful");
    }

    // =====================================================
    // 🔽 EXTRA: NEGATIVE / SIGNUP SIMULATION STEPS
    // =====================================================

    // ❌ STEP: Invalid login
    @When("the user enters invalid username and password")
    public void enterInvalidCredentials() {

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(ConfigReader.get("saucedemo.invalid.username"));

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(ConfigReader.get("saucedemo.invalid.password"));

        driver.findElement(By.id("login-button")).click();

        System.out.println("Entered invalid credentials");
    }

    // ❌ STEP: Verify error message
    @Then("the user should see an error message")
    public void verifyErrorMessage() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("h3[data-test='error']")
        ));

        String errorMsg = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();

        System.out.println("Error message: " + errorMsg);

        if (!errorMsg.contains("Username and password do not match")) {
            throw new AssertionError("Error message NOT displayed correctly");
        }
    }
}