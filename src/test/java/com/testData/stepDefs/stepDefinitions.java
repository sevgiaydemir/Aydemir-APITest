package com.testData.stepDefs;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class stepDefinitions {

    Response response;

    @Given("I have a valid url and endpoint")
    public void i_have_a_valid_url_and_endpoint() {
        Assert.assertNotNull(RestAssured.baseURI);
        Assert.assertNotNull(RestAssured.basePath);
    }

    @When("I send a get request with a valid gender query paramater")
    public void i_send_a_get_request_with_a_valid_gender_query_paramater() {
        Map<String, Object> parameterValues = new HashMap<>();
        parameterValues.put("gender", "female");
        response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParams(parameterValues).when().get();
        response.prettyPrint();
    }


    @Then("I should receive a response with the expected status code and header")
    public void i_should_receive_a_response_with_the_expected_status_code_and_header() {
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("application/json; charset=utf-8", response.contentType());
    }

    @Then("I should receive a response with expected data")
    public void i_should_receive_a_response_with_expected_data() {

        JsonPath jsonPath = response.jsonPath();
        List<Map<String, Object>> data = jsonPath.getList("results");
        for (Map<String, Object> stringObjectMap : data) {
            Assert.assertEquals("female", stringObjectMap.get("gender").toString().toLowerCase().trim());
        }

    }

    @When("I send a get request with a valid multiple user query paramater")
    public void i_send_a_get_request_with_a_valid_multiple_user_query_paramater() {
        Map<String, Object> parameterValues = new HashMap<>();
        parameterValues.put("results", "100");
        response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParams(parameterValues).when().get();


    }

    @Then("I should receive a response with expected count of data")
    public void i_should_receive_a_response_with_expected_count_of_data() {
        JsonPath jsonPath=response.jsonPath();
        List<Map<String, Object>> results = jsonPath.getList("results");
        Assert.assertEquals(100, results.size());
    }





}
