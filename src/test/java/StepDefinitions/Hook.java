package StepDefinitions;

import Utilities.Driver;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Hook{
    WebDriver driver = Driver.getDriver();

    @After
    public void ScreenshotForFailure(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
        }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    }
