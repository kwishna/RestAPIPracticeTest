package restandtest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * Start json-server
 */
public class RequestMethods {
	
	@Test(enabled=false)
	public void testPostMethod(){
		//For Adding Some Value Inside db.json
	Response res =	given()
						.contentType(ContentType.JSON)
						.body("{\"id\": 2, \"title\": \"json-server2\", \"author\": \"typicode\"}") //JSON That To Be Added Using POST Method. Escape Character Used
						.when()
						.post("http://localhost:3000/posts");
	
	System.out.println(res.asString());
			
	}
	
	@Test(enabled=false)
	public void testPostMethod2(){
		//For Adding Some Value Inside db.json Directly.
					given()
						.contentType(ContentType.JSON)
						.body("{\"id\": 3, \"title\": \"json-server1\", \"author\": \"typicode\"}") //JSON That To Be Added Using POST Method. Escape Character Used
						.when()
						.post("http://localhost:3000/posts")
						.then()
						.statusCode(201)
						.contentType(ContentType.JSON);
			
	}
	
	@Test(enabled=false)
	public void addDataUsingPOST(){
		CreatePost c = new CreatePost();
		c.setId(4);
		c.setTitle("Set Through Object");
		c.setAuthor("AB D");
		
		given()
			.contentType(ContentType.JSON)
			.body(c)
			.when()
			.post("http://localhost:3000/posts")
			.then()
			.statusCode(201)
			.contentType(ContentType.JSON);		
	}
	
	@Test(enabled=false)
	public void updateUsingPUT(){
		int i=2;
		CreatePost c1 = new CreatePost();
		c1.setId(i);
		c1.setTitle("json-server2");
		c1.setAuthor("AB D By PUT");
		
		given()
			.contentType(ContentType.JSON)
			.body(c1)
			.when()
			.put("http://localhost:3000/posts/"+i)
			.then()
			.statusCode(200)
			.contentType(ContentType.JSON);		
	}
	
	@Test(enabled=false)
	public void updateUsingPATCH(){
		int i = 4;
		CreatePost c2 = new CreatePost();
		c2.setTitle("AB D Once Again");
		
		given()
			.contentType(ContentType.JSON)
			.body(c2)
			.when()
			.patch("http://localhost:3000/posts/"+i)
			.then()
			.statusCode(200)
			.contentType(ContentType.JSON);
			
	}
	
	@Test(enabled=true)
	public void updateUsingDELETE(){
		int i = 4;
		
		given()
			.contentType(ContentType.JSON)
			.when()
			.delete("http://localhost:3000/posts/"+i)
			.then()
			.statusCode(200);		
	}
}
