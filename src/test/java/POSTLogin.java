import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTLogin {
	
	@Test
	public void loginPOST(){
		
		// base URI
		RestAssured.baseURI="https://sandbox.prime-cloud.com";
		
		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		// JSON Object
		JSONObject requestParam = new JSONObject();
		
		// Body define
		requestParam.put("clientCode", "WEE");
		requestParam.put("userId", "4444001000921829");
		requestParam.put("outputType", "json");
		requestParam.put("password", "hello0091");
		
		// Header define
		httpRequest.header("Content-Type","application/json");
		httpRequest.header("access_token","XweeOmzcKGh/nLgzUDpPzOgVjQ==");
		
		// Header to JSONString
		httpRequest.body(requestParam.toJSONString());
		
		// Response Object with url path
		Response response = httpRequest.request(Method.POST, "/V3/Login/Service/Login.svc/Login");
		
		
		// Print
		String bodyresponse = response.body().asString();
		System.out.println("Body Response is " +bodyresponse);
		
	}

}
