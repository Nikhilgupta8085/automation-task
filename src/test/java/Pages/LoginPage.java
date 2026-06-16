package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By usernameField =
            By.xpath("//input[@formcontrolname='username']");

    private final By passwordField =
            By.xpath("//input[@formcontrolname='password']");

    private final By loginButton =
            By.xpath("//button[@type='submit']");

    private final By logoutPopupButton =
            By.xpath("//button[contains(text(),'Logout From Other Instance')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String username, String password) {
        enterCredentials(username, password);

        try {
            // Handle popup if it appears
            wait.until(ExpectedConditions.elementToBeClickable(logoutPopupButton)).click();
            System.out.println("Popup handled — clicked Logout From Other Instance.");

            // Login again after popup
            wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
            enterCredentials(username, password);
            System.out.println("Logged in again after popup.");

        } catch (Exception e) {
            System.out.println("No popup appeared — proceeding normally.");
        }
    }

    private void enterCredentials(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);

        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }
}