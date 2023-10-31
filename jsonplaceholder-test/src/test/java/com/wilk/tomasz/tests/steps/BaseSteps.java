package com.wilk.tomasz.tests.steps;

import com.wilk.tomasz.configuration.TestProperties;
import com.wilk.tomasz.service.data.DataTemplates;
import com.wilk.tomasz.tests.SharedContext;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseSteps {

    @Autowired
    protected SharedContext sharedContext;

    @Autowired
    protected DataTemplates templates;

    @Autowired
    protected TestProperties properties;
}
