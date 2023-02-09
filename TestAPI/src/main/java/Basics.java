import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import static io.restassured.RestAssured.*;

public class Basics {
    @Test

    public void Basics(){
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(payload.Addplace())
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).extract().response().asPrettyString();

        JsonPath js= new JsonPath(response);
        String place_id = js.get("place_id");
        System.out.printf(place_id);


    }


}
