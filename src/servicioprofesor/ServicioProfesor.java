/**
 * ServicioProfesor.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servicioprofesor;

public interface ServicioProfesor extends java.rmi.Remote {
    public java.lang.String registrarAsistencia(java.lang.String rutEst, int idCurso, java.lang.String notaS, java.lang.String rutProf) throws java.rmi.RemoteException;
    public java.lang.String registrarPromedio(java.lang.String rutEst, int idCurso, java.lang.String notaS, java.lang.String rutProf) throws java.rmi.RemoteException;
    public java.lang.String[] buscarProfe(java.lang.String rutProfe) throws java.rmi.RemoteException;
}
