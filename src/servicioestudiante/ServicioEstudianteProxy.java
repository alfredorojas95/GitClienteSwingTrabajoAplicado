package servicioestudiante;

public class ServicioEstudianteProxy implements servicioestudiante.ServicioEstudiante {
  private String _endpoint = null;
  private servicioestudiante.ServicioEstudiante servicioEstudiante = null;
  
  public ServicioEstudianteProxy() {
    _initServicioEstudianteProxy();
  }
  
  public ServicioEstudianteProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioEstudianteProxy();
  }
  
  private void _initServicioEstudianteProxy() {
    try {
      servicioEstudiante = (new servicioestudiante.ServicioEstudianteServiceLocator()).getServicioEstudiante();
      if (servicioEstudiante != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioEstudiante)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioEstudiante)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioEstudiante != null)
      ((javax.xml.rpc.Stub)servicioEstudiante)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public servicioestudiante.ServicioEstudiante getServicioEstudiante() {
    if (servicioEstudiante == null)
      _initServicioEstudianteProxy();
    return servicioEstudiante;
  }
  
  public java.lang.String[] buscarEst(java.lang.String rutEst) throws java.rmi.RemoteException{
    if (servicioEstudiante == null)
      _initServicioEstudianteProxy();
    return servicioEstudiante.buscarEst(rutEst);
  }
  
  public java.lang.String obtenerSituacionEstudiante(java.lang.String rutEstudiante) throws java.rmi.RemoteException{
    if (servicioEstudiante == null)
      _initServicioEstudianteProxy();
    return servicioEstudiante.obtenerSituacionEstudiante(rutEstudiante);
  }
  
  
}