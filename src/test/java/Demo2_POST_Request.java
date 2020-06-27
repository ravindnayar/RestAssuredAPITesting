import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo2_POST_Request {
	
	@Test
	void postRegister(){
		
		// specify base URI		
		 RestAssured.baseURI = "https://sandbox.prime-cloud.com";
		
		// Request Object	
		RequestSpecification httpRequest = RestAssured.given();
		
		// JSON object
		JSONObject json = new JSONObject();
		
		// body define with json payload
		json.put("clientCode", "WEE");
		json.put("membershipId", "7777000107031505");
		json.put("memberCurrency", "HRK");
		json.put("countryCulture", "en-us");
		json.put("outputType", "json");
		
		// headers define
		  httpRequest.header("access_token","XweeOmzcKGh/nLgzUDpPzOgVjQ==");
		  httpRequest.header("Content-Type","application/json");
		
		  httpRequest.body(json.toJSONString());
		
		 
		// Response Object
		Response response = httpRequest.request(Method.POST,"/V1/MemberCurrency/Service/MemberCurrency.svc/AddMemberCurrency");
		
	       		
		// print response		
		int statusCode = response.getStatusCode();
		System.out.println("Status code is " +statusCode);
		//Assert.assertEquals(statusCode, "200");
		
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : " +responseBody);
		String errorMessage = response.jsonPath().get("errorMessage");
		Assert.assertEquals(errorMessage, "Success");
		
		/*// status code validation
		int statuscode = response.getStatusCode();
		System.out.println("Status code is: " +statuscode);
		Assert.assertEquals(statuscode, 200);
		
		// Successcode validation
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");*/
		
	}
}
