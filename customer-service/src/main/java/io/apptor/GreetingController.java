package io.apptor;

import io.micronaut.context.annotation.Property;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller("/greeting")
@ExecuteOn(TaskExecutors.IO)
public class GreetingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);

    @Property(name = "greeting.message")
    private String greeting;

    public GreetingController()
    {
    }
    @Get("/")
    public String getGreeting() {
        return greeting;
    }

}
