package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static java.lang.Thread.sleep;

public class ProductSearchPage {

    WebDriver driver;
    Actions actions;

    String internetShopClass = "main-menu__item";

    String phonesCategoryXpath = "//a[@href='/lv/telefoni']";

    String iphoneMenuLinkXpath = "//p[@class='mega-menu-device__title']";

    String iphone15ProMaxXpath = "//a[@href=\"/lv/telefoni/apple-iphone-15-pro-max\"]";


    String iphone15MemoryStorageXpath = "//div[text()='512 GB']";
    String iphone15PaymentImmediatelyXpath = "//*[@id=\"device-default--heading\"]/div[1]";

    String addDeviceToCartButtonXpath = "//button[@class='button--add-to-cart btn--sm btn--regular btn--cart-revert-secondary is-ajax-submit button button--primary js-form-submit form-submit btn btn-default btn--cart'][@type='submit']";

    String goToCartXpath = "//a[@href=\"/lv/cart\"][text()='Doties uz grozu']";

    String checkoutXpath = "//button[@class='btn btn-default btn--big btn--big--regular btn--arrow btn--revert-color-md-down shoppingCart__continueButton button js-form-submit form-submit btn btn-default']";


    public ProductSearchPage(WebDriver driver) {

        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void productSearch() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        acceptCookies();


        WebElement shopMenu = wait.until(ExpectedConditions.elementToBeClickable(By.className(internetShopClass)));
        actions.moveToElement(shopMenu).build().perform();


        WebElement category = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(phonesCategoryXpath)));
        actions.moveToElement(category).build().perform();


        WebElement iphoneMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(iphoneMenuLinkXpath)));
        actions.moveToElement(iphoneMenu).click().build().perform();


        WebElement iphone15ProMax = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iphone15ProMaxXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(iphone15ProMax));


        try {
            iphone15ProMax.click();
        } catch (ElementClickInterceptedException e) {

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", iphone15ProMax);
        }


        WebElement iphone15MemoryStorage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iphone15MemoryStorageXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(iphone15MemoryStorage));

        try {
            iphone15MemoryStorage.click();
        } catch (StaleElementReferenceException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", iphone15MemoryStorage);

        }

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement iphone15PaymentImmediately = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iphone15PaymentImmediatelyXpath)));
        actions.moveToElement(iphone15PaymentImmediately).click().build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(iphone15PaymentImmediatelyXpath)));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#device-default--heading > div.product-device__prices-wrapper.product-device__prices-wrapper--new.product-details__accordion-heading.input--filled > a').click();");


        WebElement addDeviceToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addDeviceToCartButtonXpath)));
        actions.moveToElement(addDeviceToCart).click().build().perform();


        js.executeScript("document.querySelector('#device-default--collapse > div > div').click();");


        WebElement goToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(goToCartXpath)));
        actions.moveToElement(goToCart).click().build().perform();



        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(checkoutXpath)));
        actions.moveToElement(checkout).click().build().perform();

        }
    public void acceptCookies() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookieConsent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CybotCookiebotDialogTabContent")));
        WebElement acceptButton = cookieConsent.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']"));
        actions.moveToElement(acceptButton).click().build().perform();
    }
    }