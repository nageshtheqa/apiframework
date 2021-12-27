package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Location;
import pojo.LocationPOJO;
import resources.APIResources;
import testdata.TestDataBuild;
import utilities.APIUtils;

public class AddPlaceStepDefs extends APIUtils {

	RequestSpecification reqSpec;
	//RequestSpecification reqSpec2;
	ResponseSpecification resSpec;
	Response response;
	TestDataBuild locpojo=new TestDataBuild();

	@Given("add place payload")
	public void add_place_payload() throws IOException {
		
		reqSpec=given().spec(requestSpecification()).
				body(locpojo.addPlacePayload("","",""));
		
	}
	
	@Given("^add place payload  with (.+) (.+) (.+)$")
    public void add_place_payload_with(String name, String language, String address) throws Throwable {
		reqSpec=given().spec(requestSpecification()).
				body(locpojo.addPlacePayload(name,language,address));
        //throw new PendingException();
    }

	@When("user calls {string} with post http request")
	public void user_calls_with_post_http_request(String string) {
		resSpec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 response = reqSpec.when().post("/maps/api/place/add/json").then().spec(resSpec).extract().response();

		String responseString = response.asString();
		System.out.println(responseString);

	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String apiResource, String methodType) {
		
		System.out.println("**************");
		APIResources resourceAPI=APIResources.valueOf(apiResource);
		
		resSpec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 response = reqSpec.when().post(resourceAPI.getAPIResource()).then().spec(resSpec).extract().response();
		 String responseString = response.asString();
			System.out.println(responseString);
	}

	@Then("status in response is OK")
	public void status_in_response_is_ok() {
		
		//Assert.assertEquals(response.getStatusCode(), 200);
		
		// Write code here that turns the phrase above into concrete actions
		//// throw new io.cucumber.java.PendingException();
	}

	@Then("API call should get status code as {int}")
	public void api_call_should_get_status_code_as(Object int1) {
		
	Assert.assertEquals(response.getStatusCode(), int1);
		System.out.println("*****"+int1);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
		String str=response.asString();
		JsonPath js = new JsonPath(str);
		js.get(keyValue).toString();
		Assert.assertEquals(js, expectedValue);
		System.out.println("*******"+js);
		
	}

	@Then("The {string} in response body is {string}")
	public void the_in_response_body_is(String scope, String expectedValue) {

		String str=response.asString();
		JsonPath js = new JsonPath(str);
		js.get(scope).toString();
		Assert.assertEquals(js, expectedValue);
		System.out.println("*******"+js);
		
	}

	@Then("API response body has {string}")
	public void api_response_body_has(String string) {
		
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
	}

	@Then("{string} Of API response body has {string}")
	public void of_api_response_body_has(String keyValue, String expectedValue) {
		System.out.println("keyValue "+keyValue);
		System.out.println("expectedValue "+expectedValue);
		String str=response.asString();
		System.out.println("Actual response*******"+str);
		
		JsonPath js = new JsonPath(str);
		String actualKeyValue=js.get(keyValue).toString();
		Assert.assertEquals(actualKeyValue, expectedValue);
		System.out.println("Actual value*******"+actualKeyValue);
	}
}
