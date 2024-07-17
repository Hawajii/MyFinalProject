package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class ProductSearchPage {

    WebDriver driver;
    Actions actions;

    By internetShopMenu = By.className("main-menu__item");
    By phonesCategory = By.xpath("//a[@href='/lv/telefoni']");
    By iphoneMenuLink = By.xpath("//p[@class='mega-menu-device__title']");
    By choosingIphone15ProMax = By.xpath("//a[@href='/lv/telefoni/apple-iphone-15-pro-max']");
    By choosingIphone15MemoryStorage = By.xpath("//div[text()='512 GB']");
    By iphone15PaymentImmediatelyButton = By.xpath("//*[@id='device-default--heading']/div[1]");
    By addDeviceToCartButton = By.xpath("//button[@class='button--add-to-cart btn--sm btn--regular btn--cart-revert-secondary is-ajax-submit button button--primary js-form-submit form-submit btn btn-default btn--cart'][@type='submit']");
    By goToCartButton = By.xpath("//a[@href='/lv/cart'][text()='Doties uz grozu']");
    By checkoutButton = By.xpath("//button[@class='btn btn-default btn--big btn--big--regular btn--arrow btn--revert-color-md-down shoppingCart__continueButton button js-form-submit form-submit btn btn-default']");

    public ProductSearchPage(WebDriver driver) {

        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void productSearch() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        acceptCookies();


        WebElement shopMenu = driver.findElement(internetShopMenu);
        actions.moveToElement(shopMenu).build().perform();


        WebElement category = driver.findElement(phonesCategory);
        actions.moveToElement(category).build().perform();


        WebElement iphoneMenu = driver.findElement((iphoneMenuLink));
        actions.moveToElement(iphoneMenu).click().build().perform();


        WebElement iphone15ProMax = wait.until(ExpectedConditions.visibilityOfElementLocated((choosingIphone15ProMax)));
        wait.until(ExpectedConditions.elementToBeClickable(iphone15ProMax));
        actions.moveToElement(iphone15ProMax).click().build().perform();


        WebElement iphone15MemoryStorage = wait.until(ExpectedConditions.visibilityOfElementLocated((choosingIphone15MemoryStorage)));
        actions.moveToElement(iphone15MemoryStorage).click().build().perform();



        WebElement iphone15PaymentImmediately = driver.findElement((iphone15PaymentImmediatelyButton));
        actions.moveToElement(iphone15PaymentImmediately).click().build().perform();


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#device-default--heading > div.product-device__prices-wrapper.product-device__prices-wrapper--new.product-details__accordion-heading.input--filled > a').click();");


        WebElement addDeviceToCart = driver.findElement((addDeviceToCartButton));
        actions.moveToElement(addDeviceToCart).click().build().perform();


        js.executeScript("document.querySelector('#device-default--collapse > div > div').click();");


        WebElement goToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(goToCartButton));
        actions.moveToElement(goToCart).click().build().perform();



        WebElement checkout = driver.findElement((checkoutButton));
        actions.moveToElement(checkout).click().build().perform();

        }
    public void acceptCookies() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement cookieConsent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CybotCookiebotDialogTabContent")));
        WebElement acceptButton = cookieConsent.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']"));
        actions.moveToElement(acceptButton).click().build().perform();
    }
    public boolean isCheckoutPageDisplayed() {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), \"Personas dati\")]")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
