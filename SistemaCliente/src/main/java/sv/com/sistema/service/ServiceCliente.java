package sv.com.sistema.service;

import java.util.List;
import javax.ejb.Local;
import sv.com.sistema.domain.Cliente;

@Local
public interface ServiceCliente {

    public List<Cliente> listCliente();

    public Cliente updateCliente(Cliente cliente);

    public void deleteCliente(Cliente cliente);

    public void insertCliente(Cliente cliente);
    
    public Cliente findByIdCliente(Cliente cliente);
}
