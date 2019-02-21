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
public class MapScreenWIthWorkflow {
	
	int form_id;
	@Test(description="Adding workflow with invalid token")
	public void invalidToken()
	{		ResourceFormBuilder.invalidToken();
	}
	@Test(description="invalid organization id",dependsOnMethods="invalidToken")
	public void invalidOrganization()
	{
		ResourceFormBuilder.invalidOrganization();
	}
	@Test(description="Adding WorkFlow",dependsOnMethods="invalidOrganization")
	public void MapWorkflow()
	{
		
	}
	
	}
