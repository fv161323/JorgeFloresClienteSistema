
package sv.com.sistema.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.sistema.domain.Documento;

@Stateless
public class DaoDocumentoImpl implements DaoDocumento {

    @PersistenceContext(unitName = "clientePU")
    EntityManager em;
    
    
    @Override
    public List<Documento> findAllDocumento() {
        return em.createNamedQuery("Documento.findAll").getResultList();
    }

    @Override
    public Documento updateDocumento(Documento documento) {
        return null;
    }

    @Override
    public void deleteDocumento(Documento documento) {
        em.remove(documento);
    }

    @Override
    public void insertDocumento(Documento documento) {
        em.persist(documento);
    }
    
    
    
    
}
