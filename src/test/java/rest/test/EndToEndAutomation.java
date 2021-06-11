package rest.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import restandtest.CreatePost;

/*
 * 1) Create A Response Using A JSON Object
 * -> Validate The Response Code. Store The ID In a Variable
 * 
 *2) Validate Resource Created In step 1 using id
 *-> Validate its title And Author
 *
 *3) Update The Resorce Created In Step1 Using PUT
 *-> Validate Updated Title And Author
 *
 *4) Delete The Resource Created In Step1 Using PUT
 *->Validate Resource Deleted
 */
public class EndToEndAutomation {

	@Test
	public void CreateJSON(){
		CreatePost p = new CreatePost(); // POJO Class
		p.setId(1);
		p.setTitle("Creating");
		p.setAuthor("AB D");
		
		RestAssured r = new RestAssured();
	
		/*Creating & Printing
	 	Response res = r.given()
							.contentType(ContentType.JSON)
							.body(p)
			
							.when()
							.post("http://localhost:3000/posts");
		
		System.out.println(res.asString());
	*/	
		
	// To Validate We Need To Take The Response In A ValidateResponse Object.
		ValidatableResponse res = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(p) // p is Object Of CreatePost class With Id, title & author set.

				.when()
				.post("http://localhost:3000/posts")
				
				.then()
				.contentType(ContentType.JSON);

				int responseId = res.extract().path("id");
				int actualStatus = res.extract().response().getStatusCode();
				
				Assert.assertEquals(actualStatus, 200);
			
	}
}