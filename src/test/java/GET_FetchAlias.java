import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_FetchAlias {
	
	@Test
	void getFetchAlias(){
		
		// specify base URI
		RestAssured.baseURI = "https://sandbox.prime-cloud.com/V1/FetchAlias/Service/FetchAlias.svc";
		
		Response response = RestAssured.given().param("clientCode", "WEE").param("customerId", "F4D0F47E-9D78-4863-A567-76A130825EA7")
				.param("membershipId", "4444001000076932").param("outputType", "json").param("countryCulture", "en-us").when().get();
		
		System.out.println("getStatusCode" + response.getStatusCode());
		System.out.println("getContentType" + response.contentType());
		System.out.println("getTime" + response.getTime());
		
		String responseBody = response.getBody().asString();
		System.out.println("body = " + responseBody);
		
		response.prettyPrint();
		
				
	
	
	}

}
