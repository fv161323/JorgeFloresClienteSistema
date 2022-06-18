package sv.com.sistema.service;

import java.util.List;
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
import sv.com.sistema.domain.Documento;

@Path("/documento")
public class ServiceDocumentoRS {

    @Inject
    ServiceDocumento serviceDocumento;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Documento> listDocumento() {

        return serviceDocumento.listDocumento();
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response insertDocumento(Documento documento) {
        serviceDocumento.insertDocumento(documento);
        return Response.ok().entity(documento).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteDocumento(@PathParam("id") int id) {
        serviceDocumento.deleteDocumento(new Documento(id));
        return Response.ok().build();
    }
}
