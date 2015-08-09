package serviciomensualidad;

public class ServicioMensualidadProxy implements serviciomensualidad.ServicioMensualidad {
  private String _endpoint = null;
  private serviciomensualidad.ServicioMensualidad servicioMensualidad = null;
  
  public ServicioMensualidadProxy() {
    _initServicioMensualidadProxy();
  }
  
  public ServicioMensualidadProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioMensualidadProxy();
  }
  
  private void _initServicioMensualidadProxy() {
    try {
      servicioMensualidad = (new serviciomensualidad.ServicioMensualidadServiceLocator()).getServicioMensualidad();
      if (servicioMensualidad != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioMensualidad)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioMensualidad)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioMensualidad != null)
      ((javax.xml.rpc.Stub)servicioMensualidad)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public serviciomensualidad.ServicioMensualidad getServicioMensualidad() {
    if (servicioMensualidad == null)
      _initServicioMensualidadProxy();
    return servicioMensualidad;
  }
  
  public java.lang.String regPagoMensualidad(java.lang.String rutEs, java.lang.String rutSc, int mes) throws java.rmi.RemoteException{
    if (servicioMensualidad == null)
      _initServicioMensualidadProxy();
    return servicioMensualidad.regPagoMensualidad(rutEs, rutSc, mes);
  }
  
  public java.lang.String obtenerListMorososMensualidad(int mes) throws java.rmi.RemoteException{
    if (servicioMensualidad == null)
      _initServicioMensualidadProxy();
    return servicioMensualidad.obtenerListMorososMensualidad(mes);
  }
  
  
}