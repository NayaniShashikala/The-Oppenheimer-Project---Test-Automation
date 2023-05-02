package org.ui.oppenheimerqaassignment.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VisitSwaggerTest extends BaseTest {

    @Test(description = "Verify that The text on the Visit Swagger button is mentioned correctly")
    public void checkVisitSwaggerTextTest(){
        Assert.assertEquals(pages().getVisitSwaggerPage().getVisitSwaggerButtonText(), "Visit Swagger");
    }

    @Test (description = "Verify that clicking on 'Visit Swagger' button will directs the user to the correct page.")
    public void CheckCorrectNavigationTest (){
        pages().getVisitSwaggerPage().clickVisitSwaggerButton();
        Assert.assertEquals(pages().getSwaggerPage().getPageTitle(),"Api Documentation");
    }
}
