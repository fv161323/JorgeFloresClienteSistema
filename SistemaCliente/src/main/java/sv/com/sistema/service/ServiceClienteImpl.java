
package sv.com.sistema.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import sv.com.sistema.dao.DaoCliente;
import sv.com.sistema.domain.Cliente;

@Stateless
public class ServiceClienteImpl implements ServiceCliente{
    
    @Inject
    DaoCliente daoCliente;

    @Override
    public List<Cliente> listCliente() {
        return daoCliente.findaAllCliente();
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
       return daoCliente.updateCliente(cliente);
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        daoCliente.deleteCliente(cliente);
    }

    @Override
    public void insertCliente(Cliente cliente) {
        daoCliente.insertCliente(cliente);
    }

    @Override
    public Cliente findByIdCliente(Cliente cliente) {
        return daoCliente.findByIdCliente(cliente);
    }

  
    
}
