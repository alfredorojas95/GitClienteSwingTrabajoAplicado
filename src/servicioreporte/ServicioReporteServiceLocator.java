/**
 * ServicioReporteServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servicioreporte;

public class ServicioReporteServiceLocator extends org.apache.axis.client.Service implements servicioreporte.ServicioReporteService {

    public ServicioReporteServiceLocator() {
    }


    public ServicioReporteServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicioReporteServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioReporte
    private java.lang.String ServicioReporte_address = "http://localhost:8080/ServicioTrabajoAplicado/services/ServicioReporte";

    public java.lang.String getServicioReporteAddress() {
        return ServicioReporte_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioReporteWSDDServiceName = "ServicioReporte";

    public java.lang.String getServicioReporteWSDDServiceName() {
        return ServicioReporteWSDDServiceName;
    }

    public void setServicioReporteWSDDServiceName(java.lang.String name) {
        ServicioReporteWSDDServiceName = name;
    }

    public servicioreporte.ServicioReporte getServicioReporte() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioReporte_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioReporte(endpoint);
    }

    public servicioreporte.ServicioReporte getServicioReporte(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            servicioreporte.ServicioReporteSoapBindingStub _stub = new servicioreporte.ServicioReporteSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicioReporteWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioReporteEndpointAddress(java.lang.String address) {
        ServicioReporte_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (servicioreporte.ServicioReporte.class.isAssignableFrom(serviceEndpointInterface)) {
                servicioreporte.ServicioReporteSoapBindingStub _stub = new servicioreporte.ServicioReporteSoapBindingStub(new java.net.URL(ServicioReporte_address), this);
                _stub.setPortName(getServicioReporteWSDDServiceName());
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
        if ("ServicioReporte".equals(inputPortName)) {
            return getServicioReporte();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servicioreporte", "ServicioReporteService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servicioreporte", "ServicioReporte"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioReporte".equals(portName)) {
            setServicioReporteEndpointAddress(address);
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
