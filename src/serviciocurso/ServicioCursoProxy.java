package serviciocurso;

public class ServicioCursoProxy implements serviciocurso.ServicioCurso {
  private String _endpoint = null;
  private serviciocurso.ServicioCurso servicioCurso = null;
  
  public ServicioCursoProxy() {
    _initServicioCursoProxy();
  }
  
  public ServicioCursoProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioCursoProxy();
  }
  
  private void _initServicioCursoProxy() {
    try {
      servicioCurso = (new serviciocurso.ServicioCursoServiceLocator()).getServicioCurso();
      if (servicioCurso != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioCurso)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioCurso)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioCurso != null)
      ((javax.xml.rpc.Stub)servicioCurso)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public serviciocurso.ServicioCurso getServicioCurso() {
    if (servicioCurso == null)
      _initServicioCursoProxy();
    return servicioCurso;
  }
  
  public java.lang.String[] buscarCurso(int id) throws java.rmi.RemoteException{
    if (servicioCurso == null)
      _initServicioCursoProxy();
    return servicioCurso.buscarCurso(id);
  }
  
  public java.lang.String crearCurso(java.lang.String nombreCurso, java.lang.String rutJefeAdm) throws java.rmi.RemoteException{
    if (servicioCurso == null)
      _initServicioCursoProxy();
    return servicioCurso.crearCurso(nombreCurso, rutJefeAdm);
  }
  
  public java.lang.String asignarProfesor(int id, java.lang.String rutProfe, java.lang.String rutJefeAdm) throws java.rmi.RemoteException{
    if (servicioCurso == null)
      _initServicioCursoProxy();
    return servicioCurso.asignarProfesor(id, rutProfe, rutJefeAdm);
  }
  
  public java.lang.String desactivarCurso(int id, java.lang.String rutDirector) throws java.rmi.RemoteException{
    if (servicioCurso == null)
      _initServicioCursoProxy();
    return servicioCurso.desactivarCurso(id, rutDirector);
  }
  
  public java.lang.String inscribirEstudiantes(int idCurso, java.lang.String rutEstudiante, java.lang.String rutProf) throws java.rmi.RemoteException{
    if (servicioCurso == null)
      _initServicioCursoProxy();
    return servicioCurso.inscribirEstudiantes(idCurso, rutEstudiante, rutProf);
  }
  
  
}