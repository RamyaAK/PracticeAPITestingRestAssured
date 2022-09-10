package unitTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest {
    @Test
    public void getTest(){
        given()
                .get("https://reqres.in/api/users?page=2") //Get mtd call with response returned.
                .then()
                .statusCode(200)
                .body("data.id[1]",equalTo(8))
                .body("data.first_name",hasItems("Michael","Lindsay","Tobias","Byron"))
                .log().all();
    }
}
