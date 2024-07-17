package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserTariffsPage;

public class UserTariffInformationTest extends BaseTest  {


    @Test (priority =4)

    public void viewingUserTariff (){

        LoginPage loginPage = new LoginPage(driver);

        UserTariffsPage userTariffsPage = new UserTariffsPage(driver);


        loginPage.login("kojudgi@gmail.com", "Flatron20");

        userTariffsPage.viewingInformationAboutTariffs();

    }
}
