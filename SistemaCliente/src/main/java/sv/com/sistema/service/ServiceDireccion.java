
package sv.com.sistema.service;

import java.util.List;
import javax.ejb.Local;
import sv.com.sistema.domain.Direccion;

@Local
public interface ServiceDireccion {
    
    
    public List<Direccion> listDireccion();

    public Direccion updateDireccion(Direccion ireccion);

    public void deleteDireccion(Direccion direccion);

    public void insertDireccion(Direccion direccion);
}
