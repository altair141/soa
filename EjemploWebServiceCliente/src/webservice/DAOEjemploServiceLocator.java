/**
 * DAOEjemploServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package webservice;

public class DAOEjemploServiceLocator extends org.apache.axis.client.Service implements webservice.DAOEjemploService {

    public DAOEjemploServiceLocator() {
    }


    public DAOEjemploServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DAOEjemploServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DAOEjemplo
    private java.lang.String DAOEjemplo_address = "http://localhost:8080/EjemploWebserviceProveedor/services/DAOEjemplo";

    public java.lang.String getDAOEjemploAddress() {
        return DAOEjemplo_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DAOEjemploWSDDServiceName = "DAOEjemplo";

    public java.lang.String getDAOEjemploWSDDServiceName() {
        return DAOEjemploWSDDServiceName;
    }

    public void setDAOEjemploWSDDServiceName(java.lang.String name) {
        DAOEjemploWSDDServiceName = name;
    }

    public webservice.DAOEjemplo getDAOEjemplo() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DAOEjemplo_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDAOEjemplo(endpoint);
    }

    public webservice.DAOEjemplo getDAOEjemplo(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            webservice.DAOEjemploSoapBindingStub _stub = new webservice.DAOEjemploSoapBindingStub(portAddress, this);
            _stub.setPortName(getDAOEjemploWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDAOEjemploEndpointAddress(java.lang.String address) {
        DAOEjemplo_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (webservice.DAOEjemplo.class.isAssignableFrom(serviceEndpointInterface)) {
                webservice.DAOEjemploSoapBindingStub _stub = new webservice.DAOEjemploSoapBindingStub(new java.net.URL(DAOEjemplo_address), this);
                _stub.setPortName(getDAOEjemploWSDDServiceName());
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
        if ("DAOEjemplo".equals(inputPortName)) {
            return getDAOEjemplo();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice", "DAOEjemploService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice", "DAOEjemplo"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DAOEjemplo".equals(portName)) {
            setDAOEjemploEndpointAddress(address);
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
