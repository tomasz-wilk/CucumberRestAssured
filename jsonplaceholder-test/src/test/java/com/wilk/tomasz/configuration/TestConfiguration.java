package com.wilk.tomasz.configuration;

import com.wilk.tomasz.service.data.DataTemplates;
import com.wilk.tomasz.service.endpoints.CommentEndpoint;
import com.wilk.tomasz.service.endpoints.PostEndpoint;
import com.wilk.tomasz.service.endpoints.UserEndpoint;
import com.wilk.tomasz.tests.SharedContext;
import org.aeonbits.owner.ConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TestConfiguration {

    @Bean
    public TestProperties testProperties() {
        return ConfigFactory.create(TestProperties.class);
    }

    @Bean
    @Scope("cucumber-glue")
    public SharedContext sharedContext() {
        return new SharedContext();
    }

    @Bean
    public DataTemplates templates(){
        return new DataTemplates();
    }

    @Bean
    public PostEndpoint postEndpoint(){
        return new PostEndpoint();
    }

    @Bean
    public UserEndpoint userEndpoint(){
        return new UserEndpoint();
    }

    @Bean
    public CommentEndpoint commentEndpoint(){
        return new CommentEndpoint();
    }
}
