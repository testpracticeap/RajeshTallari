package RestAssuredProject.RestAssuredProject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HttpMethods {

	@Before
	public void setup()

	{
		RestAssured.baseURI = "https://reqres.in/api";
	}

	@Test
	public void GetRequest() {

		RestAssured.given().contentType(ContentType.JSON)

				.when().get("/users")

				.then().log().all().assertThat().statusCode(200).extract().response().asString();

	}

	@Test
	public void PostRequest() throws IOException {

		byte[] b = Files.readAllBytes(Paths.get("src/main/resources/Json/Test.json"));
		String Post_data = new String(b);

		RestAssured.given().contentType(ContentType.JSON).body(Post_data)

				.when().post("/users")

				.then().log().all().assertThat().statusCode(201).extract().response();

	}

	@Test
	public void PutRequest() throws IOException {

		byte[] b = Files.readAllBytes(Paths.get("src/main/resources/Json/Test.json"));
		String bdy = new String(b);

		Response response = given().header("Content-Type", "application/json").and().body(bdy)

				.when().put("/users/2")

				.then().log().all().assertThat().statusCode(200).extract().response();
		Assert.assertEquals(200, response.statusCode());
		Assert.assertEquals("rajesh@reqres.in", response.jsonPath().getString("email"));
		Assert.assertEquals("Rajesh", response.jsonPath().getString("first_name"));
		Assert.assertEquals("Tallari", response.jsonPath().getString("last_name"));
		Assert.assertEquals("https://image.jpg", response.jsonPath().getString("avatar"));

//
//		Assert.assertEquals(200, response.statusCode());
//		Assert.assertEquals("TEST", response.jsonPath().getString("name"));
//		Assert.assertEquals("tester", response.jsonPath().getString("job"));

	}

	@Test
	public void DeleteRequest() {

		RestAssured.given().contentType(ContentType.JSON)

				.when().delete("/users/2")

				.then().log().all().assertThat().statusCode(204).extract().response().asString();

	}

}