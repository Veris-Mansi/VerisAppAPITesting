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
				"	\"form_type\":\"Workflow5\",\r\n" + 
				"\"meta\":	{},\r\n" + 
				"\"screens\":	[],\r\n" + 
				"\"status\":	1,\r\n" + 
				"\"title\"	:\"Workflow5\"\r\n" + 
				"}";
		return s;
	}

	
	public static String mappingWorkflow(int fid,int venue_id)
	{
		String form_id=String.valueOf(fid);
		String s="{\r\n" + 
				"    \"object_id\": \"9\",\r\n" + 
				"    \"object_type\":"+venue_id+",\r\n" + 
				"    \"form_id\":"+form_id+"\r\n" + 
				"}";
	return s;
	}
	
	public static String addScreens()
	{
		String s="{\r\n" + 
				"   \r\n" + 
				"    \"screens\": [\r\n" + 
				"        {\r\n" + 
				"        \"screen\": 28,\r\n" + 
				"        \"position\": 1\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"        \"screen\": 29,\r\n" + 
				"        \"position\": 2\r\n" + 
				"        }\r\n" + 
				"    ]\r\n" + 
				"}";
		System.out.println(s);
		return s;
	}
	public static String addCustomScreens()
	{
		String s="{\r\n" + 
				"              \"title\": \"My screen\",\r\n" + 
				"			   \"form_type\":\"My screen\",\r\n" + 
				"              \"form_fields\": [\r\n" + 
				"                \r\n" + 
				"              ]\r\n" + 
				"            }";
		return s;
	}
	public static String MapCustomScreen(int screenid)
	{
		String id=String.valueOf(screenid);
		String s="{\r\n" + 
				"  \"screens\": [\r\n" + 
				"    {\r\n" + 
				"      \"screen\":"+id+",\r\n" + 
				"      \"position\": 3\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
		return s;
		
	}
}
