package FormBuilderTesting;

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
public class CreateWorkflowTest {

	int form_id;
	@Test(description="Adding WorkFlow")
	public void AddWorkFlow()
	{
		form_id=ResourceFormBuilder.Createworkflow();
	}
	@Test(description="Mapping WorkFlow with venue")
	public void MapWorkflow()
	{
		RestAssured.baseURI="https://sandbox.veris.in";
		 given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		body(PayLoadDataFormBuilder.mappingWorkflow(form_id)).
		when().post(ResourceFormBuilder.MapWorkflow()).
		then().assertThat().statusCode(201);
	}
}
