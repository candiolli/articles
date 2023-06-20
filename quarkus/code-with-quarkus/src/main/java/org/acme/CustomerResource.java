package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.data.CustomerData;
import org.acme.model.Customer;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    CustomerData customerData;

    @GET
    @Path("/{uuid}")
    public Response hello(UUID uuid) {
        Optional<Customer> customer = customerData.find(uuid);
        if (customer.isEmpty())
            return Response.noContent().build();

        return Response.ok(customer.get()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(customerData.findAll()).build();
    }

    @POST
    public Response create(Customer customer) {
        Customer customerCreated = customerData.create(customer);
        return Response.created(URI.create("/customers/" + customerCreated.getId().toString())).build();
    }
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }
}
