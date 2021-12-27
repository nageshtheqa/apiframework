package utilities;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Location;
import pojo.LocationPOJO;


public class APIUtils{
	public static RequestSpecification reqSpec;
	String propValue;
	
	
	public RequestSpecification requestSpecification() throws IOException {
		
		if(reqSpec==null) {
		PrintStream printLog= new PrintStream(new FileOutputStream("logging.txt"));
	
		
	reqSpec = new RequestSpecBuilder().setBaseUri(getPropValue("baseUrl"))
			.addQueryParam("key", "qaclick123")
			.addFilter(RequestLoggingFilter.logRequestTo(printLog))
			.addFilter(ResponseLoggingFilter.logResponseTo(printLog))
			.setContentType(ContentType.JSON).build();

		}	return reqSpec;
	}

	public String getPropValue(String propKey) throws IOException {
		Properties props =  new Properties();
		FileInputStream file = new FileInputStream("src/test/java/resources/global_properties.properties");
		props.load(file);
		System.out.println("property= "+propKey+" : value="+props.getProperty(propKey));
		propValue=props.getProperty(propKey);
		return propValue;
	}
}
