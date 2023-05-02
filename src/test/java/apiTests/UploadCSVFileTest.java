import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class UploadCSVFileTest {
    RequestSpecification requestSpecification;

    @BeforeSuite
    public void beforeSuite() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri("http://localhost:8080");
        requestSpecification = requestSpecBuilder.build();
    }

//    //couldn't complete this
//    @Test(description = "Verify that user can upload the CSV file successfully.")
//    public  void insertCSVFileTest (){
//        File file = new File("System.getProperty(\"user.dir\") + \"\\src\\main\\resources\\testHeros.csv\");");
//
//        ValidatableResponse response =given()
//                .spec(requestSpecification)
//                .post("calculator/uploadLargeFileForInsertionToDatabase")
//                .then().log().all();
//
//        Assert.assertEquals(response.extract().statusCode(), 200);
//    }
}
