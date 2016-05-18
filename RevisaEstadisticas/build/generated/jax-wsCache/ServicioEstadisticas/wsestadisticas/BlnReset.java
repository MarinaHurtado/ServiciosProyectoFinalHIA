
package wsestadisticas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para blnReset complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="blnReset">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lapsoEnSegundos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "blnReset", propOrder = {
    "lapsoEnSegundos"
})
public class BlnReset {

    protected int lapsoEnSegundos;

    /**
     * Obtiene el valor de la propiedad lapsoEnSegundos.
     * 
     */
    public int getLapsoEnSegundos() {
        return lapsoEnSegundos;
    }

    /**
     * Define el valor de la propiedad lapsoEnSegundos.
     * 
     */
    public void setLapsoEnSegundos(int value) {
        this.lapsoEnSegundos = value;
    }

}
