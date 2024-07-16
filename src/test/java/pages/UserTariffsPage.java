package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static java.lang.Thread.sleep;


public class UserTariffsPage {

    WebDriver driver;

    Actions actions;


    String servicesButtonXpath = "//div[@class='vertical__nav-inner custom--scrollbar ps-container ps-theme-default']//a[@href=\"/lv/services\"][contains(text(), 'Pakalpojumi')]";

    String showMoreButtonXpath  = "//a[@class='with-underline show-more-btn js-show-more-btn'][contains(text(), 'vai')]";

    String availableTariffPlansXpath = "//h2[contains(text(), 'Pieejamie')]";

    String tariffPlanXpath  = "//span[contains(text(), 'Jaun')]";

    String callsInLatviaXpath  = "//td[contains(text(), 'Latv')]";

    String callsOutsideLatviaXpath  = "//td[contains(text(), 'Eirop')]";

    String smsInLatviaXpath  = "//td[contains(text(), 'Viet')]";

    String smsInEuropeXpath  = "//td[contains(text(), 'SMS Eirop')]";

    String internetInLatviaXpath  = "//td[contains(text(), 'Internets Lat')]";

    String internetInEuropeXpath  = "//td[contains(text(), 'Internets Eirop')]";

    String tariffPlanPriceXpath  = "//span[@class='price-tag__new']";




    public UserTariffsPage(WebDriver driver) {

        this.driver = driver;
        this.actions = new Actions(driver);
    }


    public void viewingInformationAboutTariffs(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        JavascriptExecutor js = (JavascriptExecutor) driver;


        WebElement servicesButton = driver.findElement(By.xpath(servicesButtonXpath));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(servicesButtonXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(servicesButton));

        actions.moveToElement(servicesButton).click().build().perform();


        WebElement showMoreButton = driver.findElement(By.xpath(showMoreButtonXpath));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(showMoreButtonXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(showMoreButton));
        actions.moveToElement(showMoreButton).click().build().perform();

        WebElement tariffPlanPrice = driver.findElement(By.xpath(tariffPlanPriceXpath));
        js.executeScript("arguments[0].scrollIntoView(true);", tariffPlanPrice);



        WebElement callsInLatvia = driver.findElement(By.xpath(callsInLatviaXpath));
        WebElement callsOutsideLatvia = driver.findElement(By.xpath(callsOutsideLatviaXpath));
        WebElement smsInLatvia = driver.findElement(By.xpath(smsInLatviaXpath));
        WebElement smsInEurope = driver.findElement(By.xpath(smsInEuropeXpath));
        WebElement internetInLatvia = driver.findElement(By.xpath(internetInLatviaXpath));
        WebElement internetInEurope = driver.findElement(By.xpath(internetInEuropeXpath));



        String callsInLatviaValue = driver.findElement(By.xpath("//img[@alt='Infinity']")).getAttribute("alt");
        String callsOutsideLatviaValue = driver.findElement(By.xpath("//img[@alt='Infinity']")).getAttribute("alt");
        String smsInLatviaValue = driver.findElement(By.xpath("//img[@alt='Infinity']")).getAttribute("alt");
        String smsInEuropeValue = driver.findElement(By.xpath("//img[@alt='Infinity']")).getAttribute("alt");
        String internetInLatviaValue = driver.findElement(By.xpath("//img[@alt='Infinity']")).getAttribute("alt");
        String internetInEuropeValue = driver.findElement(By.xpath("//td[text()=\"20 GB\"]")).getText();



        Assert.assertEquals("Infinity", callsInLatviaValue);
        Assert.assertEquals("Infinity", callsOutsideLatviaValue);
        Assert.assertEquals("Infinity", smsInLatviaValue);
        Assert.assertEquals("Infinity", smsInEuropeValue);
        Assert.assertEquals("Infinity", internetInLatviaValue);
        Assert.assertEquals("20 GB", internetInEuropeValue);


        System.out.println("All assertions passed.");


        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
