package io.apptor;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Controller("/customers")
public class CustomerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    private CustomerRepository repository;
    private OrderClient orderClient;

    public CustomerController(CustomerRepository repository, OrderClient orderClient)
    {
        System.out.println("CustomerController");
        this.repository = repository;
        this.orderClient = orderClient;
    }
    @Get("/{id}")
    @Secured(SecurityRule.IS_ANONYMOUS)
    public Customer findById(int id) {

        LOGGER.debug("In CustomerController.findById");
        Customer customer =  this.repository.findById(id);
        if (customer != null) {
            LOGGER.debug("Trying to get order details");
            List orders = orderClient.findOrdersByCustId(id);

            LOGGER.debug("Got order details");
            orderClient.findOrdersByCustId(id);
            customer.setOrders(orders);
        }

        return customer;
    }

    @Get("/simple/{id}")
    @Secured(SecurityRule.IS_ANONYMOUS)
    public Customer findSimpleById(int id) {

        Customer customer =  this.repository.findById(id);
        return customer;
    }
}
