package Files;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PayLoadDataFormBuilder {

	public static String AddWorkflow()
	{
		String s="{\r\n" + 
				"	\"form_type\":\"MyTest\",\r\n" + 
				"\"meta\":	{},\r\n" + 
				"\"screens\":	[],\r\n" + 
				"\"status\":	1,\r\n" + 
				"\"title\"	:\"Workflow2\"\r\n" + 
				"}";
		return s;
	}

	
	public static String mappingWorkflow(int id)
	{
		String form_id=String.valueOf(id);
		String s="{\r\n" + 
				"    \"object_id\": \"9\",\r\n" + 
				"    \"object_type\":\"venue\",\r\n" + 
				"    \"form_id\":"+form_id+"\r\n" + 
				"}";
	return s;
	}
}
