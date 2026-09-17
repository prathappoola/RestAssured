package Demo;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPatchDelete {
	
	@Test
	public void testPut() {
		
		
		JSONObject request=new JSONObject();
		request.put("name","Prathap");
		request.put("job","Test Engineer");
		
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		
		given().
		 header("content-Type","application/json").
		  body(request.toJSONString()).
		when().
		   put("/users/2").
		then().
		   statusCode(200).log().all();
		
		
		
	}
	
	
	@Test
	public void testPatch() {
		
		
		JSONObject request=new JSONObject();
		request.put("name","Prathap");
		request.put("job","Test Engineer");
		
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in";
		
		given().
		 header("content-Type","application/json").
		  body(request.toJSONString()).
		when().
		   put("/api/users/2").
		then().
		   statusCode(200).log().all();
		
	}
	
	@Test
	public void testDelete() {
		
	
		baseURI="https://reqres.in";
		
		given().
		when().
		   delete("/api/users/2").
		then().
		   statusCode(204).log().all();
		
	}
	

}
