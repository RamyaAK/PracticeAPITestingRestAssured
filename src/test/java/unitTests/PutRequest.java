package unitTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PutRequest {
    HashMap<String,String> map = new HashMap<String,String>();

    @BeforeTest
    public void prepareTestData(){
        map.put("name","morpheus");
        map.put("job","zion resident");

        RestAssured.baseURI="https://reqres.in/";
        RestAssured.basePath="api/users/2";
    }

    @Test
    public void putTest(){
        Response response = given()
                .contentType("application/json")
                .body(map)
                .when()
                .put()
                .then()
                .log().all()
                .extract().response();

        String jsonString = response.asString();
        System.out.println(jsonString);

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.statusLine(),"HTTP/1.1 200 OK");

    }
}
