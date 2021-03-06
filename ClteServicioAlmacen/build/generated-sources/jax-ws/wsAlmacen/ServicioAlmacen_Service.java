
package wsAlmacen;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ServicioAlmacen", targetNamespace = "http://wsAlmacen/", wsdlLocation = "http://148.205.38.104:8080/ServicioAlmacen/ServicioAlmacen?WSDL")
public class ServicioAlmacen_Service
    extends Service
{

    private final static URL SERVICIOALMACEN_WSDL_LOCATION;
    private final static WebServiceException SERVICIOALMACEN_EXCEPTION;
    private final static QName SERVICIOALMACEN_QNAME = new QName("http://wsAlmacen/", "ServicioAlmacen");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://148.205.38.104:8080/ServicioAlmacen/ServicioAlmacen?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICIOALMACEN_WSDL_LOCATION = url;
        SERVICIOALMACEN_EXCEPTION = e;
    }

    public ServicioAlmacen_Service() {
        super(__getWsdlLocation(), SERVICIOALMACEN_QNAME);
    }

    public ServicioAlmacen_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICIOALMACEN_QNAME, features);
    }

    public ServicioAlmacen_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICIOALMACEN_QNAME);
    }

    public ServicioAlmacen_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICIOALMACEN_QNAME, features);
    }

    public ServicioAlmacen_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServicioAlmacen_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServicioAlmacen
     */
    @WebEndpoint(name = "ServicioAlmacenPort")
    public ServicioAlmacen getServicioAlmacenPort() {
        return super.getPort(new QName("http://wsAlmacen/", "ServicioAlmacenPort"), ServicioAlmacen.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicioAlmacen
     */
    @WebEndpoint(name = "ServicioAlmacenPort")
    public ServicioAlmacen getServicioAlmacenPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://wsAlmacen/", "ServicioAlmacenPort"), ServicioAlmacen.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICIOALMACEN_EXCEPTION!= null) {
            throw SERVICIOALMACEN_EXCEPTION;
        }
        return SERVICIOALMACEN_WSDL_LOCATION;
    }

}
