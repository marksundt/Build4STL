package dao;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class DaoStuff {
	
	public static String executePost(String targetURL, String token) {
		  HttpURLConnection connection = null;  
		  try {
		    //Create connection
		    URL url = new URL(targetURL);
		    connection = (HttpURLConnection)url.openConnection();
		    connection.setRequestMethod("PUT");
		    connection.setRequestProperty("Content-Type", 
		        "application/json");
		   // String body = "{\"name\":" + "\"" + name + "\"," + "\"email\":" + "\"" + email + "\"," + "\"phoneNumber\":" + "\"" + phoneNum + "\"}";
		    String body = "{\"userID_token\":" + "\"" + token + "\"}";
		    //System.out.println(body);
		    String basicAuth = "Basic YmE2YzEwM2YtOTY2ZS00Yzc2LWIwY2UtNjI0ODQ0YTI3OTU1Og==";
		    connection.setRequestProperty ("Authorization", basicAuth);
		    connection.setRequestProperty("Content-Length", 
		        Integer.toString(body.getBytes().length));
		    connection.setRequestProperty("Content-Language", "en-US");  

		    connection.setUseCaches(false);
		    connection.setDoOutput(true);
		    
		    //Send request
		    DataOutputStream wr = new DataOutputStream (
		        connection.getOutputStream());
		    wr.writeBytes(body);
		    wr.close();

		    //Get Response  
		    InputStream is = connection.getInputStream();
		    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		    StringBuilder response = new StringBuilder(); // or StringBuffer if not Java 5+ 
		    String line;
		    while((line = rd.readLine()) != null) {
		      response.append(line);
		      response.append('\r');
		    }
		    rd.close();
		    return response.toString();
		  } catch (Exception e) {
		    e.printStackTrace();
		    return null;
		  } finally {
		    if(connection != null) {
		      connection.disconnect(); 
		    }
		  }
		}


}
