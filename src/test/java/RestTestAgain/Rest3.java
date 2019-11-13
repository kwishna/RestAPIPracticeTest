package RestTestAgain;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
/**
 * https://httpbin.org/post
 * 
 * http://services.groupkt.com/country/get/all
 * http://services.groupkt.com/country/get/iso2code/IN
 * http://www.thomas-bayer.com/sqlrest/CUSTOMER/3/
 * http://www.thomas-bayer.com/sqlrest/CUSTOMER/
 * 
 * http://www.omdbapi.com/?t=Spiderman&y=&plot=short&r=json
 *
 * http://api.plos.org/search?q=title:DNA
 * 
 * https://semaphoreci.com/community/tutorials/testing-rest-endpoints-using-rest-assured ::: Must Read
 */
public class Rest3 {
	
	@Test
	public void get_m1() {
		
//		given(). // Given : Task Which Is Performed Before Sending Request
//		when().	 // When  : Task Performed While Sending Request
//		get(). // get, post, delete, update etc are the Request Method
//		then(); // Task Performed After Getting Response.
		
		//http://api.plos.org/search?q=title:"Drosophila" AND body:"RNA"&fl=id,abstract
		
		given().param("t", "Spiderman")
				.param("y", "")
				.param("plot", "short")
				.param("r", "json")
				
				.when()
				.get("http://www.omdbapi.com/")
				
				.then()
				.statusCode(401);
				
	}
	
	
	@Test
	public void get_m2() {

		given().param("q", "title:DNA")
		
				.when()
				.get("http://api.plos.org/search")
				
				.then()
				.statusCode(200);
				
	}
	
	@Test
	public void get_m3() {
		
		/**
		 * Start A Server On A JSON File : json-server --watch db.json
		 * It Will Start A Server At localhost:3000
		 */

		given().param("post", "1") // As Of Now, param Can Be Used Only With get() Request. As For Current Understanding.
		
				.when()
				.get("http://localhost:3000/posts")  // This Will Add "/1" After The get() URL
				
				.then()
				.statusCode(200);
				
	}
	
	@Test
	public void post_m1() {
		
		Response res = given()
							.contentType(ContentType.JSON)
							.body("{\"id\": 8,  \"title\": \"json-server\",  \"author\": \"typicode\"}") //POST & PUT Requires Body 
							.when()
							.post("http://localhost:3000/posts");
		
		Assert.assertEquals(res.getStatusCode(), 201);
		System.out.println(res.asString());
	}
	
	@Test
	public void post_m2() {
		
		given()
			.contentType(ContentType.JSON)
			.body("{\"id\": 3,  \"title\": \"json-server\",  \"author\": \"typicode\"}") //POST & PUT Requires Body
			.when()
			.post("http://localhost:3000/posts")
			.then()
			.contentType(ContentType.JSON)
			.statusCode(201);

	}
	
	@Test
	public void post_m3() {
		
		given()
			.contentType(ContentType.JSON)
			.body("{\"id\": 6,  \"title\": \"json-server\",  \"author\": \"typicode\"}") //POST & PUT Requires Body
			.when()
			.post("http://localhost:3000/posts")
			.then()
			.contentType(ContentType.JSON)
			.statusCode(201);

	}
	
	@Test
	public void post_m4() {
		
		RandomPost r = new RandomPost();
		r.setId(5);
		r.setAuthor("Krishna Usinng Class");
		r.setTitle("Class Object");
		
		given()
				.contentType(ContentType.JSON)
				.body(r)  //POST & PUT Requires Body
				.when()
				.post("http://localhost:3000/posts")
				.then()
				.statusCode(201);

	}
	
	@Test
	public void put_m1() { // PUT & PATCH Is Used To Update The Resource On Server
		
		RandomPost r2 = new RandomPost();
		r2.setId(4);
		r2.setAuthor("Updated Krishna Using Put");
		r2.setTitle("Class Object");
		
		given()
				.contentType(ContentType.JSON)
				.body(r2)  //POST & PUT Requires Body
				.when()
				.put("http://localhost:3000/posts/4")
				.then()
				.statusCode(200);

	}
	
	@Test
	public void patch_m1() { // PUT & PATCH Is Used To Update The Resource On Server
		
		int i = 8;
		
		RandomPost r3 = new RandomPost();
		r3.setAuthor("Updated Krishna Using Patch");
		
		given()
				.contentType(ContentType.JSON)
				.body(r3)  //POST & PUT Requires Body
				.when()
				.patch("http://localhost:3000/posts/"+i)
				.then()
				.statusCode(200);

	}
	
	@Test
	public void delete_m1() { // PUT & PATCH Is Used To Update The Resource On Server
		
		int i = 3;
		
		given()
				.contentType(ContentType.JSON)
				.when()
				.delete("http://localhost:3000/posts/"+i)
				.then()
				.statusCode(200);

	}
	
}
