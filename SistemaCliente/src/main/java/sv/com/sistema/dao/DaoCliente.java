
package sv.com.sistema.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.sistema.domain.Cliente;

@Local
public interface DaoCliente {
 
      
    public List<Cliente> findaAllCliente();
    
    public Cliente updateCliente(Cliente cliente);
    
    public void deleteCliente(Cliente cliente);
    
    public void insertCliente(Cliente cliente);
    
    public Cliente findByIdCliente(Cliente cliente);
    
}
