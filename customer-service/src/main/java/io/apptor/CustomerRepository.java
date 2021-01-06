package io.apptor;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class CustomerRepository {
    private Map<Integer, Customer> customers;

    public CustomerRepository()
    {
    }
    @PostConstruct
    public void init()
    {
        this.customers = new HashMap<>();
        this.customers.put(1, new Customer(1, "Ramesh", "L"));
        this.customers.put(2, new Customer(2, "John", "Marshal"));
        this.customers.put(3, new Customer(3, "Keshav", "K"));
    }

    public Customer findById(int id)
    {
        return this.customers.get(id);
    }
}
