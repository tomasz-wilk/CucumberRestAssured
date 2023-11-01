package com.wilk.tomasz.tests.steps;

import com.wilk.tomasz.service.data.DataGenerator;
import com.wilk.tomasz.service.endpoints.PostEndpoint;
import com.wilk.tomasz.service.dtos.CommentDTO;
import com.wilk.tomasz.service.dtos.PostDTO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class PostStepsImpl extends BaseSteps {

    @Autowired
    private PostEndpoint postEndpoint;

    @Given("there is existing post in application")
    public void getExistingPost() {
        var postId = DataGenerator.getExistingPostId();
        var response = postEndpoint.getPost(postId);
        sharedContext.setPostId(postId);
        sharedContext.setPost(response.as(PostDTO.class));
        assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);
    }

    @Given("there is not existing post in application")
    public void getNotExistingPost() {
        var postId = DataGenerator.getNotExistingPostId();
        sharedContext.setPostId(postId);
        sharedContext.setResponse(postEndpoint.getPost(postId));
        assertThat(sharedContext.getResponse().statusCode()).isEqualTo(HttpStatus.SC_NOT_FOUND);
    }

    @When("^user adds post with present fields: 'title' = (.+), 'body' = (.+)$")
    public void addPost(boolean titleAvailable, boolean bodyAvailable) {
        var userId = sharedContext.getUserId();
        var post = templates.createPost(userId, titleAvailable, bodyAvailable);
        sharedContext.setResponse(postEndpoint.addPost(post));
        sharedContext.setPost(post);
    }

    @When("^user updates post with present fields: 'title' = (.+), 'body' = (.+)$")
    public void updatePost(boolean titleAvailable, boolean bodyAvailable) {
        var newPost = templates.updatePost(sharedContext.getPost(), titleAvailable, bodyAvailable);
        sharedContext.setResponse(postEndpoint.updatePost(sharedContext.getPostId(), newPost));
        sharedContext.setPost(newPost);
    }

    @When("user removes post from application")
    public void removePost() {
        sharedContext.setResponse(postEndpoint.deletePost(sharedContext.getPostId()));
    }

    @When("all comments for post are requested")
    public void getPostComments() {
        sharedContext.setResponse(postEndpoint.getPostComments(sharedContext.getPostId()));
    }

    @Then("post is added with new values")
    public void commentShouldContainNewValues() {
        var actPost = sharedContext.getResponse().as(PostDTO.class);
        var expPost = sharedContext.getPost().toBuilder()
                .id(properties.getNewPostId())
                .build();
        assertThat(actPost).isEqualTo(expPost);
    }

    @Then("list of comments is returned not empty")
    public void verifyListOfCommentsNotEmpty() {
        assertThat(sharedContext.getResponse().statusCode()).isEqualTo(HttpStatus.SC_OK);
        var comments = sharedContext.getResponse().as(CommentDTO[].class);
        assertThat(comments).isNotEmpty();
    }

    @Then("post is updated with new values")
    public void verifyPostUpdatedWithNewValues() {
        var actPost = sharedContext.getResponse().as(PostDTO.class);
        var expPost = sharedContext.getPost().toBuilder()
                .id(sharedContext.getPostId())
                .build();
        assertThat(actPost).isEqualTo(expPost);
    }
}