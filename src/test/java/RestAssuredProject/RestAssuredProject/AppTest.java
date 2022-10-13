package RestAssuredProject.RestAssuredProject;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.AfterTest;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class AppTest 
{
	    @Test
		public void GetUsersDetails() {

			RestAssured.baseURI = "https://reqres.in/api/users";
			RequestSpecification httpreq = RestAssured.given();
			Response response = httpreq.request(Method.GET, "");
			Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
			System.out.println(response.getStatusLine());
			System.out.println(response.asString());

			//validating the status code
			response = httpreq.get("");
			// Postive case
			int statusCode = response.getStatusCode();
			Assert.assertEquals("The status Code", statusCode, 200);
			System.out.println(statusCode);
			
		}
	    
	    @Test
		public void GetUsersDetailsNegative() {

			RestAssured.baseURI = "https://reqres.in/api/users";
			RequestSpecification httpreq = RestAssured.given();
			Response response = httpreq.request(Method.GET, "");
            
			//validating error status code
			response = httpreq.get("$%%%%");
			// Postive case
			int statusCode = response.getStatusCode();
			Assert.assertEquals("The status Code", statusCode, 404);
			System.out.println(statusCode);

		}
	    
	    @Test
		public void GetUsersDetailsHeaderResponse() {

			RestAssured.baseURI = "https://reqres.in/api/users";
			RequestSpecification httpreq = RestAssured.given();
			Response response = httpreq.request(Method.GET, "");

			//validating response header
			response = httpreq.get("");

			Headers header = response.headers();

			for (Header headersec : header) {

				System.out.println("value " + headersec.getName() + " " + ":" + headersec.getValue());
			}
		}
	    
	    @Test
		public void GetUsersDetailsHeaderResponseoneAtaTime() {

			RestAssured.baseURI = "https://reqres.in/api/users";
			RequestSpecification httpreq = RestAssured.given();
			Response response = httpreq.request(Method.GET, "");

			response = httpreq.get("");

			String header = response.header("Server");
			System.out.println(header);
			String header1 = response.header("Content-Type");
			System.out.println(header1);

		}
	    
	    @Test
		public void GetUsersDetailsResponseBody() {

			RestAssured.baseURI = "https://reqres.in/api/users";
			RequestSpecification httpreq = RestAssured.given();
			Response response = httpreq.request(Method.GET, "");

			response = httpreq.get("");

			ResponseBody resbody = response.getBody();

			System.out.println(resbody.asString());

		}
	    
	    @Test
		public void GetUsersDetailsResponseBodyvalidation() {

			RestAssured.baseURI = "https://reqres.in/api/users";
			RequestSpecification httpreq = RestAssured.given();
			Response response = httpreq.request(Method.GET, "");

			response = httpreq.get("");

			ResponseBody resbody = response.getBody();

			String response1 = resbody.asString();
			Assert.assertEquals(response1.toLowerCase().contains("Bluth"), false);

		}
	 

		@Test
		public void GetUsers_JsonPath() {
			// <--------------Setup API---------------------->
			RestAssured.baseURI = "https://reqres.in/api/register";
			RequestSpecification httpreq = RestAssured.given();
			Response response = httpreq.request(Method.GET, "");
			// <------------------------------------------------>
			response = httpreq.get("");
			JsonPath JP = response.jsonPath();
			System.out.println(JP.getString("data[1]"));

			Object subject = com.jayway.jsonpath.JsonPath.read(response.asString(), "$.data[0]");
			System.out.println(subject);
			System.out.println(subject.toString());

		}

		@Test
		public void GetUsersDetailsqueryparam() {

			RestAssured.baseURI = "https://reqres.in/api";
			RequestSpecification httpreq = RestAssured.given();
			Response response = httpreq.queryParam("first_name", "George").get("/users");
			ResponseBody body = response.body();
			ResponseBody resbody = response.getBody();
			String response1 = resbody.asString();
			JsonPath jpath = new JsonPath(response1);
			String title = jpath.getString("title");
			System.out.println(title);

		}


   
}
