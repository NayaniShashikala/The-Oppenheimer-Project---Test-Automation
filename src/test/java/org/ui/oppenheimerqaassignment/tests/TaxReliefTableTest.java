package org.ui.oppenheimerqaassignment.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaxReliefTableTest extends BaseTest{

    @Test(description = "Verify that The text on the 'TaxRelief' button is mentioned correctly")
    public void checkTaxReliefTextTest(){
        Assert.assertEquals(pages().getTaxReliefTablePage().getTaxReliefButtonText(), "Refresh Tax Relief Table");
    }

    @Test (description = "Verify that the Table caption is written correctly.")
    public void CheckCorrectCaptionOfTheTableTest (){
        Assert.assertEquals(pages().getTaxReliefTablePage().getCaptionOfTheTaxTable(),"List of working class heroes and their tax relief");
    }

    @Test (description = "Verify that the Table raw count is equals to the to be dispensed working class heros count.")
    public void CheckCountOFToBeDispensedWorkingClassHeroTest (){

        // user should have given the count of the list to the end point -> calculator/insertRandomToDatabaseForNoReason?count=100, before refresh the table.
        String text = pages().getTaxReliefTablePage().summaryParagraph();
        String[] words = text.split("\\s+");
        String count = "";
        for (String word : words) {
            if (word.matches("\\d+")) { // check if word contains only digits
                count = word;
                break; // found the count, exit loop
            }
        } System.out.println("List size is "+count);
        Assert.assertEquals(count, pages().getTaxReliefTablePage().checkTaxReliefListCount());
    }

//    @Test (description = "Verify that the Table total relief summation amount is equals to the total dispensed amount.")
//    public void CheckTotalAmountOfDispenseTest (){
//
//        // user should have given the count of the list to the end point -> calculator/insertRandomToDatabaseForNoReason?count=100, before refresh the table.
//        String text = pages().getTaxReliefTablePage().summaryParagraph();
//        Pattern pattern = Pattern.compile("£([\\d,]+\\.\\d+)");
//        Matcher matcher = pattern.matcher(text);
//        String countWithSymbol="";
//
//        if (matcher.find()) {
//            countWithSymbol = matcher.group(0);
//             // Output: £5599626.60
//        }System.out.println(countWithSymbol);
//        Assert.assertEquals(countWithSymbol, "£"+pages().getTaxReliefTablePage().checkTotalReliefAmount());
//    }




}
