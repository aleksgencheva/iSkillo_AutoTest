package iSkillo_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected final WebDriver driver;
    protected WebDriverWait smallWait;
    protected WebDriverWait mediumWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        smallWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        mediumWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Desired element to be clickable.
    protected void clickElement(WebElement element) {
        smallWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    //To insert desired text.
    protected void enterText(WebElement element, String text) {
        smallWait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    //Verifying url.
    public void verifyUrl(String url) {
        mediumWait.until(ExpectedConditions.urlToBe(url));
    }

    //Verifying content of url.
    public void verifyUrlContains(String url) {
        mediumWait.until(ExpectedConditions.urlContains(url));
    }

    //Visibility of text.
    public String getElementText(WebElement element) {
        smallWait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
}
