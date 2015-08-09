package serviciosueldo;

public class ServicioSueldoProxy implements serviciosueldo.ServicioSueldo {
  private String _endpoint = null;
  private serviciosueldo.ServicioSueldo servicioSueldo = null;
  
  public ServicioSueldoProxy() {
    _initServicioSueldoProxy();
  }
  
  public ServicioSueldoProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioSueldoProxy();
  }
  
  private void _initServicioSueldoProxy() {
    try {
      servicioSueldo = (new serviciosueldo.ServicioSueldoServiceLocator()).getServicioSueldo();
      if (servicioSueldo != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioSueldo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioSueldo)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioSueldo != null)
      ((javax.xml.rpc.Stub)servicioSueldo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public serviciosueldo.ServicioSueldo getServicioSueldo() {
    if (servicioSueldo == null)
      _initServicioSueldoProxy();
    return servicioSueldo;
  }
  
  public java.lang.String consSueldoProf(java.lang.String rutProf) throws java.rmi.RemoteException{
    if (servicioSueldo == null)
      _initServicioSueldoProxy();
    return servicioSueldo.consSueldoProf(rutProf);
  }
  
  public java.lang.String registrarSueldoProf(java.lang.String rutProf, java.lang.String rutAdm, int mes) throws java.rmi.RemoteException{
    if (servicioSueldo == null)
      _initServicioSueldoProxy();
    return servicioSueldo.registrarSueldoProf(rutProf, rutAdm, mes);
  }
  
  
}