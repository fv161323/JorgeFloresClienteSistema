package sv.com.sistema.web;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.RowEditEvent;
import sv.com.sistema.domain.Cliente;
import sv.com.sistema.domain.Direccion;
import sv.com.sistema.domain.Documento;
import sv.com.sistema.service.ServiceCliente;
import sv.com.sistema.service.ServiceDireccion;
import sv.com.sistema.service.ServiceDocumento;

@Named
@RequestScoped
public class BeanCliente implements Serializable {

    @Inject
    ServiceCliente serviceCliente;

    @Inject
    ServiceDireccion serviceDireccion;

    @Inject
    ServiceDocumento serviceDocumento;

    private Cliente clienteSeleccionado;
    private Direccion direccion;
    private Documento documento;

    private List<Cliente> clientes;
    private List<Direccion> direcciones;
    private List<Documento> documentos;

    public BeanCliente() {
    }

    @PostConstruct
    public void inicializer() {
        clienteSeleccionado = new Cliente();
        direccion = new Direccion();
        documento = new Documento();
        clientes = serviceCliente.listCliente();
        direcciones = serviceDireccion.listDireccion();
        documentos = serviceDocumento.listDocumento();

    }

    public void insertCliente() {
        serviceDireccion.insertDireccion(direccion);
        serviceDocumento.insertDocumento(documento);
        clienteSeleccionado.setIdDocumento(documento);
        clienteSeleccionado.setIdDireccion(direccion);
        serviceCliente.insertCliente(clienteSeleccionado);

        clienteSeleccionado = new Cliente();
        documento = new Documento();
        direccion = new Direccion();
    }

    public void deleteCliente() {

        serviceCliente.deleteCliente(clienteSeleccionado);
        serviceDocumento.deleteDocumento(documento);
        serviceDireccion.deleteDireccion(direccion);

    }

    public void editListener(RowEditEvent event) {
        Cliente cliente = (Cliente) event.getObject();
        serviceCliente.updateCliente(cliente);
        cliente = new Cliente();
    }

    public void reiniciarClienteSeleccionado() {
        clienteSeleccionado = new Cliente();
    }

    public Cliente getClienteSeleccionado() {
        return clienteSeleccionado;
    }

    public void setClienteSeleccionado(Cliente clienteSeleccionado) {
        this.clienteSeleccionado = clienteSeleccionado;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    
    
}
