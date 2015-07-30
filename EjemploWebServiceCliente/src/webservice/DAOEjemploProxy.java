package webservice;

public class DAOEjemploProxy implements webservice.DAOEjemplo {
  private String _endpoint = null;
  private webservice.DAOEjemplo dAOEjemplo = null;
  
  public DAOEjemploProxy() {
    _initDAOEjemploProxy();
  }
  
  public DAOEjemploProxy(String endpoint) {
    _endpoint = endpoint;
    _initDAOEjemploProxy();
  }
  
  private void _initDAOEjemploProxy() {
    try {
      dAOEjemplo = (new webservice.DAOEjemploServiceLocator()).getDAOEjemplo();
      if (dAOEjemplo != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)dAOEjemplo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)dAOEjemplo)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dAOEjemplo != null)
      ((javax.xml.rpc.Stub)dAOEjemplo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public webservice.DAOEjemplo getDAOEjemplo() {
    if (dAOEjemplo == null)
      _initDAOEjemploProxy();
    return dAOEjemplo;
  }
  
  public java.lang.String saludar(java.lang.String nombre) throws java.rmi.RemoteException{
    if (dAOEjemplo == null)
      _initDAOEjemploProxy();
    return dAOEjemplo.saludar(nombre);
  }
  
  
}