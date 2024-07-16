package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
public class LoginTest extends BaseTest {


   @Test
   @Parameters ({"username", "password"})

    public void successfulLogin() {


        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("kojudgi@gmail.com", "Flatron20");

    }

    @Test
    public void unsuccessfulLogin() {


    LoginPage loginPage = new LoginPage(driver);

        loginPage.login("kojudgi@gmail.com","Flatron");

    }
}
