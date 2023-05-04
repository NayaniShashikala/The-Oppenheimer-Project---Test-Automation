package apiTests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import models.InsertSinglePerson;
import models.helper.TaxCalculation;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TaxRelieveTest {
    RequestSpecification requestSpecification;

    @BeforeSuite
    public void beforeSuite() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri("http://localhost:8080");
        requestSpecification = requestSpecBuilder.build();
    }

    @Test (description = "verify that user can decide the count of the tax relief list")
    public  void setListSizeTest (){
        int count = 100;
        ValidatableResponse response =given()
                .spec(requestSpecification)
                .queryParam("count",count)
                .post("calculator/insertRandomToDatabaseForNoReason")
                .then().log().all();

        Assert.assertEquals(response.extract().statusCode(), 200);
        Assert.assertEquals(response.extract().asString(), "Successfully inserted "+count);
    }

    @Test(description = "Verify that Bookkeeper can see the tax relief list ") //can add if we want ->(dependsOnMethods = "setListSizeTest")
    public void getAllTaxReliefListTest() {
        ValidatableResponse response = given()
                .spec(requestSpecification)
                .get("calculator/taxRelief")
                .then().log().all();
        Assert.assertEquals(response.extract().statusCode(), 200);
        Assert.assertEquals(response.extract().jsonPath().getList("").size(),100);
        Assert.assertEquals(response.extract().body().jsonPath().get("[0].natid"), "884-$$$$$$$");
        Assert.assertEquals(response.extract().body().jsonPath().get("[0].name"), "Esperanza Bechtelar");
        Assert.assertEquals(response.extract().body().jsonPath().get("[0].relief"), "54715.00");
    }

    @Test (description = "Verify that the 'natid' field of each record in the response is masked from the 5th character " +
            "onwards with a dollar sign '$'")
    public void CheckNatIdMaskingTest(){
        ValidatableResponse response = given().spec(requestSpecification)
                .get("calculator/taxRelief").then().log().all();

        String responseBody = response.extract().body().asString();
        String[] records = responseBody.split("\\{\\s*\"natid\"");
        for (int i = 1; i < records.length; i++) {
            String natid = records[i].substring(6, 13); // get the natid value from the response
            System.out.println("natid is = "+natid);
            Assert.assertEquals(natid, "$$$$$$$");
        }
    }

    @Test(description = "Verify the Computation of Tax Relief Amount is correct")
    public void checkComputationOfTaxReliefTest () {

        String birthday = "12021998";
        Boolean male = false;
        String gender = "F";
        String salary = "10500.00";
        String tax = "725.757";
        String natid = "123-4567891";

        InsertSinglePerson insertSinglePerson = new InsertSinglePerson(birthday, gender, "klause",
                natid, salary, tax);
        insertSinglePerson.setRequestModel();
        ValidatableResponse response = given()
                .spec(requestSpecification)
                .body(insertSinglePerson.getRequestModel().toString()).log().all()
                .post("calculator/insert")
                .then().log().all();

        ValidatableResponse response1 = given()
                .spec(requestSpecification)
                .get("calculator/taxRelief")
                .then().log().all();


        int size = response1.extract().jsonPath().getList("").size();
        JsonPath jsonPath = response1.extract().jsonPath();

        TaxCalculation taxCalculation = new TaxCalculation();
        Double reliefAmount = taxCalculation.getTaxReliefAmount(Double.parseDouble(salary), Double.parseDouble(tax), birthday, male);

        System.out.println("Amount = " + jsonPath.get("[" + (size - 1) + "].relief").toString());

        /* max ->> truncate to two decimal numbers ->
        actual value (10500-725.357)*0.8= 7819.7144.
        Expected one is 7819.71 -->normal grounding 7820.00

         min--> truncate to two decimal numbers ->
         actual value (10500-725.757)*0.8= 7819.3944.
         Expected one is 7819.39 -->normal grounding 7819.00 */

        // check-truncate to two decimal numbers
        Assert.assertEquals(jsonPath.get("[" + (size - 1) + "].relief").toString(), reliefAmount); // fail
    }

    @Test (description = "Check for normal rounding")
    public void checkNormalRoudingTest(){
        String birthday = "12021998";
        String gender = "f";
        Boolean male = false;
        String salary= "10500.00";
        String tax = "725.757";
        String natid = "123-4567891";

        InsertSinglePerson insertSinglePerson = new InsertSinglePerson(birthday,gender,"klause",
                natid,salary,tax);
        insertSinglePerson.setRequestModel();
        ValidatableResponse response = given()
                .spec(requestSpecification)
                .body(insertSinglePerson.getRequestModel().toString()).log().all()
                .post("calculator/insert")
                .then().log().all();

        ValidatableResponse response1 = given()
                .spec(requestSpecification)
                .get("calculator/taxRelief")
                .then().log().all();


        int size = response1.extract().jsonPath().getList("").size();
        JsonPath jsonPath = response1.extract().jsonPath();

        TaxCalculation taxCalculation = new TaxCalculation();
        Double reliefAmount = taxCalculation.getTaxReliefAmount(Double.parseDouble(salary),Double.parseDouble(tax),birthday,male);

        System.out.println("Amount = " + jsonPath.get("[" + (size - 1) + "].relief").toString());

        /* max ->> truncate to two decimal numbers ->
        actual value (10500-725.357)*0.8= 7819.7144.
        Expected one is 7819.71 -->normal grounding 7820.00

         min--> truncate to two decimal numbers ->
         actual value (10500-725.757)*0.8= 7819.3944.
         Expected one is 7819.39 -->normal grounding 7819.00 */

        // convert to two decimals
        String formattedActual = String.format("%.2f", taxCalculation.applyNormalRoundRule(reliefAmount));

        // Test normal rounding --> only passed for min values
        Assert.assertEquals(jsonPath.get("[" + (size - 1) + "].relief").toString(),formattedActual);
    }


    @Test (description = "Verify the rule - amount is more than 0.00 but less than 50.00, the final tax relief amount should be 50.00 ")
    public  void checkLessThanFiftyRule(){
        String birthday = "12021998";
        String gender = "M";
        Boolean male = true;
        String salary= "750.00";
        String tax = "720.357";
        String natid = "123-4567891";

        InsertSinglePerson insertSinglePerson = new InsertSinglePerson(birthday,gender,"klause",
                natid,salary,tax);
        insertSinglePerson.setRequestModel();
        ValidatableResponse response = given()
                .spec(requestSpecification)
                .body(insertSinglePerson.getRequestModel().toString()).log().all()
                .post("calculator/insert")
                .then().log().all();

        ValidatableResponse response1 = given()
                .spec(requestSpecification)
                .get("calculator/taxRelief")
                .then().log().all();


        int size = response1.extract().jsonPath().getList("").size();
        JsonPath jsonPath = response1.extract().jsonPath();

        TaxCalculation taxCalculation = new TaxCalculation();
        Double reliefAmount = taxCalculation.getTaxReliefAmount(Double.parseDouble(salary),Double.parseDouble(tax),birthday,male);
        System.out.println("Actual tax relief amount = " + reliefAmount);

        //actual amount = 23.7144. should return 50.00
        Assert.assertEquals(jsonPath.get("[" + (size - 1) + "].relief").toString(),"50.00"); // passed

    }

    @Test (description = "Check that tax relief summary is shown correctly")
    public void getTaxReliefSummary(){
        ValidatableResponse response = given()
                .spec(requestSpecification)
                .get("calculator/taxReliefSummary")
                .then().log().all();

        String totalNo = response.extract().body().jsonPath().getString("totalWorkingClassHeroes");
        System.out.println("total count = " + totalNo);

        String totalAmount = response.extract().body().jsonPath().getString("totalTaxReliefAmount");
        System.out.println("total count = " + totalAmount);

        Assert.assertEquals(response.extract().statusCode(), 200);

    }
}
