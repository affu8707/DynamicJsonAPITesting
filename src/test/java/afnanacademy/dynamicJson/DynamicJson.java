package afnanacademy.dynamicJson;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import DynamicDataAPI.DynamicAPI.payload;

public class DynamicJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// post get the id from add library

		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().header("Content-Type", "application/json")
				.body(payload.Addbook("asdfe","6454")).when()
				.post("/Library/Addbook.php").then().assertThat().statusCode(200).extract().response().asString();

		JsonPath js = new JsonPath(response);

		String id = js.get("ID");

		System.out.println(id);
		
		

	}

}
