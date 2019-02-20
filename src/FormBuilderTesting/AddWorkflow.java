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
public class AddWorkflow {
	int prev_count=ResourceFormBuilder.getForms();
	int next_count;
	int form_id;
	int custom_screen_id;
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
	public void AddWorkFlow()
	{
		System.out.println("Previous count "+prev_count);
		form_id=ResourceFormBuilder.Createworkflow();
		int next_count=ResourceFormBuilder.getForms();
		System.out.println("next count "+next_count);
		Assert.assertEquals(next_count, prev_count+1);
	}
	}
