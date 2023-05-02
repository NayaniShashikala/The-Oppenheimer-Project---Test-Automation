package org.ui.oppenheimerqaassignment.pages;

import lombok.var;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.ui.oppenheimerqaassignment.common.BasePage;

import java.util.List;

public class TaxReliefTablePage extends BasePage {

    public TaxReliefTablePage(WebDriver driver) {
        super(driver);
    }

    public String getTaxReliefButtonText(){
        String buttonText =  getText(By.xpath("(//button[@type='button'])[1]"));
        return buttonText;
    }

    public String getCaptionOfTheTaxTable(){
        String caption = getText(By.tagName("caption"));
        return caption;
    }

    public String checkTaxReliefListCount (){
        click(By.xpath("(//button[@type='button'])[1]"));
        String tableRows = String.valueOf(getElements(By.xpath("//table/tbody/tr")).size());
        return tableRows;
    }

    public String summaryParagraph(){
        String summary = getText(By.xpath("(//p[@class='lead'])[3]"));
        return summary;
    }

//    public Double checkTotalReliefAmount (){
//        click(By.xpath("(//button[@type='button'])[1]"));
//        List<WebElement> rows = getElements(By.xpath("//table/tbody/tr"));
//        double totalTaxRelief = 0.0;
//
//        // Loop through each row and get the tax relief amount from the second column
//        for (WebElement row : rows) {
//            WebElement taxReliefElement = getElement(By.xpath("//table/tbody/tr/td[1]/following-sibling::td[1]"));
//            String taxReliefText = taxReliefElement.getText();
//
//            // Remove any non-numeric characters from the tax relief amount
//            double taxRelief = Double.parseDouble(taxReliefText.replaceAll("[^\\d.]", ""));
//
//            // Add the tax relief amount to the total
//            totalTaxRelief += taxRelief;
//        }
//
//        return totalTaxRelief;
//    }

}
