
package wsestadisticas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para quienSoy complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="quienSoy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="servicio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "quienSoy", propOrder = {
    "servicio"
})
public class QuienSoy {

    protected int servicio;

    /**
     * Obtiene el valor de la propiedad servicio.
     * 
     */
    public int getServicio() {
        return servicio;
    }

    /**
     * Define el valor de la propiedad servicio.
     * 
     */
    public void setServicio(int value) {
        this.servicio = value;
    }

}
