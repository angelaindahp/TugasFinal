package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class ApiStepDefinitions {
    private static final String BASE_URL = "https://dummyapi.io/data/api";
    private static final String APP_ID = "63a804408eb0cb069b57e43a";
    private Response response;
    private RequestSpecification request;

    @Given("API endpoint untuk mendapatkan user tersedia")
    public void api_endpoint_for_get_user() {
        RestAssured.baseURI = BASE_URL;
    }

    @When("Saya mengirim GET request untuk user dengan ID {string}")
    public void send_get_request_for_user(String userId) {
        response = given()
                .header("app-id", APP_ID)
                .when()
                .get("/user/" + userId);
    }

    @Then("Response harus mengandung informasi user")
    public void validate_user_response() {
        assertNotNull(response.jsonPath().getString("id"));
    }

    @Given("API endpoint untuk membuat user tersedia")
    public void api_endpoint_for_create_user() {
        RestAssured.baseURI = BASE_URL;
    }

    @When("Saya mengirim POST request dengan data user baru")
    public void send_post_request_for_user() {
        String requestBody = "{ \"firstName\": \"John\", \"lastName\": \"Doe\", \"email\": \"john.doe@example.com\" }";

        response = given()
                .header("app-id", APP_ID)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/user/create");
    }

    @Given("API endpoint untuk mendapatkan daftar tags tersedia")
    public void api_endpoint_for_get_tags() {
        RestAssured.baseURI = BASE_URL;
    }

    @When("Saya mengirim GET request ke endpoint tags")
    public void send_get_request_to_tags() {
        response = given()
                .header("app-id", APP_ID)
                .when()
                .get("/tag");
    }

    @Then("Response harus mengandung daftar tags")
    public void validate_tags_response() {
        assertNotNull(response.jsonPath().getList("data"));
    }
}

