package sv.com.sistema.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sv.com.sistema.domain.Cliente;

@Path("/cliente")
@Stateless
public class ServiceClienteRS {

    @Inject
    private ServiceCliente serviceCliente;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> listCliente() {

        return serviceCliente.listCliente();
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response insertCliente(Cliente cliente) {
        serviceCliente.insertCliente(cliente);
        return Response.ok().entity(cliente).build();
    }

    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response updateCliente(@PathParam("id") int id, Cliente cliente) {

        serviceCliente.updateCliente(new Cliente(id));
        return Response.ok().entity(cliente).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCliente(@PathParam("id") int id) {
        serviceCliente.deleteCliente(new Cliente(id));
        return Response.ok().build();
    }

}
