
package wsPaqueteria;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsPaqueteria package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EnviarProducto_QNAME = new QName("http://wsPaqueteria/", "enviarProducto");
    private final static QName _Hello_QNAME = new QName("http://wsPaqueteria/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://wsPaqueteria/", "helloResponse");
    private final static QName _EnviarProductoResponse_QNAME = new QName("http://wsPaqueteria/", "enviarProductoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsPaqueteria
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EnviarProductoResponse }
     * 
     */
    public EnviarProductoResponse createEnviarProductoResponse() {
        return new EnviarProductoResponse();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link EnviarProducto }
     * 
     */
    public EnviarProducto createEnviarProducto() {
        return new EnviarProducto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviarProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsPaqueteria/", name = "enviarProducto")
    public JAXBElement<EnviarProducto> createEnviarProducto(EnviarProducto value) {
        return new JAXBElement<EnviarProducto>(_EnviarProducto_QNAME, EnviarProducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsPaqueteria/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsPaqueteria/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviarProductoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsPaqueteria/", name = "enviarProductoResponse")
    public JAXBElement<EnviarProductoResponse> createEnviarProductoResponse(EnviarProductoResponse value) {
        return new JAXBElement<EnviarProductoResponse>(_EnviarProductoResponse_QNAME, EnviarProductoResponse.class, null, value);
    }

}
