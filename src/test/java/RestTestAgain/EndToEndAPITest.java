package RestTestAgain;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

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
 *4) Delete The Resource Created In Step1 Using Delete
 *->Validate Resource Deleted
 */

public class EndToEndAPITest {
	
	
	static int id = 2;
	static String title = "End To End Title";
	static String author = "End To End Title";
	
	static int id1;
	
	@Test(priority=1)
	public void createResource() {

		RandomPost ra = new RandomPost(); // POJO
		ra.setId(id);
		ra.setTitle(title);
		ra.setAuthor(author);
		
		ValidatableResponse res1 = given()
										.when()
										.contentType(ContentType.JSON)
										.body(ra)
										.post("http://localhost:3000/posts")
										.then()
										.contentType(ContentType.JSON);
		
		int statusCode = res1.extract().statusCode();
		id1 = res1.extract().path("id");
		
		System.out.println(statusCode+" <--:::--> "+id1);
		Assert.assertEquals(id1, id);
	
		
		
		// 2nd Test Case *************************
	}
	
	@Test(priority=2)
	public void validate_get() {
		
		ValidatableResponse res2 = given()
										.param("posts", id1)
										.when()
										.get("http://localhost:3000/posts/"+id1)
										.then()
										.contentType(ContentType.JSON);;
		
		int statusC = res2.extract().statusCode();
		
		Assert.assertEquals(statusC, 200);
		
		int id2 = res2.extract().path("id");
		String title2 = res2.extract().path("title");
		String author2 = res2.extract().path("author");
		
		System.out.println(id2+" <--:::--> "+title2+" <--:::--> "+author2);
		
		Assert.assertEquals(id2, id);
		Assert.assertEquals(title2, title);
		Assert.assertEquals(author2, author);
	}	
		
		// Test Case 3 ***************************
	@Test(priority=3)
	public void validate_put() {	
		
		String authorx = "End To End Title Updated";
		
		RandomPost rax = new RandomPost();
		rax.setId(id);
		rax.setTitle(title);
		rax.setAuthor(authorx);
		
		
		ValidatableResponse res3 = given()
										.contentType(ContentType.JSON)
										.body(rax)
										.when()
										.put("http://localhost:3000/posts/"+id)
										.then()
										.contentType(ContentType.JSON);;
		
		int statusC1 = res3.extract().statusCode();
		System.out.println(statusC1);
		
		int id3 = res3.extract().path("id");
		String title3 = res3.extract().path("title");
		String author3 = res3.extract().path("author");

		System.out.println(id3+" <--:::--> "+title3+" <--:::--> "+author3);

		Assert.assertEquals(id3, id);
		Assert.assertEquals(title3, title);
		Assert.assertEquals(author3, authorx);
		
	}	
		// Test Case 4 ***************************
	@Test(priority=4)
	public void validate_delete() {
		
			ValidatableResponse res4 = given()
											.contentType(ContentType.JSON)
											.when()
											.delete("http://localhost:3000/posts/"+id)
											.then()
											.contentType(ContentType.JSON);;

			int statusC2 = res4.extract().statusCode();
			Assert.assertEquals(statusC2, 200);
		
	}
	
}
