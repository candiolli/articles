package org.acme.data;

import jakarta.inject.Singleton;
import org.acme.model.Customer;

import java.util.*;

@Singleton
public class CustomerData {

    private Set<Customer> customersData = Collections.synchronizedSet(new LinkedHashSet<>());;

    /**
     * Our startup data
     */
    public CustomerData() {
        customersData.add(new Customer(UUID.randomUUID(), "John", "joao@gmail.com"));
        customersData.add(new Customer(UUID.randomUUID(), "Silas", "silas@gmail.com"));
    }

    public Customer create(Customer customer) {
        Customer customerCreated = new Customer(UUID.randomUUID(), customer.getName(), customer.getEmail());
        customersData.add(customerCreated);
        return customerCreated;
    }

    public Optional<Customer> find(UUID uuid) {
        return customersData.stream().filter(c -> c.getId().equals(uuid)).findFirst();
    }

    public Collection<Customer> findAll() {
        return customersData;
    }
}
