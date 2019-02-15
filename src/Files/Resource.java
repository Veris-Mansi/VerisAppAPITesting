package Files;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Resource {

	public static String verifyCorrectOTP()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		Response res = (Response) given().
		headers("Content-Type","application/json").body(PayLoadData.VerifyOTPCredentials()).
		when().post("api/v2/verify-one-time-password/").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
		String response = res.asString();
		JsonPath path = new JsonPath(response);
		System.out.println("Response "+response);
		String token = path.get("token");
		System.out.println("Token is "+token);
		return token;
	}

}
