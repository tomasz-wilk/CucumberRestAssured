package wilk.tomasz.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

public class MyStepdefs {

    private Response response;
    @When("I print aaa")
    public void iCallGetPostEndpoint(){
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri("https://jsonplaceholder.typicode.com/")
                .when()
                .get("/posts")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
    }

    @Then("Everything looks ok")
    public void iCallGetEndpoint(){
        assertThat(response.getBody().jsonPath()).isNotNull();
    }
}
