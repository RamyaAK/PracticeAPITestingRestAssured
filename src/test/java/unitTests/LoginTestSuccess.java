package unitTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class LoginTestSuccess {

    HashMap<String,String> map = new HashMap<String,String>();

    @BeforeTest
    public void prepareTestData(){
        map.put("email","eve.holt@reqres.in");
        map.put("password","cityslicka");

        RestAssured.baseURI="https://reqres.in/";
        RestAssured.basePath="/api/login";
    }

    @Test
    public void successfulLoginTest(){
       Response response = given()
                .contentType("application/json")
               .body(map)
               .when()
               .post()
               .then()
               .log().all()
               .extract().response();

       String jsonString = response.asPrettyString();

        System.out.println(jsonString);

        Assert.assertEquals(response.statusCode(),200);
    }
}
