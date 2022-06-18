package sv.com.sistema.dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.sistema.domain.Cliente;

@Stateless
public class DaoClienteImpl implements DaoCliente {

    @PersistenceContext(unitName = "clientePU")
    EntityManager em;

    List<Cliente> clientes = new ArrayList<Cliente>();

    @Override
    public List<Cliente> findaAllCliente() {
        return clientes = em.createNamedQuery("Cliente.findAll").getResultList();
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {

        return em.merge(cliente);
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        em.remove(em.merge(cliente));
    }

    @Override
    public void insertCliente(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public Cliente findByIdCliente(Cliente cliente) {
        return null;
    }

}
