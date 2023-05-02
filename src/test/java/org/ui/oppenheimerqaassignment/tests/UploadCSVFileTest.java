package org.ui.oppenheimerqaassignment.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class UploadCSVFileTest extends BaseTest{

    String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\working-class-hero-list.csv";


    @Test(description = "Verify that Upload CSV has a placeholder text")
    public void checkPlaceholderTextTest(){
        Assert.assertEquals(pages().getDocumentPage().getPlaceholderTest(),"Choose file");
    }

    @Test(description = "Verify that user can upload a CSV file successfully")
    public void uploadCSVFileTest(){
        pages().getDocumentPage()
                .selectCSVFile(filePath);

    }


}
