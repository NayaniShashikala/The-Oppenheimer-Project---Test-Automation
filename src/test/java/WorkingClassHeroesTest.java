import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import models.InsertMultiplePersons;
import models.InsertSinglePerson;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class WorkingClassHeroesTest {

//    private String natId;
    RequestSpecification requestSpecification;

    @BeforeSuite
    public void beforeSuite(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri("http://localhost:8080");
        requestSpecification = requestSpecBuilder.build();

    }

    @Test (description = "Verify that a clerk should be able to insert a single employee to the system")
    public void addSingleWorkingClassHero(){
        Random random = new Random();
        String birthday = "12051969";
        String gender = "F";
        String name = "henver deker";
        String natid = String.format("%03d",random.nextInt(1000))+"-"+String.format("%07d", random.nextInt(100000));
        String salary = "30000";
        String tax="1000";
        InsertSinglePerson insertSinglePerson = new InsertSinglePerson(birthday,gender,name, natid,salary, tax);
        insertSinglePerson.setRequestModel();
        ValidatableResponse response = given()
                .spec(requestSpecification)
                .body(insertSinglePerson.getRequestModel().toString()).log().all()
                .post("calculator/insert")
                .then().log().all();
        String responseBody = response.extract().body().jsonPath().toString();
        System.out.println(responseBody);
        Assert.assertEquals(response.extract().statusCode(), 202);
        Assert.assertEquals(response.extract().asString(), "Alright");
    }

    @Test(description = "Verify that a clerk should be able to insert multiple employees to the system")
    public void addMultipleWorkingClassHeroes() {
        InsertMultiplePersons insertMultiplePersons = new InsertMultiplePersons();
        insertMultiplePersons.setRequestModel();

        ValidatableResponse response = given()
                .spec(requestSpecification)
                .body(insertMultiplePersons.getRequestModel().toString()).log().all()
                .post("calculator/insertMultiple")
                .then().log().all();
        String responseBody = response.extract().body().jsonPath().toString();
        System.out.println(responseBody);
        Assert.assertEquals(response.extract().statusCode(), 202);
        Assert.assertEquals(response.extract().body().jsonPath().get("[0].name"),"bonny bennet");
//        Assert.assertEquals(response.extract().asString(), "Alright");
    }
}
