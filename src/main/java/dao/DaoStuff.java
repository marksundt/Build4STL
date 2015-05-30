package dao;

import demo.domain.RedemptionCode;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class DaoStuff {

    public String targetURL = "\"https://api.orchestrate.io/v0/users/";

	public  void createToken(String targetURL, List<String> tokens) {
		HttpURLConnection connection = null;
		try {
			for(int i = 0; i < tokens.size(); i++){
				//Create connection
				URL url = new URL(targetURL);
				connection = (HttpURLConnection)url.openConnection();
				connection.setRequestMethod("PUT");
				connection.setRequestProperty("Content-Type",
						"application/json");
				// String body = "{\"name\":" + "\"" + name + "\"," + "\"email\":" + "\"" + email + "\"," + "\"phoneNumber\":" + "\"" + phoneNum + "\"}";
				String body = "{\"userID_token\":" + "\"" + tokens.get(i) + "\"}";
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
//				return response.toString();
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			//return null;
		} finally {
			if(connection != null) {
				connection.disconnect();
			}
		}
	}


    public  void createUser(String targetURL, String name, String  phoneNum ,String email) {
        HttpURLConnection connection = null;
        try {

                //Create connection
                URL url = new URL(targetURL);
                connection = (HttpURLConnection)url.openConnection();
                connection.setRequestMethod("PUT");
                connection.setRequestProperty("Content-Type",
                    "application/json");
                 String body = "{\"name\":" + "\"" + name + "\"," + "\"email\":" + "\"" + email + "\"," + "\"phoneNumber\":" + "\"" + phoneNum + "\"}";
               // String body = "{\"userID_token\":" + "\"" + tokens.get(i) + "\"}";
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
//				return response.toString();


        }
        catch (Exception e) {
            e.printStackTrace();
            //return null;
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
        }
    }

    public  void storeAmount(String amount, String  phoneNum ) {
        HttpURLConnection connection = null;
        try {

            String targetURL = "\"https://api.orchestrate.io/v0/redemption/";
            //Create connection
            URL url = new URL(targetURL+ phoneNum);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type",
                "application/json");
            String body = "{\"amount\":" + "\"" + amount + "\"}";
            // String body = "{\"userID_token\":" + "\"" + tokens.get(i) + "\"}";
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
//				return response.toString();


        }
        catch (Exception e) {
            e.printStackTrace();
            //return null;
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
        }
    }



    public  RedemptionCode redeamCode() {
        HttpURLConnection connection = null;
        try {
             String targetURL = "\"https://api.orchestrate.io/v0/redemption";
            //Create connection
            URL url = new URL(targetURL + "?limit=1");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("get");
            connection.setRequestProperty("Content-Type",
                "application/json");


            String basicAuth = "Basic YmE2YzEwM2YtOTY2ZS00Yzc2LWIwY2UtNjI0ODQ0YTI3OTU1Og==";
            connection.setRequestProperty("Authorization", basicAuth);
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(
                connection.getOutputStream());

            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if not Java 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();

            RedemptionCode code = new RedemptionCode();

            code.setPhone("3148050537");
            code.setCode("ABC3444");

            return code;


        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException();

        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
