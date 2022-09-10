package unitTests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequest {
    @Test(description = "Verify delete Request")
    @Severity(SeverityLevel.MINOR)
    @Description("Delete Request")
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
