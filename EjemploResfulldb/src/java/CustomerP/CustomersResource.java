/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerP;
import DAO.IngresarDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.w3c.dom.Document;
import javax.inject.Singleton;
@Produces("application/xml")
@Path("customers")
@Singleton
public class CustomersResource {
 public CustomersResource() {
 }
 @GET
 @Path("list")
 public Document getCustomers() throws SQLException {
 IngresarDAO registro = new IngresarDAO();
 Customer customer=new Customer();
 customer.setOp(0);
 return registro.mostrar(customer);
 }
 @GET
 @Path("{id}")
 public Document getCustomer(@PathParam("id") int cId) throws SQLException {
 IngresarDAO registro = new IngresarDAO();
 Customer customer=new Customer();
 customer.setId(cId);
 customer.setOp(1);
 return registro.mostrar(customer);

 }
 @POST
 @Path("add")
 @Produces("application/JSON, application/xml")
 @Consumes("application/JSON, application/xml")
 public Customer addCustomer(Customer customer) throws IOException {

 IngresarDAO registro = new IngresarDAO();
 registro.ingresar(customer);
 return customer;
}
 @DELETE
 @Path("{id}")
 public void deleteCustomer(@PathParam("id") int id) throws IOException {
 IngresarDAO registro = new IngresarDAO();
 Customer customer=new Customer();
 customer.setId(id);
 registro.eliminar(customer);

 }
 @PUT
 @Path("update")
 @Produces("application/JSON, application/xml")
 @Consumes("application/JSON, application/xml")
 public Customer updateCustomer(Customer customer) throws IOException {
 IngresarDAO registro = new IngresarDAO();
 registro.actualizar(customer);
 return customer;
 }
}