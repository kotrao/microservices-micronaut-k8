package io.apptor;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller("/orders")
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    private OrderRepository repository;

    public OrderController(OrderRepository repository)
    {
        this.repository = repository;
    }
    @Get("/by-customer/{customerId}")
    public List<Order> findByCustId(int customerId) {

        List<Order> ret =  this.repository.findOrdersByCustId(customerId);
        return ret;
    }
}
