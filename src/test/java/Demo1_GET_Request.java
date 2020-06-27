import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo1_GET_Request {

	@Test
	void getWeather(){
		
		// specify base URI		
		RestAssured.baseURI = "http://restapi.demoqa.com./utilities/weather/city";
		RestAssured.basePath = "/hyderabad";
		
		// Request Object	
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.given().contentType(ContentType.JSON).log().all().get();
		
		 String humidity = httpRequest.given().contentType(ContentType.JSON).log().all().get().then().extract().path("Humidity");
		String WeatherDescription = httpRequest.given().contentType(ContentType.JSON).log().all().get().then().extract().path("WeatherDescription");
		response.prettyPrint();
		
		
		System.out.println("Humidity is " +humidity);
		System.out.println("WeatherDescription is " +WeatherDescription);
		
		
		
		
		
/*		// Response Object
	//	Response response = httpRequest.request(Method.GET,"/hyderabad");
			
		// print response
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : " +responseBody);
		
		// status code validation
		
		int statuscode = response.getStatusCode();
		System.out.println("Status code is: " +statuscode);
		
		Assert.assertEquals(statuscode, 200);
		
		String statusline = response.statusLine();
		System.out.println("Status Line is : " +statusline);
		
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");*/
		
	}
}
