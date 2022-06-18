package sv.com.sistema.dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.sistema.domain.Direccion;

@Stateless
public class DaoDireccionImpl implements DaoDireccion {

    @PersistenceContext(unitName = "clientePU")
    EntityManager em;

    List<Direccion> direcciones = new ArrayList<Direccion>();

    @Override
    public List<Direccion> findaAllDireccion() {
        return direcciones = em.createNamedQuery("Direccion.findAll").getResultList();
    }

    @Override
    public Direccion updateDireccion(Direccion direccion) {
        return null;
    }

    @Override
    public void deleteDireccion(Direccion direccion) {
        em.remove(direccion);
    }

    @Override
    public void insertDireccion(Direccion direccion) {
        em.persist(direccion);
    }

}
