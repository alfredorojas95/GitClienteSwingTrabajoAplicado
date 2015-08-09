/**
 * ServicioEstudianteServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servicioestudiante;

public class ServicioEstudianteServiceLocator extends org.apache.axis.client.Service implements servicioestudiante.ServicioEstudianteService {

    public ServicioEstudianteServiceLocator() {
    }


    public ServicioEstudianteServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicioEstudianteServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioEstudiante
    private java.lang.String ServicioEstudiante_address = "http://localhost:8080/ServicioTrabajoAplicado/services/ServicioEstudiante";

    public java.lang.String getServicioEstudianteAddress() {
        return ServicioEstudiante_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioEstudianteWSDDServiceName = "ServicioEstudiante";

    public java.lang.String getServicioEstudianteWSDDServiceName() {
        return ServicioEstudianteWSDDServiceName;
    }

    public void setServicioEstudianteWSDDServiceName(java.lang.String name) {
        ServicioEstudianteWSDDServiceName = name;
    }

    public servicioestudiante.ServicioEstudiante getServicioEstudiante() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioEstudiante_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioEstudiante(endpoint);
    }

    public servicioestudiante.ServicioEstudiante getServicioEstudiante(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            servicioestudiante.ServicioEstudianteSoapBindingStub _stub = new servicioestudiante.ServicioEstudianteSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicioEstudianteWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioEstudianteEndpointAddress(java.lang.String address) {
        ServicioEstudiante_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (servicioestudiante.ServicioEstudiante.class.isAssignableFrom(serviceEndpointInterface)) {
                servicioestudiante.ServicioEstudianteSoapBindingStub _stub = new servicioestudiante.ServicioEstudianteSoapBindingStub(new java.net.URL(ServicioEstudiante_address), this);
                _stub.setPortName(getServicioEstudianteWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServicioEstudiante".equals(inputPortName)) {
            return getServicioEstudiante();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servicioestudiante", "ServicioEstudianteService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servicioestudiante", "ServicioEstudiante"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioEstudiante".equals(portName)) {
            setServicioEstudianteEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
