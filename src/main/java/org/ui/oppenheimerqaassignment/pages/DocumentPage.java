package org.ui.oppenheimerqaassignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.ui.oppenheimerqaassignment.common.BasePage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.ui.oppenheimerqaassignment.util.Helper.getFileAbsolutePathFromTestResources;

public class DocumentPage extends BasePage {
    public DocumentPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

    public void selectCSVFile(String fileName){
        clickOnBrowseButton();
        setFilePath(fileName);
    }



    private void clickOnBrowseButton() {
        click(By.xpath("//label[contains(text(), 'Choose file')]"));
    }

    private void setFilePath(String fileName) {
        WebElement fileInput = getElement(By.cssSelector("custom-file-input"));
        fileInput.sendKeys(fileName);
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='custom-file-input']")));
        input.sendKeys(fileName);

        // Verify that the response status code is 200
//        try {
//            URL url = new URL(driver.getCurrentUrl());
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            int responseCode = connection.getResponseCode();
//            if (responseCode != 200) {
//                throw new AssertionError("File upload was not successful. Response status code was " + responseCode);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public String getDocumentName(){
        String docName = getText(By.className("custom-file-label"));
        return docName;
    }

    public String getPlaceholderTest(){
        String placeholder = getText(By.className("custom-file-label"));
        return placeholder;
    }









    //test 1
}
