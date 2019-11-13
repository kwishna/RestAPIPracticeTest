package restandtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredLearn {
	
	@Test(enabled=false)
	public void get_validation(){
		Response res = RestAssured.get("http://services.groupkt.com/country/get/iso2code/IN");
		System.out.println(res.asString());
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
	}

	@Test(enabled=false)
	public void get_validation2(){
		Response res = RestAssured.get("http://services.groupkt.com/country/get/all");
		System.out.println(res.contentType());
		Assert.assertEquals(res.contentType(), "application/json;charset=UTF-8");
	}
	
	@Test(enabled=true)
	public void get_validation3(){
		Response res = RestAssured.get("http://www.omdbapi.com/?t=Spiderman&y=&plot=short&r=json");
		System.out.println(res.asString()+"\n"+res.contentType()+"\n"+res.getStatusCode());
	}
	
	@Test(enabled=false)
	public void get_validation4(){
		
		RestAssured.given() //given() can be called directly without "RestAssured" Class If We Do Static Import
						.param("t", "Spiderman") //parameters To Be Passed Before The Request
						.param("y", "")
						.param("plot", "short")
						.param("r", "json")
					.when()
						.get("http://www.omdbapi.com/") //get the reponse
					.then()
						.statusCode(200); //then check the status code.
		
		/* For The Below Code To Be Valid : static import Is Required.
		 given() //given() can be called directly without "RestAssured" Class If We Do Static Import
						.param("t", "Spiderman") //parameters To Be Passed Before The Request
						.param("y", "")
						.param("plot", "short")
						.param("r", "json")
					.when()
						.get("http://www.omdbapi.com/") //get the reponse
					.then()
						.statusCode(200); //then check the status code.
		 */
		 
	}
}
