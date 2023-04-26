package common;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

public class BasePage {

    public final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilElementVisible(By by) {
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilElementInvisible(By by) {
        getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitUntilElementClickable(By by) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(by));
    }

    public void click(By by) {
        waitUntilElementClickable(by);
        Instant waitEndTime = Instant.now().plus(60, ChronoUnit.SECONDS);
        while (Instant.now().isBefore(waitEndTime)) {
            try {
                driver.findElement(by).click();
                return;
            } catch (ElementClickInterceptedException ignored) {
                System.out.println("ElementClickInterceptedException for the element " + by.toString());
            }
        }
    }

    public WebElement getElement(By by) {
        waitUntilElementVisible(by);
        return driver.findElement(by);
    }

    public List<WebElement> getElements(By by) {
        waitUntilElementVisible(by);
        return driver.findElements(by);
    }

    public void sendKeys(By by, String text) {
        waitUntilElementVisible(by);
        driver.findElement(by).sendKeys(text);
    }

    public String getText(By by) {
        String text = getElement(by).getText();
        getWebDriverWait().until((ExpectedCondition<Boolean>) driver -> !Objects.equals(text, "Loading.."));
        return text;
    }

    public WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void selectOptionByVisibleText(WebElement dropdownElement, String optionText) {
        new Select(dropdownElement).selectByVisibleText(optionText);
    }
}
