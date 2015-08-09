/**
 * ServicioMatriculaServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package serviciomatricula;

public class ServicioMatriculaServiceLocator extends org.apache.axis.client.Service implements serviciomatricula.ServicioMatriculaService {

    public ServicioMatriculaServiceLocator() {
    }


    public ServicioMatriculaServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicioMatriculaServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioMatricula
    private java.lang.String ServicioMatricula_address = "http://localhost:8080/ServicioTrabajoAplicado/services/ServicioMatricula";

    public java.lang.String getServicioMatriculaAddress() {
        return ServicioMatricula_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioMatriculaWSDDServiceName = "ServicioMatricula";

    public java.lang.String getServicioMatriculaWSDDServiceName() {
        return ServicioMatriculaWSDDServiceName;
    }

    public void setServicioMatriculaWSDDServiceName(java.lang.String name) {
        ServicioMatriculaWSDDServiceName = name;
    }

    public serviciomatricula.ServicioMatricula getServicioMatricula() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioMatricula_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioMatricula(endpoint);
    }

    public serviciomatricula.ServicioMatricula getServicioMatricula(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            serviciomatricula.ServicioMatriculaSoapBindingStub _stub = new serviciomatricula.ServicioMatriculaSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicioMatriculaWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioMatriculaEndpointAddress(java.lang.String address) {
        ServicioMatricula_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (serviciomatricula.ServicioMatricula.class.isAssignableFrom(serviceEndpointInterface)) {
                serviciomatricula.ServicioMatriculaSoapBindingStub _stub = new serviciomatricula.ServicioMatriculaSoapBindingStub(new java.net.URL(ServicioMatricula_address), this);
                _stub.setPortName(getServicioMatriculaWSDDServiceName());
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
        if ("ServicioMatricula".equals(inputPortName)) {
            return getServicioMatricula();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://serviciomatricula", "ServicioMatriculaService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://serviciomatricula", "ServicioMatricula"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioMatricula".equals(portName)) {
            setServicioMatriculaEndpointAddress(address);
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
