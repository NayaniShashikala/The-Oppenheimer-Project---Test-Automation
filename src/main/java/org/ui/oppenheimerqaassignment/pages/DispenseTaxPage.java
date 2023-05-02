package org.ui.oppenheimerqaassignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.ui.oppenheimerqaassignment.common.BasePage;

public class DispenseTaxPage extends BasePage {
    public DispenseTaxPage(WebDriver driver) {
        super(driver);
    }

    public String getDispenseButtonText(){
      String buttonText =  getText(By.xpath("//a[@href='dispense']"));
      return buttonText;

    }

    public void clickDispenseButton(){
        click(By.xpath("//a[@href='dispense']"));
    }

    public String getButtonCSSClass (){
       String className = getElement(By.xpath("//a[@href='dispense']")).getAttribute("class");
       return className;
    }


}
