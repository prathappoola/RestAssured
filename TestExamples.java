package Demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestExamples {
	
	@Test
	public void test_1() {
		
		Response res= get("https://reqres.in/api/users?page=2");
		System.out.println( res.getStatusCode());
	   System.out.println(res.getTime());
	   System.out.println(res.getBody().asString()); 
	   System.out.println(res.getStatusLine());
	   System.out.println(res.getHeader("content-type"));
	   
	   int stscode=res.getStatusCode();
	   Assert.assertEquals(stscode, 200);
	   
	   	
	}
	
	@Test
	public void test_2() {
		
		baseURI="https://reqres.in/api";
		
		given().get("/users?page=2").then().statusCode(200).
		body("data[1].id", equalTo(8)).
		body("data[1].email", equalTo("lindsay.ferguson@reqres.in")).
		log().all();
		
		
		
		
	}

}
