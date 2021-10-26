package io.apptor;

import io.apptor.productmgmt.sdk.clients.IRoleClient;
import io.apptor.productmgmt.sdk.models.Role;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Controller("/customers")
@ExecuteOn(TaskExecutors.IO)
public class CustomerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    private CustomerRepository repository;
    private OrderClient orderClient;
    private IRoleClient roleClient;


    public CustomerController(CustomerRepository repository, OrderClient orderClient, IRoleClient roleClient)
    {
        System.out.println("CustomerController");
        this.repository = repository;
        this.orderClient = orderClient;
        this.roleClient = roleClient;
    }
    @Get("/{id}")
    public Customer findById(int id) {

        LOGGER.debug("In CustomerController.findById");
        Customer customer =  this.repository.findById(id);
        if (customer != null) {
            LOGGER.debug("Trying to get order details");
            List orders = orderClient.findOrdersByCustId(id);

            LOGGER.debug("Got order details");
            customer.setOrders(orders);
        }

        return customer;
    }

    @Get("/simple/{id}")
    public Customer findSimpleById(int id) {

        Customer customer =  this.repository.findById(id);
        return customer;
    }
    @Get("/product/{id}")
    public List<Role> findRoles(long id) {

        LOGGER.debug("In CustomerController.findRoles");

        String accessToken = "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYW8uY2hlamFybGFAZXhwZWVkc29mdHdhcmUuY29tIiwibGFzdE5hbWUiOiJDaGVqYXJsYSIsImNsaWVudElkIjo1MTcsInByb2R1Y3RJZCI6MCwicm9sZXMiOltdLCJpc3MiOiJ1c2VybWdtdC1hcGkiLCJ1c2VyTmFtZSI6InJhby5jaGVqYXJsYUBleHBlZWRzb2Z0d2FyZS5jb20iLCJ1c2VySWQiOjYyOSwiZmlyc3ROYW1lIjoiUmFvIiwibmJmIjoxNjM1MTc5NjIzLCJleHAiOjE2MzYwNDM2MjMsImlhdCI6MTYzNTE3OTYyM30.cd3bALJOloLahKtiTvn5I0I-uiIg_ds9JzXKYkpIvKc";
        List<Role> lstRoles = roleClient.getDefaultRolesByProductId(id, accessToken);

        return lstRoles;
    }
}
