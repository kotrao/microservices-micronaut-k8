package io.apptor;

import jakarta.inject.Singleton;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class OrderRepository {
    private Map<Integer, List<Order>> orders;

    public OrderRepository()
    {
    }
    @PostConstruct
    public void init()
    {
        this.orders = new HashMap<>();
        List<Order> orders = new ArrayList<>();

        orders.add(new Order(1, "Macbook Pro 2020", 1, 3000));
        orders.add(new Order(1, "HP Monitor", 1, 150));

        this.orders.put(1, orders);

    }

    public List<Order> findOrdersByCustId(int id)
    {
        return this.orders.get(id);
    }
}
