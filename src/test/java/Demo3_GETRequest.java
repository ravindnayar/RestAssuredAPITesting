import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo3_GETRequest {
	
	@Test
	public void getDemo(){
		
		// base URI and path
		RestAssured.baseURI = "https://sandbox.prime-cloud.com/V1/FetchAlias/Service/FetchAlias.svc/GetAlias";
								
		// Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		// initialize headers
	     httpRequest.header("access_token","XweeOmzcKGh/nLgzUDpPzOgVjQ==");
	     httpRequest.header("Content-Type","application/json");
			
	
		// query params
		httpRequest.given().contentType(ContentType.JSON).queryParam("clientCode" , "WEE")
				.queryParam("customerId", "F4D0F47E-9D78-4863-A567-76A130825EA7")
				.queryParam("membershipId", "4444001000076932")
				.queryParam("outputType", "json").queryParam("countryCulture", "en-us").log().parameters()
				.get().then().log().all();
		
		
		// Response body
	//	response.prettyPrint();
		
	
	}

}
