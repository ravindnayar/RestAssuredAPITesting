import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class changePasswordPOST {
	
	@Test
	public void changePassword(){
		
		// Base URI
		RestAssured.baseURI = "https://sandbox.prime-cloud.com";
		
		// Request Object
		RequestSpecification httpRequest = new RestAssured().given();
		
		// JSON Object
		JSONObject requestParam = new JSONObject();
		
		// Body define
		requestParam.put("clientCode", "WEE");
		requestParam.put("membershipId", "4444001000921829");
		requestParam.put("newPassword", "hello0091");
		requestParam.put("outputType", "json");
		requestParam.put("countryCulture", "en-us");
		
		// Header define
		httpRequest.header("Content-Type","application/json");
		httpRequest.header("access_token","XweeOmzcKGh/nLgzUDpPzOgVjQ==");
		
		// Header to JSON
		httpRequest.body(requestParam.toString());
		
		// Response Object and path
		Response response = httpRequest.request(Method.POST,"/V3/ChangePassword/Service/ChangePassword.svc/ChangePassword");
		
		//print
		String bodyOutput = response.body().asString();
		System.out.println("Body OUtput is " +bodyOutput);
		
	}

}
