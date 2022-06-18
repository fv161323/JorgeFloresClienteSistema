/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.com.sistema.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sv.com.sistema.domain.Direccion;

@Path("/direccion")
@Stateless
public class ServiceDireccionRS {
    
    @Inject
    ServiceDireccion serviceDireccion;
    
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Direccion> listDireccion() {

        return serviceDireccion.listDireccion();
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response insertDireccion(Direccion direccion) {
        serviceDireccion.insertDireccion(direccion);
        return Response.ok().entity(direccion).build();
    }


    @DELETE
    @Path("{id}")
    public Response deleteDireccion(@PathParam("id") int id) {
        serviceDireccion.deleteDireccion(new Direccion(id));
        return Response.ok().build();
    }
}
