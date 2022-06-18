package sv.com.sistema.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.sistema.domain.Documento;

@Local
public interface DaoDocumento {
    
    public List<Documento> findAllDocumento();
    
    public Documento updateDocumento(Documento documento);
    
    public void deleteDocumento(Documento documento);
    
    public void insertDocumento(Documento documento);
   
    
}
