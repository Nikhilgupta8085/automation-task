package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DomainName {

   private final WebDriver driver;
   private final WebDriverWait wait;

   private final By subDomainField =
           By.xpath("//input[@formcontrolname='subdomain']");

   private final By submitButton =
           By.xpath("//button[contains(text(),'Submit')]");

   public DomainName(WebDriver driver) {
      this.driver = driver;
      this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   }

   public void enterDomain() {
      wait.until(ExpectedConditions.visibilityOfElementLocated(subDomainField));
      driver.findElement(subDomainField).clear();
      driver.findElement(subDomainField).sendKeys("minierp");

      wait.until(ExpectedConditions.elementToBeClickable(submitButton));
      driver.findElement(submitButton).click();

      System.out.println("Domain entered and submitted.");
   }
}