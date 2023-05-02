package org.ui.oppenheimerqaassignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.ui.oppenheimerqaassignment.common.BasePage;

public class CashDispensedPage extends BasePage {

    public CashDispensedPage(WebDriver driver) {
        super(driver);
    }

    public String getPageDescription(){
        String pageDesc = getText(By.xpath("//div[@class='display-4 font-weight-bold']"));
        return pageDesc;
    }
}
