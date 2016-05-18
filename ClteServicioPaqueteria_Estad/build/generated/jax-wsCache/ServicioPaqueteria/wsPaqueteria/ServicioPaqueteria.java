
package wsPaqueteria;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServicioPaqueteria", targetNamespace = "http://wsPaqueteria/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ServicioPaqueteria {


    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://wsPaqueteria/", className = "wsPaqueteria.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://wsPaqueteria/", className = "wsPaqueteria.HelloResponse")
    @Action(input = "http://wsPaqueteria/ServicioPaqueteria/helloRequest", output = "http://wsPaqueteria/ServicioPaqueteria/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @param numAut
     * @param empresa
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "enviarProducto", targetNamespace = "http://wsPaqueteria/", className = "wsPaqueteria.EnviarProducto")
    @ResponseWrapper(localName = "enviarProductoResponse", targetNamespace = "http://wsPaqueteria/", className = "wsPaqueteria.EnviarProductoResponse")
    @Action(input = "http://wsPaqueteria/ServicioPaqueteria/enviarProductoRequest", output = "http://wsPaqueteria/ServicioPaqueteria/enviarProductoResponse")
    public String enviarProducto(
        @WebParam(name = "empresa", targetNamespace = "")
        String empresa,
        @WebParam(name = "numAut", targetNamespace = "")
        String numAut);

}
