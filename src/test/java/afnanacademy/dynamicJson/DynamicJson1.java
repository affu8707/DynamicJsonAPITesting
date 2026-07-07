package afnanacademy.dynamicJson;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DynamicDataAPI.DynamicAPI.payload;

public class DynamicJson1 {

	@Test(dataProvider = "BooksData")
	public void AddBook(String isbn, String aisle) {
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().header("Content-Type", "application/json").body(payload.Addbook(isbn, aisle)).when()
				.post("/Library/Addbook.php").then().assertThat().statusCode(200).extract().response().asString();

		JsonPath js = new JsonPath(response);
		String id = js.get("ID");

		System.out.println(id);

		// delete book item

		given().header("Content-Type", "application/json").body(payload.DeleteBook(id)).when()
				.post("/Library/DeleteBook.php").then().assertThat().statusCode(200);

	}

	// Testng data provider annotation
	@DataProvider(name = "BooksData")
	public Object[][] getData() {
		return new Object[][] { { "ojtreds", "9363" }, { "jhhjsd", "9864" }, { "rtfdssf", "4321" } };

	}

}
