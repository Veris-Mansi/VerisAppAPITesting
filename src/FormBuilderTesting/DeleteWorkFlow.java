package FormBuilderTesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import Files.PayLoadDataFormBuilder;
import Files.ResourceFormBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteWorkFlow {

	int form_id=45;
	@Test
	public void DeleteWorkFlow()
	{
		int p_count=ResourceFormBuilder.getForms();
		System.out.println(p_count);
		RestAssured.baseURI="https://sandbox.veris.in";
		given().
		headers("Content-Type","application/json").headers("Authorization","token 8f62fd0d5c5d5f43c22bf18e841d7117b3f20514").
		when().delete(ResourceFormBuilder.addScreens(form_id)).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).body("detail",equalTo("Form successfully deleted"));
		int next_count=ResourceFormBuilder.getForms();
		System.out.println(next_count);
		Assert.assertEquals(p_count, next_count+1);
	}
}
