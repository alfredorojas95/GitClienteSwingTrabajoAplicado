/**
 * ServicioCurso.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package serviciocurso;

public interface ServicioCurso extends java.rmi.Remote {
    public java.lang.String[] buscarCurso(int id) throws java.rmi.RemoteException;
    public java.lang.String crearCurso(java.lang.String nombreCurso, java.lang.String rutJefeAdm) throws java.rmi.RemoteException;
    public java.lang.String asignarProfesor(int id, java.lang.String rutProfe, java.lang.String rutJefeAdm) throws java.rmi.RemoteException;
    public java.lang.String desactivarCurso(int id, java.lang.String rutDirector) throws java.rmi.RemoteException;
    public java.lang.String inscribirEstudiantes(int idCurso, java.lang.String rutEstudiante, java.lang.String rutProf) throws java.rmi.RemoteException;
}
