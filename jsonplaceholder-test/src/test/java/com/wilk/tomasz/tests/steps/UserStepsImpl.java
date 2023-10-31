package com.wilk.tomasz.tests.steps;

import com.wilk.tomasz.service.data.DataGenerator;
import com.wilk.tomasz.service.endpoints.UserEndpoint;
import com.wilk.tomasz.service.dtos.PostDTO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class UserStepsImpl extends BaseSteps {

    @Autowired
    private UserEndpoint userEndpoint;

    @Given("^there is existing = (.+) user in application$")
    public void getUser(boolean userExists) {
        var userId = userExists ? DataGenerator.getExistingUserId() : DataGenerator.getNotExistingUserId();
        sharedContext.setUserId(userId);
        sharedContext.setResponse(userEndpoint.getUser(userId));
        var expStatusCode = userExists ? HttpStatus.SC_OK : HttpStatus.SC_NOT_FOUND;
        assertThat(sharedContext.getResponse().statusCode()).isEqualTo(expStatusCode);
    }

    @Given("there is existing user in application")
    public void getUser() {
        getUser(true);
    }

    @When("all posts for user are requested")
    public void getAllUserPosts() {
        sharedContext.setResponse(userEndpoint.getUserPosts(sharedContext.getUserId()));
    }

    @Then("^list of posts is returned not empty = (.+)$")
    public void verifyListOfPosts(boolean postsPresent) {
        assertThat(sharedContext.getResponse().statusCode()).isEqualTo(HttpStatus.SC_OK);
        var posts = sharedContext.getResponse().as(PostDTO[].class);
        assertThat(posts.length > 0).isEqualTo(postsPresent);
    }
}
