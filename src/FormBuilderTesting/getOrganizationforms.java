package FormBuilderTesting;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import Files.PayLoadDataFormBuilder;
import Files.ResourceFormBuilder;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class getOrganizationforms {

	@Test
	public void getForms()
	{
	 	ResourceFormBuilder.getForms();
	}
}
