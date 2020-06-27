import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.internal.proxy.RestAssuredProxySelectorRoutePlanner;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostLogout {
	
	@Test
	public void logoutPOST(){
		
		// Base URI
		RestAssured.baseURI = "https://sandbox.prime-cloud.com";
		
		// Request Object
		RequestSpecification httpRequest = new RestAssured().given();
		
		//JSON Object
		JSONObject requestParam = new JSONObject();
		
		// Body Define
		requestParam.put("clientCode", "WEE");
		requestParam.put("membershipId", "4444001000921621");
		requestParam.put("customerId", "E1749F67-63F0-41B2-A73C-9B536D6A021C");
		requestParam.put("outputType", "json");
		requestParam.put("countryCulture", "en-us");
		
		// Header Define
		httpRequest.header("Content-Type","application/json");
		httpRequest.header("access_token","XweeOmzcKGh/nLgzUDpPzOgVjQ==");
		
		// Header to JSON
		httpRequest.body(requestParam.toJSONString());
		
		// Response Object and path
		Response response = httpRequest.request(Method.POST,"/V3/Logout/Service/Logout.svc/Logout");
		
		//print
		String responseBody = response.body().asString();
		System.out.println("Output is " +responseBody);
		
			
	}

}
