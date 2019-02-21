package FormBuilderTesting;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Files.PayLoadDataFormBuilder;
import Files.ResourceFormBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RemoveExistingScreens {

	int form_id=49;
	int screen_workflow_mapping_id=118;
	@Test()
	public void AddExistingScreeens()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		Response res = given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.addScreens()).
		when().put(ResourceFormBuilder.addScreens(form_id)).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
		String response=res.asString();
		System.out.println("Response is "+response);
		JsonPath path=new JsonPath(response);
		screen_workflow_mapping_id=path.getInt("screens[0].id");
		System.out.println("screen_workflow_mapping_id "+screen_workflow_mapping_id);
	}
	
	@Test(dependsOnMethods="AddExistingScreeens")
	public void removeExixtingScreens()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		parameters("0", screen_workflow_mapping_id ).
		when().put("/api/v2/organization/6/forms/49/").then().statusCode(200);
	}
	
}
