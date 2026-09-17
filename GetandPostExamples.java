package Demo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class GetandPostExamples {
	
	//@Test
	public void testGet() {
	
		baseURI="https://reqres.in/api";
		given().
		get("users?page=2").
		then().
		statusCode(200).
		body("data[1].last_name", equalTo("Ferguson")).
		body("data[3].email",equalTo("byron.fields@reqres.in")).
		body("data.last_name",hasItems("Fields","Edwards","Howell"));
		
	}
	
	
	@Test
	public void testPost() {
		
		Map<String, Object> map=new HashMap<String, Object>();
		
//		map.put("name","Prathap");
//		map.put("job","Test Engineer");
//		System.out.println(map);
//		
		JSONObject request=new JSONObject();
		request.put("name","Prathap");
		request.put("job","Test Engineer");
		
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		
		given().
		 header("content-Type","application/json").
		  body(request.toJSONString()).
		when().
		   post("/users").
		then().
		   statusCode(201).log().all();
		
		
		
	}
	

}
