package tests;

import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
public class LoginTest extends BaseTest {


   @Test (priority = 1)
   @Parameters ({"username", "password"})

    public void successfulLogin(String username, String password) {


        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(username, password);

       String expectedText = "//p[@class=\"plan-card__subtitle\"][contains(text(), \"SERGEJS RUBCOVS (100388358)\")]";

       Assert.assertEquals(driver.findElement(By.xpath(expectedText)).getText(), "SERGEJS RUBCOVS (100388358)");


   }

    @Test (priority = 2)

    public void unsuccessfulLogin() {


    LoginPage loginPage = new LoginPage(driver);

        loginPage.login("kojudgi@gmail.com","Flatron");

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "The wrong password error message does not appear after a failed login.");

    }
}
