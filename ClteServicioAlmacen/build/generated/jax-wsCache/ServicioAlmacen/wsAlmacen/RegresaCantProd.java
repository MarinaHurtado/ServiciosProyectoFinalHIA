
package wsAlmacen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para regresaCantProd complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="regresaCantProd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nomProd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cantProd" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "regresaCantProd", propOrder = {
    "nomProd",
    "cantProd"
})
public class RegresaCantProd {

    protected String nomProd;
    protected int cantProd;

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
     * Obtiene el valor de la propiedad cantProd.
     * 
     */
    public int getCantProd() {
        return cantProd;
    }

    /**
     * Define el valor de la propiedad cantProd.
     * 
     */
    public void setCantProd(int value) {
        this.cantProd = value;
    }

}
