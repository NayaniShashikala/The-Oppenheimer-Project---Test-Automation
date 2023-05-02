package org.ui.oppenheimerqaassignment.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DispenseTaxTest extends BaseTest {

    @Test (description = "Verify that The text on the button is mentioned correctly")
    public void checkDispenseButtonTextTest(){
        Assert.assertEquals(pages().getDispenseTaxPage().getDispenseButtonText(), "Dispense Now");
    }

    @Test (description = "Check that the button is red colour")
    public void checkColorTest (){
        Assert.assertEquals(pages().getDispenseTaxPage().getButtonCSSClass(),"btn btn-danger btn-block");
    }

    @Test (description = "Verify that clicking on 'Dispense Now' button will directs the user to the correct page.")
    public void CheckCorrectNavigationTest (){
        pages().getDispenseTaxPage().clickDispenseButton();
        Assert.assertEquals(pages().getCashDispensedPage().getPageDescription(),"Cash dispensed");
    }






}
