package Onboarding_Copy;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import Files.PayLoadData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class updateProfileData {

	String token2 = "aab85467851b7e1947919fe122393201a0fdba6c";
	String token=PayLoadData.getProfileData();
	String invalid_token=PayLoadData.getProfileIncorrectData();
	@Test(priority=1)
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
	@Test(priority=2)
	public void getUpdatedDataInvalidToken()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		
		given().
		headers("Content-Type","application/json").headers("Authorization","token "+invalid_token).
		when().post("api/v2/profile/").
		then().assertThat().statusCode(401).and().body("detail", equalTo("Invalid token."));
	}
}
