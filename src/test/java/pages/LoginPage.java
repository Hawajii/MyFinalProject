package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;


public class LoginPage {

    WebDriver driver;

    Actions actions;


     String cookiesAcceptButtonId = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll";

     String menuLinkButtonXpath = "//a[@class='user-menu__link js-selfcare-login-destination']";

     String loginThroughEmailButtonXpath = "//a[@class='tabs-buttons__list-link'][@href=\"#email\"]";

     String usernameFieldXpath = "//input[@type=\"email\"]";

     String passwordFieldXpath = "//input[@type=\"password\"]";

     String loginButtonXpath = "//button[@type=\"submit\"]";


    public LoginPage(WebDriver driver) {
        
        this.driver = driver;
        this.actions = new Actions(driver);

    }


    public void login(String username, String password) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        acceptCookies();

        WebElement menuLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menuLinkButtonXpath)));
        actions.moveToElement(menuLink).build().perform();
        menuLink.click();
        //driver.get("https://www.manabite.lv/lv/login");

        acceptCookies();

        // Click the login through email button
        WebElement emailLoginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loginThroughEmailButtonXpath)));
        emailLoginButton.click();

        // Enter the username
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(usernameFieldXpath)));
        usernameInput.sendKeys(username);

        // Enter the password
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(passwordFieldXpath)));
        passwordInput.sendKeys(password);

        // Click the login button
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loginButtonXpath)));
        actions.moveToElement(loginButton).click().build().perform();

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public void acceptCookies() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookieConsent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CybotCookiebotDialogTabContent")));
        WebElement acceptButton = cookieConsent.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']"));
        actions.moveToElement(acceptButton).click().build().perform();
    }
}
