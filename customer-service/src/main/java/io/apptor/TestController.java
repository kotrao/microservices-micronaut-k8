package io.apptor;

import io.micronaut.discovery.DiscoveryClient;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.kubernetes.client.rxjava2.CoreV1ApiRxClient;
import org.reactivestreams.Publisher;

import java.util.List;

@Controller("/test")
public class TestController {
    private final DiscoveryClient discoveryClient;
    private final CoreV1ApiRxClient client;


    public TestController(CoreV1ApiRxClient client, DiscoveryClient discoveryClient) {
        this.client = client;
        this.discoveryClient = discoveryClient;
    }

    @Get("/all")
    public Publisher<List<String>> all() {
        System.out.println("TestController.all - DiscoveryClient:" + discoveryClient.getClass().getCanonicalName());
        return discoveryClient.getServiceIds();
    }

}
