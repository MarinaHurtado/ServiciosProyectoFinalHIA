package wsPaqueteria;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.Date;
import java.util.*;
import java.text.*;

/**
 *
 * @author labdismov
 */
@WebService(serviceName = "ServicioPaqueteria")
public class ServicioPaqueteria {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
	return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "enviarProducto")
    public String enviarProducto(@WebParam(name = "empresa") String empresa, @WebParam(name = "numAut")
    String numAut) {
	String fecha="";
	try{	    
	    if (empresa != null && numAut != null){
		Random rnd = new Random();
		int numEntrega = rnd.nextInt(1000)+1;
	
		Date dNow = new Date( );
		SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		fecha = "Num. Entrega: " + numEntrega + ", Fecha Aproximada de Entrega: " + ft.format(dNow);
		System.out.println(fecha);
		return fecha;
	    }	    
	    else
		fecha = "Datos incorrectos...";
	} catch(Exception e) {
	    fecha = "Introduzca datos...";
	    return fecha;
	}   
	return fecha;
    }
}

