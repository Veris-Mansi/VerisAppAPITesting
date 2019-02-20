package Files;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ResourceFormBuilder {

	
	public static void invalidOrganization()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.AddWorkflow()).
		when().post(ResourceFormBuilder.AddWorkflowInvalidOrganization()).
		then().assertThat().statusCode(403).and().contentType(ContentType.JSON).body("detail", equalTo("You do not have permission to perform this action."));
		
	}
	public static void invalidToken()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		given().
		headers("Content-Type","application/json").headers("Authorization","token 8we62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.AddWorkflow()).
		when().post(ResourceFormBuilder.AddWorkflow()).
		then().assertThat().statusCode(401).and().contentType(ContentType.JSON).body("detail", equalTo("Invalid token."));
		
	}
	public static int getForms()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		 Response res = given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		when().get(ResourceFormBuilder.AddWorkflow()).
		then().assertThat().statusCode(200).extract().response();
		 String response=res.asString();
		 JsonPath path = new JsonPath(response);
		 int count = path.getInt("count");
		 return count;
	}
	
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
	public static String addScreens(int form_id)
	{
		System.out.println("form_id "+form_id);
		String id=String.valueOf(form_id);
		System.out.println("Id "+id);
		String s="https://sandbox.veris.in/api/v2/organization/6/forms/"+id+"/";
		System.out.println(s);
		return s;
	}
	public static String screen()
	{
		String s="/api/v2/organization/6/screens/";
		return s;
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
	public static int addCustomScreens()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		Response res = given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.addCustomScreens()).
		when().post(ResourceFormBuilder.screen()).
		then().assertThat().statusCode(201).and().contentType(ContentType.JSON).extract().response();
		String response=res.asString();
		JsonPath path = new JsonPath(response);
		int form_id=path.get("forms[0].id");
		System.out.println("Custorm Form_id "+form_id);
		return form_id;
	}
	public static String getUnfixScreens(int form_id)
	{
		String form_id1=String.valueOf(form_id);
		String s="api/v2/organization/6/form/"+form_id1+"/unfix-screens/";
		return s;
	}
	public static String AddWorkflowInvalidOrganization() {
		// TODO Auto-generated method stub
		String p="/api/v2/organization/100/forms/";
		return p;
	}
	
	
}
