/**
 * ServicioProfesorServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servicioprofesor;

public class ServicioProfesorServiceLocator extends org.apache.axis.client.Service implements servicioprofesor.ServicioProfesorService {

    public ServicioProfesorServiceLocator() {
    }


    public ServicioProfesorServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicioProfesorServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioProfesor
    private java.lang.String ServicioProfesor_address = "http://localhost:8080/ServicioTrabajoAplicado/services/ServicioProfesor";

    public java.lang.String getServicioProfesorAddress() {
        return ServicioProfesor_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioProfesorWSDDServiceName = "ServicioProfesor";

    public java.lang.String getServicioProfesorWSDDServiceName() {
        return ServicioProfesorWSDDServiceName;
    }

    public void setServicioProfesorWSDDServiceName(java.lang.String name) {
        ServicioProfesorWSDDServiceName = name;
    }

    public servicioprofesor.ServicioProfesor getServicioProfesor() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioProfesor_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioProfesor(endpoint);
    }

    public servicioprofesor.ServicioProfesor getServicioProfesor(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            servicioprofesor.ServicioProfesorSoapBindingStub _stub = new servicioprofesor.ServicioProfesorSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicioProfesorWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioProfesorEndpointAddress(java.lang.String address) {
        ServicioProfesor_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (servicioprofesor.ServicioProfesor.class.isAssignableFrom(serviceEndpointInterface)) {
                servicioprofesor.ServicioProfesorSoapBindingStub _stub = new servicioprofesor.ServicioProfesorSoapBindingStub(new java.net.URL(ServicioProfesor_address), this);
                _stub.setPortName(getServicioProfesorWSDDServiceName());
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
        if ("ServicioProfesor".equals(inputPortName)) {
            return getServicioProfesor();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servicioprofesor", "ServicioProfesorService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servicioprofesor", "ServicioProfesor"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioProfesor".equals(portName)) {
            setServicioProfesorEndpointAddress(address);
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
