package FormBuilderTesting;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import Files.PayLoadDataFormBuilder;
import Files.ResourceFormBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
public class EditWorkflow {
	
	int form_id=49;
	
	@Test(description="Editing workflow with invalid token")
	public void invalidToken()
	{	
	RestAssured.baseURI="https://sandbox.veris.in";
	given().
	headers("Content-Type","application/json").headers("Authorization","token 85f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
	body(PayLoadDataFormBuilder.EditWorkFlow()).
	when().put("/api/v2/organization/6/forms/"+String.valueOf(form_id)+"/").
	then().assertThat().statusCode(401).and().contentType(ContentType.JSON).body("detail", equalTo("Invalid token."));
	
	}
	@Test(description="invalid organization id",dependsOnMethods="invalidToken")
	public void invalidOrganization()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.EditWorkFlow()).
		when().put("/api/v2/organization/100/forms/"+String.valueOf(form_id)+"/").
		then().assertThat().statusCode(403).and().contentType(ContentType.JSON).body("detail", equalTo("You do not have permission to perform this action."));
		
	}
	@Test(description="Editing WorkFlow",dependsOnMethods="invalidOrganization")
	public void AddWorkFlow()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.EditWorkFlow()).
		when().put(ResourceFormBuilder.editForms(form_id)).
		then().statusCode(200);
		
	}
	}
