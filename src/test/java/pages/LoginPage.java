package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginPage {

    WebDriver driver;

    Actions actions;



    By menuLinkButton = By.xpath("//a[@class='user-menu__link js-selfcare-login-destination']");
    By loginThroughEmailButton = By.xpath("//a[@class='tabs-buttons__list-link'][@href=\"#email\"]");
    By usernameField = By.xpath("//input[@type='email']");
    By passwordField = By.xpath("//input[@type='password']");
    By loginButton = By.xpath("//button[@type='submit']");



    public LoginPage(WebDriver driver) {

        this.driver = driver;
        this.actions = new Actions(driver);
    }


    public void login(String username, String password) {

        //Accepting cookies

        acceptCookies();

        // Go to login menu
        WebElement menuLink = driver.findElement(menuLinkButton);
        actions.moveToElement(menuLink).click().build().perform();

        //Accepting cookies again
        acceptCookies();

        // Login via email
        WebElement emailLoginButton = driver.findElement(loginThroughEmailButton);
        emailLoginButton.click();

        // Enter username
        WebElement usernameInput = driver.findElement(usernameField);
        usernameInput.sendKeys(username);

        // Enter password
        WebElement passwordInput = driver.findElement(passwordField);
        passwordInput.sendKeys(password);

        // Click on the login button
        WebElement loginBtn = driver.findElement(loginButton);
        actions.moveToElement(loginBtn).click().build().perform();

    }
    public void acceptCookies() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookieConsent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CybotCookiebotDialogTabContent")));
        WebElement acceptButton = cookieConsent.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']"));
        actions.moveToElement(acceptButton).click().build().perform();
        }

    public boolean isErrorMessageDisplayed() {
        try {
            WebElement errorMessageWrongPassword = driver.findElement(By.xpath("//div[@class='input-group__notice input-group__notice--error'][contains(text(), 'dati')]"));
            return errorMessageWrongPassword.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
