package rest.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpNet {
	
	static String u = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
	static String google = "https://httpbin.org/post";
			
	public static void main(String[] args) throws IOException {
		
		URL url = new URL(u);
		HttpURLConnection http = (HttpURLConnection) url.openConnection(); // Instance Used To Start Connection
		http.setRequestMethod("GET");
		http.setRequestProperty("User-Agent", "Mozilla/5.0");

		http.connect(); // Start Connecting..
		
		BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
		String si = "";
		while((si=in.readLine())!=null) {
			System.out.println(si);
		}
		in.close();
		System.out.println("--------------------------------------------------------------------------------");
		URL url2 = new URL(google);
		HttpURLConnection http2 = (HttpURLConnection)url2.openConnection();
		http2.setRequestMethod("POST");
		http2.setRequestProperty("User-Agent", "Mozilla/5.0");
		http2.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		String param = "name=Jack&occupation=programmer";
		
		http2.setDoOutput(true);
		DataOutputStream d = new DataOutputStream(http2.getOutputStream());
		d.write(param.getBytes());
		d.flush();
		d.close();
		
		BufferedReader bi = new BufferedReader(new InputStreamReader(http2.getInputStream()));
		String ss = "";
		while((ss=bi.readLine())!=null) {
			System.out.println(ss);
		}
	}

}
