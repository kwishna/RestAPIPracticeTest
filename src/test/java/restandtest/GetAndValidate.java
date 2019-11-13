package restandtest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

/*
 * Get JSON Data & Validate The Data Using JSON Path
 * Site To Practice & Learn JSON Path https://www.jsonpath.com
 */

public class GetAndValidate {
	
	Response res;
	
	@Test(enabled=false)
	public void getJSON(){
		
		Response res = given().get("http://localhost:3000/posts/");
		System.out.println(res.toString());
	}
	
	@Test(enabled=false)
	public void validateJSON(){
		
	int i=2;
	String author = given()
						.get("http://localhost:3000/posts/"+i)
						.then()
						.contentType(ContentType.JSON)
						.extract()
						.path("author");
		
	Assert.assertEquals("AB D By PUT", author.toString());
	}
	
	@Test
	public void ValidateMultiple(){
		ValidatableResponse res = when()
				.get("http://localhost:3000/posts/1")
				.then()
				.contentType(ContentType.JSON);
		
		String title = res.extract().path("path");
		String author = res.extract().path("author");
		int actualId = res.extract().path("id");
		
		Assert.assertEquals(author, "typicode");
		Assert.assertEquals(actualId, 1);
	}
}