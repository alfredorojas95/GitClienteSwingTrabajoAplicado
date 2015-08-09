/**
 * ServicioCursoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package serviciocurso;

public class ServicioCursoServiceLocator extends org.apache.axis.client.Service implements serviciocurso.ServicioCursoService {

    public ServicioCursoServiceLocator() {
    }


    public ServicioCursoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicioCursoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioCurso
    private java.lang.String ServicioCurso_address = "http://localhost:8080/ServicioTrabajoAplicado/services/ServicioCurso";

    public java.lang.String getServicioCursoAddress() {
        return ServicioCurso_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioCursoWSDDServiceName = "ServicioCurso";

    public java.lang.String getServicioCursoWSDDServiceName() {
        return ServicioCursoWSDDServiceName;
    }

    public void setServicioCursoWSDDServiceName(java.lang.String name) {
        ServicioCursoWSDDServiceName = name;
    }

    public serviciocurso.ServicioCurso getServicioCurso() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioCurso_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioCurso(endpoint);
    }

    public serviciocurso.ServicioCurso getServicioCurso(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            serviciocurso.ServicioCursoSoapBindingStub _stub = new serviciocurso.ServicioCursoSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicioCursoWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioCursoEndpointAddress(java.lang.String address) {
        ServicioCurso_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (serviciocurso.ServicioCurso.class.isAssignableFrom(serviceEndpointInterface)) {
                serviciocurso.ServicioCursoSoapBindingStub _stub = new serviciocurso.ServicioCursoSoapBindingStub(new java.net.URL(ServicioCurso_address), this);
                _stub.setPortName(getServicioCursoWSDDServiceName());
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
        if ("ServicioCurso".equals(inputPortName)) {
            return getServicioCurso();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://serviciocurso", "ServicioCursoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://serviciocurso", "ServicioCurso"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioCurso".equals(portName)) {
            setServicioCursoEndpointAddress(address);
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
