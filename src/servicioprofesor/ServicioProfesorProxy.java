package servicioprofesor;

public class ServicioProfesorProxy implements servicioprofesor.ServicioProfesor {
  private String _endpoint = null;
  private servicioprofesor.ServicioProfesor servicioProfesor = null;
  
  public ServicioProfesorProxy() {
    _initServicioProfesorProxy();
  }
  
  public ServicioProfesorProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioProfesorProxy();
  }
  
  private void _initServicioProfesorProxy() {
    try {
      servicioProfesor = (new servicioprofesor.ServicioProfesorServiceLocator()).getServicioProfesor();
      if (servicioProfesor != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioProfesor)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioProfesor)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioProfesor != null)
      ((javax.xml.rpc.Stub)servicioProfesor)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public servicioprofesor.ServicioProfesor getServicioProfesor() {
    if (servicioProfesor == null)
      _initServicioProfesorProxy();
    return servicioProfesor;
  }
  
  public java.lang.String registrarAsistencia(java.lang.String rutEst, int idCurso, java.lang.String notaS, java.lang.String rutProf) throws java.rmi.RemoteException{
    if (servicioProfesor == null)
      _initServicioProfesorProxy();
    return servicioProfesor.registrarAsistencia(rutEst, idCurso, notaS, rutProf);
  }
  
  public java.lang.String registrarPromedio(java.lang.String rutEst, int idCurso, java.lang.String notaS, java.lang.String rutProf) throws java.rmi.RemoteException{
    if (servicioProfesor == null)
      _initServicioProfesorProxy();
    return servicioProfesor.registrarPromedio(rutEst, idCurso, notaS, rutProf);
  }
  
  public java.lang.String[] buscarProfe(java.lang.String rutProfe) throws java.rmi.RemoteException{
    if (servicioProfesor == null)
      _initServicioProfesorProxy();
    return servicioProfesor.buscarProfe(rutProfe);
  }
  
  
}