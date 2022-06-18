
package sv.com.sistema.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.sistema.domain.Direccion;

@Local
public interface DaoDireccion {
        
    public List<Direccion> findaAllDireccion();
    
    public Direccion updateDireccion(Direccion direccion);
    
    public void deleteDireccion(Direccion direccion);
    
    public void insertDireccion(Direccion direccion);
}
