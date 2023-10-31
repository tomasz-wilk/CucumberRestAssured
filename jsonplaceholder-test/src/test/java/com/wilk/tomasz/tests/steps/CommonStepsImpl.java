package com.wilk.tomasz.tests.steps;

import io.cucumber.java.en.Then;
import org.apache.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonStepsImpl extends BaseSteps {

    @Then("post is added successfully")
    @Then("comment is added successfully")
    public void itemAddedWithSuccess() {
        assertThat(sharedContext.getResponse().statusCode()).isEqualTo(HttpStatus.SC_CREATED);
    }

    @Then("update operation succeeds")
    @Then("delete operation succeeds")
    public void operationSucceeds() {
        assertThat(sharedContext.getResponse().statusCode()).isEqualTo(HttpStatus.SC_OK);
    }
}
