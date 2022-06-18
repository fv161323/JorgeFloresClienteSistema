
package sv.com.sistema.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import sv.com.sistema.dao.DaoDocumento;
import sv.com.sistema.domain.Documento;

@Stateless
public class ServiceDocumentoImpl implements ServiceDocumento{

    @Inject
    DaoDocumento daoDocumento;
    
    @Override
    public List<Documento> listDocumento() {
        return daoDocumento.findAllDocumento();
    }

    @Override
    public Documento updateDocumento(Documento documento) {
        return null;
    }

    @Override
    public void deleteDocumento(Documento documento) {
        daoDocumento.deleteDocumento(documento);
    }

    @Override
    public void insertDocumento(Documento documento) {
    daoDocumento.insertDocumento(documento);
    }
    
}
