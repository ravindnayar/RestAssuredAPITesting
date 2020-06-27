import org.json.simple.JSONObject;
import org.junit.runner.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_AddUpdateMaster {

	@Test
	public void addUpdate(){
		
		// base URI
		RestAssured.baseURI = "https://sandbox.prime-cloud.com";
		
		// RequestSpecification given
		RequestSpecification httpRequest = RestAssured.given();
		
		// JSON object
		JSONObject json = new JSONObject();
		
		// Body Define
		json.put("clientCode", "WEE");
		json.put("entityName", "Merchant");
		json.put("countryCulture", "en-us");
		json.put("outputType", "json");
		json.put("partnerCode", "NA");
		json.put("enabled", "1");
		json.put("deleted", "0");
		json.put("udf4", "Headline Category");
		json.put("udf5", "test");
		
		// Header Define
		httpRequest.header("Content-Type", "application/json");
		httpRequest.header("access_token", "XweeOmzcKGh/nLgzUDpPzOgVjQ==");
		
		// Header to JSON
		httpRequest.body(json.toJSONString());
		
		// Response Object
		Response response = httpRequest.request(Method.POST,"/V1/Master/Service/Master.svc/AddUpdate");
		
		// print
		 String body = response.body().asString();
		 System.out.println(body);
		 
		int status =  response.getStatusCode();
		System.out.println(status);
		Assert.assertEquals(status, 500);
		System.out.println("this is pass");
	}
}
