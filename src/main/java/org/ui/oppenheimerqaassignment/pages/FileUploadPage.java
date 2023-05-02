package org.ui.oppenheimerqaassignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.ui.oppenheimerqaassignment.common.BasePage;

import java.time.Duration;

public class FileUploadPage extends BasePage {

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
//    WebElement inputField = getElement(By.xpath("//input[@class='custom-file-input']"));

    public void uploadFile(String absolutePathOfFile){

        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='custom-file-input']")));
        input.sendKeys(absolutePathOfFile);

    }


}
