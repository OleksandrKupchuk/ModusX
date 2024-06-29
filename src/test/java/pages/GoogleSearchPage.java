package pages;

import factory.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.junit.jupiter.api.Assertions.*;

public class GoogleSearchPage {
    private AppiumDriver driver;
    private By searchField = By.name("q");
    private By resultSection = By.xpath("//div[@class='MjjYud']");
    public GoogleSearchPage(){
        driver = DriverFactory.getInstance().getDriver();
        driver.get("https://www.google.com/");
    }

    public GoogleSearchPage setSearch(String value){
        driver.findElement(searchField).sendKeys(value);
        return this;
    }

    public GoogleSearchPage clickSearchButton(){
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        return this;
    }

    public GoogleSearchPage assertContainsSearchResult(String expectedValue){
        String actualValue = driver.findElement(resultSection).getText();
        assertTrue(actualValue.contains(expectedValue));
        return this;
    }
}
