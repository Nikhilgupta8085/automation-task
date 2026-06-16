package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NavigationPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // anchor tag
    private final By anchorTag =
            By.xpath("//a[contains(@class,'logo-text')]");

    // Masters menu
    private final By mastersMenu =
            By.xpath("//span[text()='Masters']");

    // Item Master submenu
    private final By itemMasterMenu =
            By.xpath("//span[text()='Item Master']");


    // Add more btn
    private final By addMore=
            By.xpath("//button[text()='Add More']");

    public NavigationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void goToItemMaster() {

        //anchor tag click
        wait.until(ExpectedConditions.elementToBeClickable(anchorTag));
        driver.findElement(anchorTag).click();
        System.out.println("Clicked anchor tag");

        // Masters click
        wait.until(ExpectedConditions.elementToBeClickable(mastersMenu));
        driver.findElement(mastersMenu).click();
        System.out.println("Clicked Masters.");

        // Item Master click
        wait.until(ExpectedConditions.elementToBeClickable(itemMasterMenu));
        driver.findElement(itemMasterMenu).click();
        System.out.println("Navigated to Item Master.");

        //Add More Btn
        wait.until(ExpectedConditions.elementToBeClickable(addMore));
        driver.findElement(addMore).click();

    }
}