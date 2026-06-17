package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ItemMasterPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Item Name
    private final By itemNameField =
            By.xpath("//textarea[@id='itemName']");

    // Item Type dropdown
    private final By itemTypeDropdown =
            By.xpath("//select[@id='itemType']");

    // Group — autocomplete
    private final By groupDropdownArrow =
            By.xpath("//input[@placeholder='Search Group']/parent::span/button");
    private final By groupFirstOption =
            By.xpath("//li[contains(@class,'p-autocomplete-item')][1]");

    // Item Category dropdown
    private final By itemCategoryDropdown =
            By.xpath("//select[@id='itemCategory']");

    // Item Source dropdown
    private final By itemSourceDropdown =
            By.xpath("//select[@id='itemSource']");

    // Model number
    private final By modelNumber =
            By.xpath("//input[@id='modelNo']");

    // Category — autocomplete
    private final By categoryDropdownArrow =
            By.xpath("//input[@placeholder='Search Category']/parent::span/button");
    private final By categoryFirstOption =
            By.xpath("//li[contains(@class,'p-autocomplete-item')][1]");

    // Sub Category — autocomplete
    private final By subCategoryDropdownArrow =
            By.xpath("//input[@placeholder='Search Sub Category']/parent::span/button");
    private final By subCategoryFirstOption =
            By.xpath("//li[contains(@class,'p-autocomplete-item')][1]");

    // Item Description
    private final By itemDescription =
            By.xpath("//input[@id='itemDescription']");

    // Sale Tolerance
    private final By saleTolerance =
            By.xpath("//input[@id='saleTolerance']");

    // Purchase Tolerance
    private final By purchase =
            By.xpath("//input[@id='tolerance']");

    // Item Rate
    private final By itemRate =
            By.xpath("//input[@id='itemRate']");

    // HSN Code — autocomplete (specific value 10255)
    private final By hsnDropdownArrow =
            By.xpath("//input[@placeholder='Search HSN Code']/parent::span/button");
    private final By hsnOption10255 =
            By.xpath("//div[contains(@class,'ac-item') and contains(text(),'10255')]");

    // Units SKU dropdown
    private final By unitDropdown =
            By.xpath("//select[@id='unitId']");
    private final By unitchoose =
            By.xpath("//option[@value='12199']");

    // Min stock
    private final By minStock =
            By.xpath("//input[@id='minStock']");

    // Max stock
    private final By maxStock =
            By.xpath("//input[@id='maxStock']");

    // Reorder level
    private final By reoderLevel =
            By.xpath("//input[@id='reorderLevel']");

    // Lead time
    private final By leadTime =
            By.xpath("//input[@id='procurementLeadTime']");

    // Average consumption quantity
    private final By average =
            By.xpath("//input[@id='averageConsumptionQuantity']");

    // Average rate
    private final By aRate =
            By.xpath("//input[@id='averageRate']");

    // Last PO rate
    private final By lRate =
            By.xpath("//input[@id='lastPoRate']");

    // Consumption Frequency dropdown
    private final By consumptionFrequencyDropdown =
            By.xpath("//select[@id='consumptionFrequency']");

    // Brand Name — autocomplete
    private final By brandDropdownArrow =
            By.xpath("//input[@placeholder='Search Brand Name']/parent::span/button");
    private final By brandFirstOption =
            By.xpath("//div[contains(@class,'ac-item') and contains(text(),'B12')]");

    // Width
    private final By width =
            By.xpath("//input[@id='width']");

    // Length
    private final By length =
            By.xpath("//input[@id='length']");

    // Height
    private final By height =
            By.xpath("//input[@id='height']");

    // Item Ref
    private final By itemRef =
            By.xpath("//textarea[@id='itemRef']");

    // Net Weight
    private final By weight =
            By.xpath("//input[@id='netWeight']");

    // Density
    private final By density =
            By.xpath("//input[@name='density']");

    // Part Made Of dropdown
    private final By partMadeOfDropdown =
            By.xpath("//select[@id='partMadeOf']");

    // Location
    private final By location =
            By.xpath("//input[@id='locationName']");

    // Status dropdown
    private final By status =
            By.xpath("//select[@id='status']");
    //savebtn
    private final By Save=
            By.xpath("//button[normalize-space()='Save']");

    public ItemMasterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void selectFirstOption(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Select select = new Select(driver.findElement(locator));
        select.selectByIndex(1);
        System.out.println("Selected first option: " + locator);
    }

    private void selectFirstAutocompleteOption(By arrowLocator, By firstOptionLocator) {
        wait.until(ExpectedConditions.elementToBeClickable(arrowLocator));
        driver.findElement(arrowLocator).click();
        System.out.println("Clicked dropdown arrow.");

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstOptionLocator));
        driver.findElement(firstOptionLocator).click();
        System.out.println("Selected first autocomplete option.");
    }

    private void selectHsnCode10255() {
        wait.until(ExpectedConditions.elementToBeClickable(hsnDropdownArrow));
        driver.findElement(hsnDropdownArrow).click();
        System.out.println("Clicked HSN dropdown arrow.");

        wait.until(ExpectedConditions.visibilityOfElementLocated(hsnOption10255));
        driver.findElement(hsnOption10255).click();
        System.out.println("Selected HSN Code: 10255");
    }



    public void fillForm() {

        // Item Name
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemNameField));
        driver.findElement(itemNameField).sendKeys("Test Item Selenium");
        System.out.println("Item Name filled.");

        // Item Type
        selectFirstOption(itemTypeDropdown);

        // Group
        selectFirstAutocompleteOption(groupDropdownArrow, groupFirstOption);

        // Item Category
        selectFirstOption(itemCategoryDropdown);

        // Item Source
        selectFirstOption(itemSourceDropdown);

        // Model Number
        driver.findElement(modelNumber).sendKeys("ABC1234");

        // Category — autocomplete
        selectFirstAutocompleteOption(categoryDropdownArrow, categoryFirstOption);

        // Sub Category — autocomplete
        selectFirstAutocompleteOption(subCategoryDropdownArrow, subCategoryFirstOption);

        // Item Description
        driver.findElement(itemDescription).sendKeys("This is new Car");

        // Sale Tolerance
        driver.findElement(saleTolerance).sendKeys("20");

        // Purchase Tolerance
        driver.findElement(purchase).sendKeys("4");

        // Item Rate
        driver.findElement(itemRate).sendKeys("40000");

        // Average consumption quantity
        driver.findElement(average).sendKeys("50");

        // Average rate
        driver.findElement(aRate).sendKeys("5000");

        // HSN Code — specific value 10255
        selectHsnCode10255();

        // Units SKU
        selectFirstOption(unitDropdown);

        // Min stock
        driver.findElement(minStock).sendKeys("1200");

        // Max stock
        driver.findElement(maxStock).sendKeys("2000");

        // Reorder level
        driver.findElement(reoderLevel).sendKeys("5");

        // Lead time
        driver.findElement(leadTime).sendKeys("10");

        // Last PO rate
        driver.findElement(lRate).sendKeys("40");

        // Width
        driver.findElement(width).sendKeys("12");

        // Length
        driver.findElement(length).sendKeys("8");

        // Height
        driver.findElement(height).sendKeys("6");

        // Item Ref
        driver.findElement(itemRef).sendKeys("This is new item for reference you can choice for anyone");

        // Net Weight
        driver.findElement(weight).sendKeys("600");

        // Density
        driver.findElement(density).sendKeys("150");

        // Location
        driver.findElement(location).sendKeys("India");

        // Brand Name
        selectFirstAutocompleteOption(brandDropdownArrow, brandFirstOption);

        // Part Made Of
        selectFirstOption(partMadeOfDropdown);

        // Status
        selectFirstOption(status);

        //save
        driver.findElement(Save).click();

        System.out.println("Form filled successfully.");
    }
}