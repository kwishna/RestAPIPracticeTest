package RestTestAgain;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class Rest4_Validate_Response {

	/**
	 * To Validate JSON Response
	 */
	
	@Test
	public void response_validate_m1() {
		
		Object s = given()
						.when()
						.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
						.then()
						.contentType(ContentType.JSON)
						.extract()
						.path("sys.country");
		
		System.out.println(s);
	}
	
	@Test
	public void response_validate_m2() {
		
		Object s = given()
						.when()
						.get("http://localhost:3000/posts/1")
						.then()
						.contentType(ContentType.JSON)
						.extract()
						.path("id");
		
		System.out.println(s);
	}
	
	@Test
	public void response_multiple_validate__m1() {
		
		ValidatableResponse response = given()
											.when()
											.get("http://localhost:3000/posts/1")
											.then()
											.contentType(ContentType.JSON);
						
		String title = response.extract().path("title");
		String author = response.extract().path("author");
		Integer id = response.extract().path("id");
		
		System.out.println("Title ::: "+title+" , "+"Author ::: "+author+" , "+"ID ::: "+id);
		
	}
}
