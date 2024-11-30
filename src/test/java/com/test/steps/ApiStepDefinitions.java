package com.test.steps;

import com.test.hooks.MockAPIHook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiStepDefinitions {

    private String token;
    private Response response;

    @Given("I send a login request with username {string} and password {string}")
    public void iSendALoginRequest(String username, String password) {
        String baseUrl = MockAPIHook.getBaseUrl();

        response = given()
                .contentType("application/json")
                .body(String.format("{\"username\": \"%s\", \"password\": \"%s\"}", username, password))
                .post(baseUrl + "/api/login");

        token = response.jsonPath().getString("token");
    }

    @Then("I should get a valid token")
    public void iShouldGetAValidToken() {
        response.then().statusCode(200);
        assertEquals("valid-token", token, "Token should be valid-token");
    }

    @When("I send a request to fetch the product list with the token")
    public void iSendARequestToFetchTheProductList() {
        String baseUrl = MockAPIHook.getBaseUrl();

        response = given()
                .header("Authorization", token)
                .get(baseUrl + "/api/products");
    }

    @Then("I should get the product list response")
    public void iShouldGetTheProductListResponse() {
        response.then().statusCode(200);
        response.then().body("", hasSize(2));
        response.then().body("name", containsInAnyOrder("Product A", "Product B"));
    }
}
