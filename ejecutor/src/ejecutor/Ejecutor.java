
package ejecutor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class Ejecutor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
        
        int numCltes = 10;
	String servicio = "";
	if (args.length > 0) {
	    if (args[0].equals("1")) {
		servicio = "ClientePago_Estad";
	    } else if (args[0].equals("2")) {
		servicio = "ClteServicioPaqueteria_Estad";
	    } else {
		servicio = "ClteServicioAlmacen_Estad";
	    }
	    if (args.length > 1)    // Revisar si hay número de clientes
		numCltes = Integer.parseInt(args[1]);
	}
		
        for (int clte = 1; clte <= numCltes; clte++) {
            try {		
                //Ejecutar procesos al mismo tiempo (varias ventanas)
                Runtime.getRuntime().exec("cmd /c start java -jar " + servicio + ".jar");
		System.out.println("Iniciado el cliente " + clte +  " del servicio " + servicio);
            } catch (IOException ex) {
                Logger.getLogger(Ejecutor.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
        }    
    }

}
