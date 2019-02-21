package FormBuilderTesting;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import Files.PayLoadData;
import Files.PayLoadDataFormBuilder;
import Files.ResourceFormBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
public class CompleteTesting {

	int form_id;
	int custom_screen_id;
	int screen_workflow_mapping_id;
	int custom_screen_mapping_id;
	int form_field_id;
	@Test(description="Adding WorkFlow",priority=1)
	public void AddWorkFlow()
	{
		form_id=ResourceFormBuilder.Createworkflow();
	}
	@Test(description="Mapping WorkFlow with venue",dependsOnMethods="AddWorkFlow",priority=2)
	public void MapWorkflow()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		 given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.mappingWorkflow(form_id,12)).
		when().post(ResourceFormBuilder.MapWorkflow()).
		then().assertThat().statusCode(201);
	}
	@Test(dependsOnMethods="MapWorkflow",description="Getting Unfix Screens",priority=3)
	public void getUnfixScreens()
	{
		
		RestAssured.baseURI="https://sandbox.veris.in";
		Response res = given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		when().get(ResourceFormBuilder.getUnfixScreens(form_id)).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
		String response=res.asString();
		System.out.println("getUnfixScreens Reponse is "+response);
	}
	
	@Test(dependsOnMethods="getUnfixScreens",description="Add default screens",priority=4)
	public void AddExistingScreeens()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		Response res = given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.addScreens()).
		when().put(ResourceFormBuilder.addScreens(form_id)).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
		String response=res.asString();
		System.out.println("AddExistingScreeens Response is "+response);
		JsonPath path=new JsonPath(response);
		screen_workflow_mapping_id=path.getInt("screens[0].id");
		System.out.println("screen_workflow_mapping_id "+screen_workflow_mapping_id);
	}
	@Test(dependsOnMethods="AddExistingScreeens",description="removeExistingScreens",priority=5)
	public void removeExistingScreens()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.removeexixtingscreen(String.valueOf(screen_workflow_mapping_id))).
		when().put("/api/v2/organization/6/forms/"+form_id+"/").then().statusCode(200);
	}	
	@Test(dependsOnMethods="removeExistingScreens",priority=6)
	public void addCustomScreens()
	{
		custom_screen_id=ResourceFormBuilder.addCustomScreens();
	}
	@Test(dependsOnMethods="addCustomScreens",priority=7)
	public void MapCustomScreen()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		Response res = given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.MapCustomScreen(custom_screen_id)).
		when().put(ResourceFormBuilder.addScreens(form_id)).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
		String response=res.asString();
		System.out.println("MapCustomScreen Response is "+response);
		JsonPath path=new JsonPath(response);
		custom_screen_mapping_id=path.get("screens[0].id");
		System.out.println("custom_screen_mapping_id "+custom_screen_mapping_id);
	}
	//
	@Test(dependsOnMethods="MapCustomScreen",priority=8)
	public void EditCustomScreen()
	{
		String id=String.valueOf(custom_screen_id);
		RestAssured.baseURI="https://sandbox.veris.in";
		Response res = given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.editNewScreen()).
		when().put("/api/v2/organization/6/screens/"+id+"/").
		then().statusCode(200).extract().response();
		String response=res.asString();
		System.out.println("EditCustomScreen response "+response);
		JsonPath path=new JsonPath(response);
		int form_field_id=path.get("forms[0].form_fields[0].id");
		System.out.println("form_id "+form_field_id);
	}
	@Test(dependsOnMethods="EditCustomScreen",priority=9)
	public void removeFormField()
	{
		String screenid=String.valueOf(custom_screen_id);

		String id = String.valueOf(form_field_id);
		RestAssured.baseURI="https://sandbox.veris.in";
		given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.removeFormId(id))
		.when().put("/api/v2/organization/6/screens/"+screenid+"/").
		then().statusCode(200);
	}
	@Test(dependsOnMethods = "removeFormField",priority=10)
	public void removeCustomScreens()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.removeexixtingscreen(String.valueOf(custom_screen_mapping_id))).
		when().put("/api/v2/organization/6/forms/"+form_id+"/").then().statusCode(200);
	}
	@Test(dependsOnMethods="removeCustomScreens",priority=11)
	public void removeWorkFlow()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.removeWorkflow(String.valueOf(form_id))).
		when().put(ResourceFormBuilder.MapWorkflow()).then().statusCode(200);
	}
}
