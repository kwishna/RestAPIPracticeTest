package RestTestAgain;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import io.restassured.RestAssured;
import io.restassured.response.Response;
/**
 * 
 * Free URI :-
 * http://services.groupkt.com/country/get/all
 * http://services.groupkt.com/country/get/iso2code/IN
 * http://www.thomas-bayer.com/sqlrest/CUSTOMER/3/
 * http://www.thomas-bayer.com/sqlrest/CUSTOMER/
 * http://www.omdbapi.com/?t=Spiderman&y=&plot=short&r=json
 *
 * https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22
 *
 * Must Read ::: https://semaphoreci.com/community/tutorials/testing-rest-endpoints-using-rest-assured
 *
 */
public class Rest1 {

	public static void main(String[] args) {

		Response res = RestAssured.get("http://services.groupkt.com/country/get/iso2code/IN");
		String s = res.asString();
//		System.out.println(s);
		
//		System.out.println(":::> "+res.getStatusCode());
//		System.out.println(":::> "+res.getContentType());
		
		
		//GET Request With Parameters	
//		Response res2 = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?"+
//										"q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
//		System.out.println(res2.asString()+" ::: "+res2.getStatusCode()+":::"+res2.prettyPrint());
//		Assert.assertEquals(res2.getStatusCode(), 200);
		
		
		
		
		try {
			URL u = new URL("https://github.com/basdijkstra/workshops/");
			HttpURLConnection http = (HttpURLConnection)u.openConnection();
		
			for(int i=0; i<8; i++) {
				System.out.println(http.getHeaderFieldKey(i)+" ::: "+http.getHeaderField(i));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}
