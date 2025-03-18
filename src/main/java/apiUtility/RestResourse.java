package apiUtility;

import static apiUtility.SpecBuilder.getRequestSpec;
import static apiUtility.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestResourse {
	

	
	/**
	 * 
	 * @param reqplaylist
	 * @return
	 */

	public static Response post(String path,String token,Object reqplaylist) {
		return given(getRequestSpec())
				.body(reqplaylist)
				.header("Authorization", "Bearer "+token)
			.when()
				.post(path)
			.then()
				.spec(getResponseSpec())
				.extract()
				.response();
		}
	
	public static Response postAccount(HashMap<String, String> formParams) {
		return given(SpecBuilder.getAccountRequestSpec())
				.formParams(formParams)
			.when()
			    .post("/api/token")
			
		    .then()
		   
		       .spec(SpecBuilder.getResponseSpec())
		       .extract().response();
	}

	
	/**
	 * 
	 * @param playlistID
	 * @return
	 */
	public static Response get(String path,String token) {
		return given(getRequestSpec())
				.header("Authorization", "Bearer "+token)
			.when()
				.get(path)
			.then()
				.spec(getResponseSpec())
				.extract()
				.response();
	}
	
	/**
	 * 
	 * @param reqplaylist
	 * @param playlistID
	 * @return
	 */
	
	public static Response put(String path,String token,Object reqplaylist ) {
	return	given(getRequestSpec())
		.body(reqplaylist)
		.header("Authorization", "Bearer "+token)
	.when()
		.put(path)
	.then()
		.spec(getResponseSpec())
		.extract().response();
	}
}
