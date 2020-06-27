import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class GETPartnerHistory {
	
	@Test
	public void partnerHistory(){
		
		// Base URL
		RestAssured.baseURI = "https://sandbox.prime-cloud.com/V2/PartnerHistory/Service/PartnerHistory.svc/GetPartnerHistory";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		// Header define
		httpRequest.header("Content-Type","application/json");
		httpRequest.header("access_token","XweeOmzcKGh/nLgzUDpPzOgVjQ==");
		
		// Query Params
		String query = httpRequest.given().contentType(ContentType.JSON).queryParam("clientCode", "WEE")
		.queryParam("outputType", "json").queryParam("startDate", "25-12-2019")
		.queryParam("endDate", "25-02-2020").queryParam("partnerCode", "WEE")
		.queryParam("transactionType", "E").queryParam("viewType", "S").log().parameters().get().then().log().all().toString();
		
		
		Assert.assertEquals(query, "");
	
	}

}
