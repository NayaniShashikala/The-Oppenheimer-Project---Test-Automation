package org.ui.oppenheimerqaassignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.ui.oppenheimerqaassignment.common.BasePage;

public class VisitSwaggerPage extends BasePage {

    public VisitSwaggerPage(WebDriver driver) {
        super(driver);
    }

    public String getVisitSwaggerButtonText(){
        String buttonText =  getText(By.xpath("(//a[@href='/swagger-ui.html'])[1]"));
        return buttonText;

    }

    public void clickVisitSwaggerButton(){
        click(By.xpath("(//a[@href='/swagger-ui.html'])[1]"));
    }
}
