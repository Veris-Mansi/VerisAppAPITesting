package VerisAPI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Files.PayLoadData;
import Files.Resource;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

public class VerifyOTPTest {
	
	@Test
	public void verifyOTP()
	{
		Resource.verifyCorrectOTP();
	}
	@Test
	public void verifyIncorrectOTP()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		given().
		headers("Content-Type","application/json").body(PayLoadData.VerifyIncorrectOTPCredentials()).
		when().post("api/v2/verify-one-time-password/").
		then().assertThat().statusCode(400).and().contentType(ContentType.JSON).and().body("otp_code[0]", equalTo("Entered OTP is invalid or has been expired."));
		
	}
	@Test
	public void verifyIncorrectOTP4()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		given().
		headers("Content-Type","application/json").body(PayLoadData.VerifyIncorrectOTPCredentials4()).
		when().post("api/v2/verify-one-time-password/").
		then().assertThat().statusCode(400).and().contentType(ContentType.JSON).and().body("otp_code[0]", equalTo("Entered OTP is invalid or has been expired."));
		
	}
	@Test
	public void verifyIncorrectOTP6()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		given().
		headers("Content-Type","application/json").body(PayLoadData.VerifyIncorrectOTPCredentials6()).
		when().post("api/v2/verify-one-time-password/").
		then().assertThat().statusCode(400).and().contentType(ContentType.JSON).and().body("otp_code[0]", equalTo("Entered OTP is invalid or has been expired."));
	}
}
