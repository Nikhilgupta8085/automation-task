package Tests;

import Base.BaseClass;
import Pages.DomainName;
import Pages.LoginPage;
import Pages.NavigationPage;
import Pages.ItemMasterPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test
    public void erpLoginFlow() {

        DomainName domainPage = new DomainName(driver);
        domainPage.enterDomain();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test", "test");

        NavigationPage navPage = new NavigationPage(driver);
        navPage.goToItemMaster();

        ItemMasterPage itemMasterPage = new ItemMasterPage(driver);
        itemMasterPage.fillForm();
    }
}