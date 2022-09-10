package unitTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostRequest {

    HashMap<String,String> map = new HashMap<String, String>();
    @BeforeTest
    public void prepareTestDataForTest(){
        map.put("name","John");
        map.put("job","Carpenter");
        System.out.println(map);
        RestAssured.baseURI="https://reqres.in";
        RestAssured.basePath="api/users";
    }
    @Test
    public void postTest(){
       Response response= given()
               .contentType("application/json")
                .body(map)
                .when()
                .post()
                .then()
                .statusCode(201)
                .statusLine("HTTP/1.1 201 Created")
                .log().all().extract().response();

       String jsonResponse = response.asString();
        Assert.assertEquals(jsonResponse.contains("John"),true);
        Assert.assertEquals(jsonResponse.contains("Carpenter"),true);

    }

}
