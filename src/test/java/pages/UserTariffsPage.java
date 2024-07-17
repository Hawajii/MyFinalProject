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

public class UserTariffsPage {

    WebDriver driver;
    Actions actions;

    By servicesButtonElement = By.xpath("//div[@class='vertical__nav-inner custom--scrollbar ps-container ps-theme-default']//a[@href='/lv/services'][contains(text(), 'Pakalpojumi')]");
    By showMoreButtonElement = By.xpath("//a[@class='with-underline show-more-btn js-show-more-btn'][contains(text(), 'vai')]");
    By tariffPlanPriceElement = By.xpath("//span[@class='price-tag__new']");

    By callsInLatviaElement = By.xpath("//td[img[@alt='Infinity']]");
    By callsOutsideLatviaElement = By.xpath("//td[img[@alt='Infinity']]");
    By smsInLatviaElement = By.xpath("//td[img[@alt='Infinity']]");
    By smsInEuropeElement = By.xpath("//td[img[@alt='Infinity']]");
    By internetInLatviaElement = By.xpath("//td[img[@alt='Infinity']]");
    By internetInEuropeElement = By.xpath("//td[text()='20 GB']");

    public UserTariffsPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void viewingInformationAboutTariffs() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement servicesButton = wait.until(ExpectedConditions.elementToBeClickable(servicesButtonElement));
        actions.moveToElement(servicesButton).click().build().perform();

        WebElement showMoreButton = wait.until(ExpectedConditions.elementToBeClickable(showMoreButtonElement));
        actions.moveToElement(showMoreButton).click().build().perform();

        WebElement tariffPlanPrice = wait.until(ExpectedConditions.presenceOfElementLocated(tariffPlanPriceElement));
        js.executeScript("arguments[0].scrollIntoView(true);", tariffPlanPrice);

        WebElement callsInLatvia = wait.until(ExpectedConditions.presenceOfElementLocated(callsInLatviaElement));
        WebElement callsOutsideLatvia = wait.until(ExpectedConditions.presenceOfElementLocated(callsOutsideLatviaElement));
        WebElement smsInLatvia = wait.until(ExpectedConditions.presenceOfElementLocated(smsInLatviaElement));
        WebElement smsInEurope = wait.until(ExpectedConditions.presenceOfElementLocated(smsInEuropeElement));
        WebElement internetInLatvia = wait.until(ExpectedConditions.presenceOfElementLocated(internetInLatviaElement));
        WebElement internetInEurope = wait.until(ExpectedConditions.presenceOfElementLocated(internetInEuropeElement));

        String callsInLatviaValue = callsInLatvia.findElement(By.xpath(".//img")).getAttribute("alt");
        String callsOutsideLatviaValue = callsOutsideLatvia.findElement(By.xpath(".//img")).getAttribute("alt");
        String smsInLatviaValue = smsInLatvia.findElement(By.xpath(".//img")).getAttribute("alt");
        String smsInEuropeValue = smsInEurope.findElement(By.xpath(".//img")).getAttribute("alt");
        String internetInLatviaValue = internetInLatvia.findElement(By.xpath(".//img")).getAttribute("alt");
        String internetInEuropeValue = internetInEurope.getText();

        Assert.assertEquals(callsInLatviaValue, "Infinity", "Calls in Latvia value is not 'Infinity'. Actual: " + callsInLatviaValue);
        Assert.assertEquals(callsOutsideLatviaValue, "Infinity", "Calls outside Latvia value is not 'Infinity'. Actual: " + callsOutsideLatviaValue);
        Assert.assertEquals(smsInLatviaValue, "Infinity", "SMS in Latvia value is not 'Infinity'. Actual: " + smsInLatviaValue);
        Assert.assertEquals(smsInEuropeValue, "Infinity", "SMS in Europe value is not 'Infinity'. Actual: " + smsInEuropeValue);
        Assert.assertEquals(internetInLatviaValue, "Infinity", "Internet in Latvia value is not 'Infinity'. Actual: " + internetInLatviaValue);
        Assert.assertEquals(internetInEuropeValue, "20 GB", "Internet in Europe value is not '20 GB'. Actual: " + internetInEuropeValue);

        System.out.println("All assertions passed.");
    }
}