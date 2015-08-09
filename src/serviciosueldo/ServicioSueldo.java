/**
 * ServicioSueldo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package serviciosueldo;

public interface ServicioSueldo extends java.rmi.Remote {
    public java.lang.String consSueldoProf(java.lang.String rutProf) throws java.rmi.RemoteException;
    public java.lang.String registrarSueldoProf(java.lang.String rutProf, java.lang.String rutAdm, int mes) throws java.rmi.RemoteException;
}
