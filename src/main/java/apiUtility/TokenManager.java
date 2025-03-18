package apiUtility;

import java.time.Instant;
import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class TokenManager {
	
	private static String access_Token;
	private static Instant expiry_time;
	
	
	
	public static String getToken() {
		try {
			if(access_Token==null||Instant.now().isAfter(expiry_time)) {
				System.out.println("Renewing Token..............");
				Response response = renewToken();
				access_Token=response.path("access_token");
			int expiryDurationInSeconds=response.path("expires_in");
			
			expiry_time=Instant.now().plusSeconds(expiryDurationInSeconds-300);
			
			}
			else {
				System.out.println("===========>>>Token is good to use");
			}
		} catch (Exception e) {
			throw new RuntimeException("ABORT!! Failed to get token");
		}
		return access_Token;
	}
	
	
	
	private static Response renewToken() {
		HashMap<String,String> formParams=new HashMap<String, String>();
		formParams.put("client_id", "0ac8924172dd43e1bb707692c3ff96cc");   
		formParams.put("client_secret", "e0e9a79238934ed48b3c9d19c66852d5");
		formParams.put("refresh_token", "AQAOQuK4rntlw3QWFf72gURkkcS1cq41xvQhz9tNLafRR0M3frt9atyOidtsTsW-_HfUnGJWTHKcV_ZFn6EmarMq6I1keI2AWQxhwbiTJPzE3MAS7Wu2UduYyOXI1k3pSnk");
		formParams.put("grant_type", "refresh_token");
		
		Response response = RestResourse.postAccount(formParams);
		
		if(response.getStatusCode()!=200)
			throw new RuntimeException("ABORT!!! Renew token failed");
		else
			return response;
	}

}
