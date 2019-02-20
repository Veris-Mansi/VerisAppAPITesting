//Mapping venue with invalid form id 
//invalid organization
//invalid token
//invalid form id 
//correct venue invalid form id(400)
//correct form id but invalid venue(400)
package FormBuilderTesting;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import Files.PayLoadDataFormBuilder;
import Files.ResourceFormBuilder;
import io.restassured.RestAssured;

public class MapWorkFlow {

	int form_id=26;
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
	@Test(description="mapping workflow invalid form id",dependsOnMethods="invalidOrganization")
	public void invalidFormId()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		 given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.mappingWorkflow(2000,9)).
		when().post(ResourceFormBuilder.MapWorkflow()).
		then().assertThat().statusCode(400).and().body("form_id[0]", equalTo("Invalid form"));
	}
	@Test(description="mapping workflow invalid form id",dependsOnMethods="invalidOrganization")
	public void invalidVenueId()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		 given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.mappingWorkflow(2,900)).
		when().post(ResourceFormBuilder.MapWorkflow()).
		then().assertThat().statusCode(400);
	}

	
	@Test(description="Mapping WorkFlow with venue",dependsOnMethods="invalidVenueId")
	public void MapWorkflow()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		 given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.mappingWorkflow(form_id,9)).
		when().post(ResourceFormBuilder.MapWorkflow()).
		then().assertThat().statusCode(201);
	}
}
