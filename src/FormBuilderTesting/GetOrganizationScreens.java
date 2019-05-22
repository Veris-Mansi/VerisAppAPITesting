//Invalid formid,organizationid,token

//working for invalid form_id
package FormBuilderTesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import Files.PayLoadDataFormBuilder;
import Files.ResourceFormBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetOrganizationScreens {

	int form_id=27;
	@Test(description="Mapping workflow with invalid token")
	public void invalidToken()
	{
		ResourceFormBuilder.invalidToken();
	}
	@Test(description="mapping workflow invalid organization id",dependsOnMethods="invalidToken")
	public void invalidOrganization()
	{
		ResourceFormBuilder.invalidOrganization();
	}
	@Test
	public void getScreens()
	{
		
		RestAssured.baseURI="https://sandbox.veris.in";
		Response res = given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		when().get(ResourceFormBuilder.screen()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
		String response=res.asString();
		JsonPath path=new JsonPath(response);
		int count=path.getInt("count");
		System.out.println(count);
		
	}
}
