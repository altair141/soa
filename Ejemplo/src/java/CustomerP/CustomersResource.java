/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerP;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.inject.Singleton;

@Produces("application/xml")
@Path("customers")
@Singleton
public class CustomersResource {

    private TreeMap<Integer, Customer> customerMap = new TreeMap<Integer, Customer>();

    public CustomersResource() {
        Customer customer = new Customer();
        customer.setName("Harold Abernathy");
        customer.setAddress("Sheffield, UK");
        addCustomer(customer);
    }

    @GET
    @Path("list")
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        customers.addAll(customerMap.values());
        return customers;
    }

    @GET
    @Path("{id}")
    public Customer getCustomer(@PathParam("id") int cId) {
        return customerMap.get(cId);
    }

    @POST
    @Path("add")
    @Produces(" application/xml")
    @Consumes("application/xml")
    public Customer addCustomer(Customer customer) {
        int id = customerMap.size();
        customer.setId(id);
        customerMap.put(id, customer);
        return customerMap.get(id);
    }

    @POST
    @Path("add/{name}/{address}")
    @Produces("application/xml")
    @Consumes("application/xml")
    public Customer addCustomerSingle(@PathParam("name") String name, @PathParam("address") String address) {
        int id = customerMap.size();
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        customer.setId(id);
        customerMap.put(id, customer);
        return customerMap.get(id);
    }

    @DELETE
    @Path("{id}")
    public void deleteCustomer(@PathParam("id") int cId) {
        customerMap.remove(cId);

    }

    @PUT
    @Path("{id}/{name}/{address}")
    @Produces("application/xml")
    @Consumes("application/xml")
    public void updateCustomer(@PathParam("id") int id, @PathParam("name") String name, @PathParam("address") String address) {
        Customer customer = customerMap.get(id);
        customer.setName(name);
        customer.setAddress(address);
        customerMap.put(id, customer);
    }
}
