package com.wilk.tomasz.tests.steps;

import com.wilk.tomasz.service.data.DataGenerator;
import com.wilk.tomasz.service.endpoints.CommentEndpoint;
import com.wilk.tomasz.service.dtos.CommentDTO;
import com.wilk.tomasz.tests.SharedContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class CommentStepsImpl extends BaseSteps {

    @Autowired
    private SharedContext sharedContext;

    @Autowired
    private CommentEndpoint commentEndpoint;

    @Given("there is existing comment in application")
    public void getExistingComment() {
        var commentId = DataGenerator.getExistingCommentId();
        var response = commentEndpoint.getComment(commentId);
        sharedContext.setCommentId(commentId);
        sharedContext.setComment(response.as(CommentDTO.class));
        assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);
    }

    @When("^user adds comment with present fields: 'name' = (.+), 'email' = (.+), 'body' = (.+)$")
    public void addComment(boolean nameAvailable, boolean emailAvailable, boolean bodyAvailable) {
        var postId = sharedContext.getPostId();
        var comment = templates.createComment(postId, nameAvailable, emailAvailable, bodyAvailable);
        sharedContext.setResponse(commentEndpoint.addComment(comment));
        sharedContext.setComment(comment);
    }

    @When("^user updates comment with present fields: 'name' = (.+), 'email' = (.+), 'body' = (.+)$")
    public void updateComment(boolean nameAvailable, boolean emailAvailable, boolean bodyAvailable) {
        var oldComment = sharedContext.getComment();
        var newComment = oldComment.toBuilder()
                .postId(oldComment.postId())
                .name(nameAvailable ? DataGenerator.generateRandomName() : oldComment.name())
                .email(emailAvailable ? DataGenerator.generateRandomEmailAddress() : oldComment.email())
                .body(bodyAvailable ? DataGenerator.generateRandomBody() : oldComment.body())
                .build();
        sharedContext.setResponse(commentEndpoint.updateComment(sharedContext.getCommentId(), newComment));
        sharedContext.setComment(newComment);
    }

    @When("user updates comment with new values")
    public void updateExistingComment() {
        var postId = sharedContext.getPostId();
        var comment = templates.createComment(postId);
        sharedContext.setResponse(commentEndpoint.updateComment(sharedContext.getCommentId(), comment));
        sharedContext.setComment(comment);
    }

    @Then("comment is added with new values")
    public void verifyCommentAddedWithNewValues() {
        var actComment = sharedContext.getResponse().as(CommentDTO.class);
        var expComment = sharedContext.getComment().toBuilder()
                .id(properties.getNewCommentId())
                .build();
        assertThat(actComment).isEqualTo(expComment);
    }

    @Then("comment is updated with new values")
    public void verifyCommentUpdatedWithNewValues() {
        var actComment = sharedContext.getResponse().as(CommentDTO.class);
        var expComment = sharedContext.getComment().toBuilder()
                .id(sharedContext.getCommentId())
                .build();
        assertThat(actComment).isEqualTo(expComment);
    }

    @When("all comments are assigned to requested post")
    public void verifyListOfCommentsNotEmpty() {
        var expComments = commentEndpoint.getCommentsForPost(sharedContext.getPostId()).as(CommentDTO[].class);
        var actualComments = sharedContext.getResponse().as(CommentDTO[].class);
        assertThat(actualComments).containsExactlyInAnyOrder(expComments);
    }
}
