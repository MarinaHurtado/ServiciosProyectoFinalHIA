
package wsestadisticas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para datosClientes complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="datosClientes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="servicio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sumaNormal" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sumaCuadrados" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="minDeltaTiempo" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="maxDeltaTiempo" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="numTransacciones" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosClientes", propOrder = {
    "servicio",
    "sumaNormal",
    "sumaCuadrados",
    "minDeltaTiempo",
    "maxDeltaTiempo",
    "numTransacciones"
})
public class DatosClientes {

    protected int servicio;
    protected long sumaNormal;
    protected long sumaCuadrados;
    protected long minDeltaTiempo;
    protected long maxDeltaTiempo;
    protected int numTransacciones;

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

    /**
     * Obtiene el valor de la propiedad sumaNormal.
     * 
     */
    public long getSumaNormal() {
        return sumaNormal;
    }

    /**
     * Define el valor de la propiedad sumaNormal.
     * 
     */
    public void setSumaNormal(long value) {
        this.sumaNormal = value;
    }

    /**
     * Obtiene el valor de la propiedad sumaCuadrados.
     * 
     */
    public long getSumaCuadrados() {
        return sumaCuadrados;
    }

    /**
     * Define el valor de la propiedad sumaCuadrados.
     * 
     */
    public void setSumaCuadrados(long value) {
        this.sumaCuadrados = value;
    }

    /**
     * Obtiene el valor de la propiedad minDeltaTiempo.
     * 
     */
    public long getMinDeltaTiempo() {
        return minDeltaTiempo;
    }

    /**
     * Define el valor de la propiedad minDeltaTiempo.
     * 
     */
    public void setMinDeltaTiempo(long value) {
        this.minDeltaTiempo = value;
    }

    /**
     * Obtiene el valor de la propiedad maxDeltaTiempo.
     * 
     */
    public long getMaxDeltaTiempo() {
        return maxDeltaTiempo;
    }

    /**
     * Define el valor de la propiedad maxDeltaTiempo.
     * 
     */
    public void setMaxDeltaTiempo(long value) {
        this.maxDeltaTiempo = value;
    }

    /**
     * Obtiene el valor de la propiedad numTransacciones.
     * 
     */
    public int getNumTransacciones() {
        return numTransacciones;
    }

    /**
     * Define el valor de la propiedad numTransacciones.
     * 
     */
    public void setNumTransacciones(int value) {
        this.numTransacciones = value;
    }

}
