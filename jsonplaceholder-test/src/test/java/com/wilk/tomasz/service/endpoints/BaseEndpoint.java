package com.wilk.tomasz.service.endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import com.wilk.tomasz.configuration.TestProperties;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseEndpoint {

    @Autowired
    private TestProperties testProperties;

    protected RequestSpecification given() {
        return RestAssured
                .given()
                .baseUri(testProperties.getBaseUrl())
                .log().all()
                .contentType(ContentType.JSON);
    }
}
