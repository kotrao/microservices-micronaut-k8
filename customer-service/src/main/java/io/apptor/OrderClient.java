package io.apptor;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

import javax.management.relation.Role;
import java.util.List;

@Client(id="ordersvc", path="/orders")
public interface OrderClient {
    @Get("/by-customer/{customerId}")
    List<Order> findOrdersByCustId(int customerId);
}
