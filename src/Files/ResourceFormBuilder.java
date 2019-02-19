package Files;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ResourceFormBuilder {

	public static String AddWorkflow()
	{
		String p="/api/v2/organization/6/forms/";
		return p;
	}
	public static String MapWorkflow()
	{
		String p="api/v2/organization/6/map-forms/";
		return p;
	}
	
	public static int Createworkflow()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		Response res = given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.AddWorkflow()).
		when().post(ResourceFormBuilder.AddWorkflow()).
		then().assertThat().statusCode(201).and().contentType(ContentType.JSON).extract().response();
		String response=res.asString();
		JsonPath path = new JsonPath(response);
		int form_id=path.get("id");
		System.out.println("Form_id "+form_id);
		return form_id;
		//return String.valueOf(form_id);
	}
}
