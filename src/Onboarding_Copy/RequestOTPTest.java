//Testcases


//Valid mobile no
//Invalid mobile no(9 digit)
//Invalid mobile no 11 digit
//Empty Mobile no
package Onboarding_Copy;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import Files.PayLoadData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RequestOTPTest {
	@Test(priority=5,description="Requesting OTP for correct credentials",dependsOnMethods="emptyCredentials")
	public static void RequestOTPTest()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		given().
		headers("Content-Type","application/json").body(PayLoadData.correctCredentials()).
		when().post("/api/v2/one-time-password/").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("otp_code_length",equalTo(5));
	}
	@Test(priority=2,description="Nine digit mobile no",dependsOnMethods="InvalidCountryCode")
	public void InvalidMobileNoNine()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		given().
		headers("Content-Type","application/json").body(PayLoadData.incorrectCredentials9()).
		when().post("/api/v2/one-time-password/").
		then().assertThat().statusCode(400).and().contentType(ContentType.JSON);
	}
	@Test(priority=3,description="Eleven digit mobile no",dependsOnMethods="InvalidMobileNoNine")
	public void InvalidMobileNoEleven()
	{
		RestAssured.baseURI="https://sandbox.veris.in";

		given().
		headers("Content-Type","application/json").body(PayLoadData.incorrectCredentials11()).
		when().post("/api/v2/one-time-password/").
		then().assertThat().statusCode(400).and().contentType(ContentType.JSON);
	}
	@Test(priority=1,description="Invalid country code")
	public void InvalidCountryCode()
	{
		RestAssured.baseURI="https://sandbox.veris.in";

		given().
		headers("Content-Type","application/json").body(PayLoadData.invalidCountrycode()).
		when().post("/api/v2/one-time-password/").
		then().assertThat().statusCode(400).and().contentType(ContentType.JSON);
	}
	
	@Test(priority=4,description="Empty Credentials",dependsOnMethods="InvalidMobileNoEleven")
	public void emptyCredentials()
	{
		RestAssured.baseURI="https://sandbox.veris.in";

		given().
		headers("Content-Type","application/json").body(PayLoadData.emptyContactNumber()).
		when().post("/api/v2/one-time-password/").
		then().assertThat().statusCode(400).and().contentType(ContentType.JSON);
	}
	


}
