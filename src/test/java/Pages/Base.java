package Pages;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import  Utilities.*;

public class Base {

    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 5);


    protected void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void sendKeysToElement(WebElement element, String key) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(key);
    }

    protected String getTextOfElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    protected void textToBePresent(WebElement element, String text){
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    protected void textToBeinvisible(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }


    public String textToBeString(WebElement element, String text){
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
        return getTextOfElement(element);

    }


    public <T> void waitFor(ExpectedCondition<T> condition) {
        waitFor(condition, condition.toString());
    }

    public <T> void waitFor(ExpectedCondition<T> condition, String errorMessage) {
        try {
            wait.until(condition);
        } catch (TimeoutException e) {
            Assert.fail(errorMessage);
        }
    }
}
