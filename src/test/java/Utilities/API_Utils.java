package Utilities;

import java.io.IOException;
import org.json.JSONObject;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class API_Utils {

	ConfigFileReader config = null;
	 

	public JsonPath getRequestForBoard(String BoardName) throws IOException {
		config = new ConfigFileReader();
		String EndpointURL = config.getBoardBaseURL() + BoardName;
		RequestSpecification httpRequest = RestAssured.given().queryParam("key", config.getAPIKey())
				.queryParam("token", config.getToken()).when();
		Response response = httpRequest.get(EndpointURL).then().contentType(ContentType.JSON).extract().response();
		Assert.assertEquals(response.getStatusCode(),200);
		JsonPath json = response.jsonPath();
		return json;
	}

	public JsonPath postRequestForBoardCreation(String BoardName) throws IOException {
		config = new ConfigFileReader();
		String EndpointURL = config.getBoardBaseURL();
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.queryParam("name", BoardName);
		httpRequest.queryParam("key", config.getAPIKey());
		httpRequest.queryParam("token", config.getToken());
		httpRequest.contentType("application/json");
		httpRequest.accept("application/json");
		Response response = httpRequest.post(EndpointURL);
		Assert.assertEquals(response.getStatusCode(),200);
		JsonPath json = response.jsonPath();
		return json;
	}
	
	public JsonPath postRequestForListCreation(String ListName,String BoardID) throws IOException {
		config = new ConfigFileReader();
		String EndpointURL = config.getCreateListURL();
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.queryParam("name", ListName);
		httpRequest.queryParam("idBoard", BoardID);
		httpRequest.queryParam("key", config.getAPIKey());
		httpRequest.queryParam("token", config.getToken());
		httpRequest.contentType("application/json");
		httpRequest.accept("application/json");
		Response response = httpRequest.post(EndpointURL);
		Assert.assertEquals(response.getStatusCode(),200);
		JsonPath json = response.jsonPath();
		return json;
	}
	
	public JsonPath postRequestForcardCreation(String CardName,String ListId) throws IOException {
		config = new ConfigFileReader();
		JSONObject requestParams = new JSONObject();
		String EndpointURL = config.getCreateCardURL();
		RequestSpecification httpRequest = RestAssured.given();
		requestParams.put("name", CardName);
		httpRequest.queryParam("idList", ListId);
		httpRequest.queryParam("key", config.getAPIKey());
		httpRequest.queryParam("token", config.getToken());
		httpRequest.contentType("application/json");
		httpRequest.accept("application/json");
		httpRequest.body(requestParams.toString());
		Response response = httpRequest.post(EndpointURL);
		Assert.assertEquals(response.getStatusCode(),200);
		JsonPath json = response.jsonPath();
		return json;
	}
	

	public void deleteRequestForBoardDeletion(String BoardName) throws IOException {
		config = new ConfigFileReader();
		String EndpointURL = config.getBoardBaseURL() + BoardName;
		RequestSpecification httpRequest = RestAssured.given().queryParam("key", config.getAPIKey())
				.queryParam("token", config.getToken()).when();
		Response response = httpRequest.delete(EndpointURL);
		Assert.assertEquals(response.getStatusCode(),200);
	}


}
