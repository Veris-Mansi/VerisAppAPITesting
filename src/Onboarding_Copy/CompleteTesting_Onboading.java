package Onboarding_Copy;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import Files.PayLoadData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CompleteTesting_Onboading {
	
	String token2 = "aab85467851b7e1947919fe122393201a0fdba6c";
	String token=PayLoadData.getProfileData();
	String invalid_token=PayLoadData.getProfileIncorrectData();
	
	@Test(groups ="OTP",priority=1,description="Invalid country code")
	public void InvalidCountryCode()
	{
		RestAssured.baseURI="https://sandbox.veris.in";

		given().
		headers("Content-Type","application/json").body(PayLoadData.invalidCountrycode()).
		when().post("/api/v2/one-time-password/").
		then().assertThat().statusCode(400).and().contentType(ContentType.JSON);
	}
	@Test(groups ="OTP",priority=2,description="Nine digit mobile no",dependsOnMethods="InvalidCountryCode")
	public void InvalidMobileNoNine()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		given().
		headers("Content-Type","application/json").body(PayLoadData.incorrectCredentials9()).
		when().post("/api/v2/one-time-password/").
		then().assertThat().statusCode(400).and().contentType(ContentType.JSON);
	}
	@Test(groups ="OTP",priority=3,description="Eleven digit mobile no",dependsOnMethods="InvalidMobileNoNine")
	public void InvalidMobileNoEleven()
	{
		RestAssured.baseURI="https://sandbox.veris.in";

		given().
		headers("Content-Type","application/json").body(PayLoadData.incorrectCredentials11()).
		when().post("/api/v2/one-time-password/").
		then().assertThat().statusCode(400).and().contentType(ContentType.JSON);
	}

	@Test(groups ="OTP",priority=4,description="Empty Credentials",dependsOnMethods="InvalidMobileNoEleven")
	public void emptyCredentials()
	{
		RestAssured.baseURI="https://sandbox.veris.in";

		given().
		headers("Content-Type","application/json").body(PayLoadData.emptyContactNumber()).
		when().post("/api/v2/one-time-password/").
		then().assertThat().statusCode(400).and().contentType(ContentType.JSON);
	}
	@Test(groups ="OTP",priority=5,description="Requesting OTP for correct credentials",dependsOnMethods="emptyCredentials")
	public static void RequestOTPTest()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		given().
		headers("Content-Type","application/json").body(PayLoadData.correctCredentials()).
		when().post("/api/v2/one-time-password/").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("otp_code_length",equalTo(5));
	}
	@Test(groups ="ResendOTP",priority=6,description="Invalid country code for Resend")
	public void ResendInvalidCountryCode()
	{
		RestAssured.baseURI="https://sandbox.veris.in";

		given().
		headers("Content-Type","application/json").body(PayLoadData.invalidCountrycode()).
		when().post("/api/v2/one-time-password/").
		then().assertThat().statusCode(400).and().contentType(ContentType.JSON);
	}
	@Test(groups ="ResendOTP",priority=7,description="Nine digit mobile no",dependsOnMethods="ResendInvalidCountryCode")
	public void ResendInvalidMobileNoNine()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		given().
		headers("Content-Type","application/json").body(PayLoadData.incorrectCredentials9()).
		when().post("/api/v2/one-time-password/").
		then().assertThat().statusCode(400).and().contentType(ContentType.JSON);
	}
	@Test(groups ="ResendOTP",priority=8,description="Eleven digit mobile no",dependsOnMethods="ResendInvalidMobileNoNine")
	public void ResendInvalidMobileNoEleven()
	{
		RestAssured.baseURI="https://sandbox.veris.in";

		given().
		headers("Content-Type","application/json").body(PayLoadData.incorrectCredentials11()).
		when().post("/api/v2/one-time-password/").
		then().assertThat().statusCode(400).and().contentType(ContentType.JSON);
	}
	@Test(groups ="ResendOTP",priority=9,description="Empty Credentials",dependsOnMethods="ResendInvalidMobileNoEleven")
	public void ResendemptyCredentials()
	{
		RestAssured.baseURI="https://sandbox.veris.in";

		given().
		headers("Content-Type","application/json").body(PayLoadData.emptyContactNumber()).
		when().post("/api/v2/one-time-password/").
		then().assertThat().statusCode(400).and().contentType(ContentType.JSON);
	}
	@Test(groups ="ResendOTP",priority=10,description="Requesting OTP for correct credentials",dependsOnMethods="ResendemptyCredentials")
	public static void ResendOTPTest()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		given().
		headers("Content-Type","application/json").body(PayLoadData.correctCredentials()).
		when().post("/api/v2/one-time-password/").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("otp_code_length",equalTo(5));
	}
	@Test(groups="getProfile",priority=11)
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
	@Test(groups="getProfile",priority=12)
	public void getDataInvalidToken()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		
		given().
		headers("Content-Type","application/json").headers("Authorization","token "+invalid_token).
		when().get("api/v2/profile/").
		then().assertThat().statusCode(401).and().body("detail", equalTo("Invalid token."));
	}
	@Test(groups="getProfile",priority=13)
	public void UserProfileUnavailable()
	{
       RestAssured.baseURI="https://sandbox.veris.in";
		
		given().
		headers("Content-Type","application/json").headers("Authorization","token "+token2).
		when().get("api/v2/profile/").
		then().assertThat().statusCode(404).and().body("detail", equalTo("User Profile is not available."));
	}
	@Test(groups="UpdateProfile",priority=14)
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
	@Test(groups="UpdateProfile",priority=15)
	public void getUpdatedDataInvalidToken()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		
		given().
		headers("Content-Type","application/json").headers("Authorization","token "+invalid_token).
		when().post("api/v2/profile/").
		then().assertThat().statusCode(401).and().body("detail", equalTo("Invalid token."));
	}


}
