package unitTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequest {
    @Test
    public void deleteTest(){
        given()
                .contentType("application/json")
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204)
                .statusLine("HTTP/1.1 204 No Content");
    }
}
