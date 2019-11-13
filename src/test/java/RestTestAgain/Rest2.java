package RestTestAgain;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * We Have 2 Options :-
 * 1) Static Import
 * 2) BDD Options
 * 
 *
 */
public class Rest2 {

	// import static io.restassured.RestAssured.*;
	@Test
	public void m1() {
		
//		RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22"); // Without Static Import
		
		Response s = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22"); //After static Import
		
		System.out.println(s.asString());
		
	}
}
