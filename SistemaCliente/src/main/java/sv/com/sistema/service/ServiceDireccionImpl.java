
package sv.com.sistema.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import sv.com.sistema.dao.DaoDireccion;
import sv.com.sistema.domain.Direccion;

@Stateless
public class ServiceDireccionImpl implements ServiceDireccion {

    
    @Inject
    DaoDireccion daoDireccion;
    
    @Override
    public List<Direccion> listDireccion() {
        return daoDireccion.findaAllDireccion();
    }

    @Override
    public Direccion updateDireccion(Direccion ireccion) {
        return null;
    }

    @Override
    public void deleteDireccion(Direccion direccion) {
        daoDireccion.deleteDireccion(direccion);
    }

    @Override
    public void insertDireccion(Direccion direccion) {
        daoDireccion.insertDireccion(direccion);
    }
    
}
