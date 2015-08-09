/**
 * ServicioMensualidadServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package serviciomensualidad;

public class ServicioMensualidadServiceLocator extends org.apache.axis.client.Service implements serviciomensualidad.ServicioMensualidadService {

    public ServicioMensualidadServiceLocator() {
    }


    public ServicioMensualidadServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicioMensualidadServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioMensualidad
    private java.lang.String ServicioMensualidad_address = "http://localhost:8080/ServicioTrabajoAplicado/services/ServicioMensualidad";

    public java.lang.String getServicioMensualidadAddress() {
        return ServicioMensualidad_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioMensualidadWSDDServiceName = "ServicioMensualidad";

    public java.lang.String getServicioMensualidadWSDDServiceName() {
        return ServicioMensualidadWSDDServiceName;
    }

    public void setServicioMensualidadWSDDServiceName(java.lang.String name) {
        ServicioMensualidadWSDDServiceName = name;
    }

    public serviciomensualidad.ServicioMensualidad getServicioMensualidad() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioMensualidad_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioMensualidad(endpoint);
    }

    public serviciomensualidad.ServicioMensualidad getServicioMensualidad(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            serviciomensualidad.ServicioMensualidadSoapBindingStub _stub = new serviciomensualidad.ServicioMensualidadSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicioMensualidadWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioMensualidadEndpointAddress(java.lang.String address) {
        ServicioMensualidad_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (serviciomensualidad.ServicioMensualidad.class.isAssignableFrom(serviceEndpointInterface)) {
                serviciomensualidad.ServicioMensualidadSoapBindingStub _stub = new serviciomensualidad.ServicioMensualidadSoapBindingStub(new java.net.URL(ServicioMensualidad_address), this);
                _stub.setPortName(getServicioMensualidadWSDDServiceName());
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
        if ("ServicioMensualidad".equals(inputPortName)) {
            return getServicioMensualidad();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://serviciomensualidad", "ServicioMensualidadService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://serviciomensualidad", "ServicioMensualidad"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioMensualidad".equals(portName)) {
            setServicioMensualidadEndpointAddress(address);
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
