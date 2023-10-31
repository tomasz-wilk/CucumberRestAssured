package com.wilk.tomasz.configuration;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:common.properties")
public interface TestProperties extends Config {

    @Key("baseUrl")
    String getBaseUrl();

    @Key("newPostId")
    Integer getNewPostId();

    @Key("newCommentId")
    Integer getNewCommentId();
}
