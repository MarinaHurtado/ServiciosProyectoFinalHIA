
package wsAlmacen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para checaDispProd complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="checaDispProd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nomProd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cantReq" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checaDispProd", propOrder = {
    "nomProd",
    "cantReq"
})
public class ChecaDispProd {

    protected String nomProd;
    protected int cantReq;

    /**
     * Obtiene el valor de la propiedad nomProd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomProd() {
        return nomProd;
    }

    /**
     * Define el valor de la propiedad nomProd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomProd(String value) {
        this.nomProd = value;
    }

    /**
     * Obtiene el valor de la propiedad cantReq.
     * 
     */
    public int getCantReq() {
        return cantReq;
    }

    /**
     * Define el valor de la propiedad cantReq.
     * 
     */
    public void setCantReq(int value) {
        this.cantReq = value;
    }

}
