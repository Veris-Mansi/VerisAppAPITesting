package FormBuilderTesting;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import Files.ResourceFormBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetUnfixScreens {

	int form_id=49;
	@Test(description="GEtUnfixScreens")
	public void getUnfixScreens()
	{
		
		RestAssured.baseURI="https://sandbox.veris.in";
		Response res = given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		when().get(ResourceFormBuilder.getUnfixScreens(form_id)).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
		String response=res.asString();
		JsonPath path=new JsonPath(response);
		int count=path.getInt("count");
		System.out.println(count);
		System.out.println("Reponse is "+response);
		
	}
}
