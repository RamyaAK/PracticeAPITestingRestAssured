package unitTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PatchRequest {
    HashMap<String,String> map = new HashMap<String,String>();

    @BeforeTest
    public void prepareTestData(){
        map.put("name","morpheus");
        map.put("job","Doctor");// only updating the Job value of the Resource(Patching)

        RestAssured.baseURI="https://reqres.in/";
        RestAssured.basePath="/api/users/2";
    }

    @Test
    public void PatchTest(){
        Response response = given()
                .contentType("application/json")
                .body(map)
                .when()
                .patch()
                .then()
                .log().all()
                .extract().response();

        String jsonString = response.asPrettyString();
        System.out.println("jsonString:"+jsonString);

    }
}
