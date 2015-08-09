/**
 * ServicioEstudiante.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servicioestudiante;

public interface ServicioEstudiante extends java.rmi.Remote {
    public java.lang.String[] buscarEst(java.lang.String rutEst) throws java.rmi.RemoteException;
    public java.lang.String obtenerSituacionEstudiante(java.lang.String rutEstudiante) throws java.rmi.RemoteException;
}
