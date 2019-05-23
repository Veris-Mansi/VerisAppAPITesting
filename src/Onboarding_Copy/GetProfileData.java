//test case 1: invalid token id
//test case2: valid token id but user info doesn't exist
//test case 3: valid token id
//test case 4: empty token
package Onboarding_Copy;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import Files.PayLoadData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import Files.Resource;
import io.restassured.RestAssured;

public class GetProfileData {

	String token2 = "aab85467851b7e1947919fe122393201a0fdba6c";
	String token=PayLoadData.getProfileData();
	String invalid_token=PayLoadData.getProfileIncorrectData();
	@Test(groups="getProfile")
	public void getProfilData()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		Response res =given().
		headers("Content-Type","application/json").headers("Authorization","token "+token).
		when().get("api/v2/profile/").
		then().assertThat().statusCode(200).extract().response();
		String response = res.asString();
		JsonPath path = new JsonPath(response);
		System.out.println("Response "+response);
		String uid=path.getString("uid");
		System.out.println("uid "+uid);
	}
	@Test(groups="getProfile")
	public void getDataInvalidToken()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		
		given().
		headers("Content-Type","application/json").headers("Authorization","token "+invalid_token).
		when().get("api/v2/profile/").
		then().assertThat().statusCode(401).and().body("detail", equalTo("Invalid token."));
	}
	@Test(groups="getProfile")
	public void UserProfileUnavailable()
	{
       RestAssured.baseURI="https://sandbox.veris.in";
		
		given().
		headers("Content-Type","application/json").headers("Authorization","token "+token2).
		when().get("api/v2/profile/").
		then().assertThat().statusCode(404).and().body("detail", equalTo("User Profile is not available."));
	}
	@Test(groups="UpdateProfile")
	public void updateProfilData()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		Response res =given().urlEncodingEnabled(true).
				formParam("first_name", "Mansi").
				formParam("last_name", "Sahu").
				formParam("profile_picture", "").
				formParam("email", "mansi.sahu@veris.in").
		headers("Authorization","token "+token).
		when().post("api/v2/profile/").
		then().assertThat().statusCode(200).extract().response();
		String response = res.asString();
		JsonPath path = new JsonPath(response);
		System.out.println("Response "+response);
	}
	@Test(groups="UpdateProfile")
	public void getUpdatedDataInvalidToken()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		
		given().
		headers("Content-Type","application/json").headers("Authorization","token "+invalid_token).
		when().post("api/v2/profile/").
		then().assertThat().statusCode(401).and().body("detail", equalTo("Invalid token."));
	}
	
}
