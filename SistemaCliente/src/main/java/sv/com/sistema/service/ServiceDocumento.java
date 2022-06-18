package sv.com.sistema.service;

import java.util.List;
import javax.ejb.Local;
import sv.com.sistema.domain.Documento;

@Local
public interface ServiceDocumento {
    
    public List<Documento> listDocumento();

    public Documento updateDocumento(Documento documento);

    public void deleteDocumento(Documento documento);

    public void insertDocumento(Documento documento);
    
}
