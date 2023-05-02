package org.ui.oppenheimerqaassignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.ui.oppenheimerqaassignment.common.BasePage;

public class SwaggerPage extends BasePage {

    public SwaggerPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle(){
        String title = getText(By.xpath("//div[@class='description']//p"));
        return title;
    }
}
