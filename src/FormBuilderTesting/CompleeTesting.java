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
public class CompleeTesting {

	int form_id;
	int custom_screen_id;
	@Test(description="Adding WorkFlow")
	public void AddWorkFlow()
	{
		form_id=ResourceFormBuilder.Createworkflow();
	}
	@Test(description="Mapping WorkFlow with venue",dependsOnMethods="AddWorkFlow")
	public void MapWorkflow()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		 given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.mappingWorkflow(form_id,9)).
		when().post(ResourceFormBuilder.MapWorkflow()).
		then().assertThat().statusCode(201);
	}
	@Test(dependsOnMethods="MapWorkflow")
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
	
	@Test(dependsOnMethods="getUnfixScreens")
	public void AddScreeens()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		Response res = given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.addScreens()).
		when().put(ResourceFormBuilder.addScreens(form_id)).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
		String response=res.asString();
		System.out.println("Response is "+response);
	}
	@Test(dependsOnMethods="AddScreeens")
	public void addCustomScreens()
	{
		custom_screen_id=ResourceFormBuilder.addCustomScreens();
	}
	@Test(dependsOnMethods="addCustomScreens")
	public void MapCustomScreen()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		Response res = given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.MapCustomScreen(custom_screen_id)).
		when().put(ResourceFormBuilder.addScreens(form_id)).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
		String response=res.asString();
		System.out.println("response is" +response);
	}
}
