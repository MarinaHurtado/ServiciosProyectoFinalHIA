
package wsAlmacen;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsAlmacen package. 
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

    private final static QName _RegresaCantProdResponse_QNAME = new QName("http://wsAlmacen/", "regresaCantProdResponse");
    private final static QName _RegresaCantProd_QNAME = new QName("http://wsAlmacen/", "regresaCantProd");
    private final static QName _Hello_QNAME = new QName("http://wsAlmacen/", "hello");
    private final static QName _ChecaDispProd_QNAME = new QName("http://wsAlmacen/", "checaDispProd");
    private final static QName _HelloResponse_QNAME = new QName("http://wsAlmacen/", "helloResponse");
    private final static QName _ChecaDispProdResponse_QNAME = new QName("http://wsAlmacen/", "checaDispProdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsAlmacen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChecaDispProdResponse }
     * 
     */
    public ChecaDispProdResponse createChecaDispProdResponse() {
        return new ChecaDispProdResponse();
    }

    /**
     * Create an instance of {@link ChecaDispProd }
     * 
     */
    public ChecaDispProd createChecaDispProd() {
        return new ChecaDispProd();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link RegresaCantProd }
     * 
     */
    public RegresaCantProd createRegresaCantProd() {
        return new RegresaCantProd();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link RegresaCantProdResponse }
     * 
     */
    public RegresaCantProdResponse createRegresaCantProdResponse() {
        return new RegresaCantProdResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegresaCantProdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsAlmacen/", name = "regresaCantProdResponse")
    public JAXBElement<RegresaCantProdResponse> createRegresaCantProdResponse(RegresaCantProdResponse value) {
        return new JAXBElement<RegresaCantProdResponse>(_RegresaCantProdResponse_QNAME, RegresaCantProdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegresaCantProd }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsAlmacen/", name = "regresaCantProd")
    public JAXBElement<RegresaCantProd> createRegresaCantProd(RegresaCantProd value) {
        return new JAXBElement<RegresaCantProd>(_RegresaCantProd_QNAME, RegresaCantProd.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsAlmacen/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChecaDispProd }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsAlmacen/", name = "checaDispProd")
    public JAXBElement<ChecaDispProd> createChecaDispProd(ChecaDispProd value) {
        return new JAXBElement<ChecaDispProd>(_ChecaDispProd_QNAME, ChecaDispProd.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsAlmacen/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChecaDispProdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsAlmacen/", name = "checaDispProdResponse")
    public JAXBElement<ChecaDispProdResponse> createChecaDispProdResponse(ChecaDispProdResponse value) {
        return new JAXBElement<ChecaDispProdResponse>(_ChecaDispProdResponse_QNAME, ChecaDispProdResponse.class, null, value);
    }

}
