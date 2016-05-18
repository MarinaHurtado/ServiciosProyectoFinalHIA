package com.adictosaltrabajo.webservice.pasarelapago;

import java.util.Random;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Codigo perteneciente a: Tutorial de BPEL con OpenESB
 * @author www.adictosaltrabajo.com - Ivan Garcia Puebla
 * @version 1.0
 */
@WebService()
public class ServicioPago {

   /**
     * Operacion de un servicio web implementado con JAX-WS
     * que factura a un determinado cliente cierta cuantia.
     *
     * @param idCliente Identificador de un cliente
     * @param cuantia Cuantia a cobrar al cliente
     * @return Identificador de factura
     */
    @WebMethod(operationName = "facturar")
    public String facturar(@WebParam(name = "idCliente")
    String idCliente, @WebParam(name = "cuantia")
    int cuantia) {
        // Generamos un id de factura (num. autorización):
        Random rnd = new Random();
        return "NumAut. "+rnd.nextInt(10000);
	//return "Num. bhjklbgh";
    }

}
