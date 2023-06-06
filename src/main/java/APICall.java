
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APICall {

	private final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=London&appid=8ee7ebb46dfddd6baecb119d58650940";

	
	/* This method call the GET endpoint and 
	 * capture the response code and check if it's 200 then
	 * save and return the response data
	*/
	
    public String getResponse() throws IOException {
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {
            throw new IOException("Request failed with response code: " + responseCode);
        }
    }
    
    public static void main(String[] args) {
    	
    	APICall apiCall = new APICall();
    	try {
            String response = apiCall.getResponse();
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
