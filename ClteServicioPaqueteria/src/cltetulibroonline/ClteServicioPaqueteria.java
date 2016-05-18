package cltetulibroonline;

import java.util.Random;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.Dispatch;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Service;
import java.io.StringReader;

/**
 *
 * @author CassPratt
 */
public class ClteServicioPaqueteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        long t0 = 0, t1 = 0, t2 = 0;
        long dtc = 0, dtcMax = 0, dtcMin = 0;
        long sx = 0, sx2 = 0;
        long deltaT1 = 0;
        int iMax = 0, iMin = 0;
        
        double prom = 0;
        double desvStd = 0;
        
        int n = 10; // número de transacciones
        
        // Conexión solamente la primera vez
        t0 = System.currentTimeMillis();
	wsPaqueteria.ServicioPaqueteria_Service service = new wsPaqueteria.ServicioPaqueteria_Service();
	wsPaqueteria.ServicioPaqueteria port = service.getServicioPaqueteriaPort();
        t1 =System.currentTimeMillis();
        
        deltaT1 = (t1 - t0);   // milisegundos
        
        String empresa = "TienditaChafa";
        Random r = new Random();
        int numAut = r.nextInt(1000)+1;
        
        for(int i=0; i<n; i++){
            t0 = System.nanoTime();
            String res = enviarProducto2(empresa, numAut, port);
            dtc = System.nanoTime() - t0;
        
            sx += dtc;
            sx2 += dtc * dtc;
            
            if (i == 0){
                dtcMin = dtc;
                dtcMax = dtc;
                iMax = i;
                iMin = i;
            } else {
                if (dtc < dtcMin){ dtcMin = dtc; iMin = i; }
                if (dtc > dtcMax){ dtcMax = dtc; iMax = i; }
            }
//            System.out.println(res);
        }
        
        t2 = System.currentTimeMillis();
        // Cálculo de tiempo promedio de ciclo
        prom    = ((double)sx)/n;   // en nanosegundos
        desvStd = Math.sqrt(sx2 - n*prom*prom);  // en nanosegundos
        
        // Reporte
        System.out.println("Creación de la conexión: " + deltaT1 + " seg");
        System.out.println("Para " + n + " veces, \n\tdeltaT promedio: \t" + prom + " nanoSeg" +
                            "\n\t\tdesvStd: \t" + desvStd + " nanoSeg");
        System.out.println("Tiempo de ciclo máximo: \t" + dtcMax + " nanoSeg\n" + 
                           "Tiempo de ciclo mínimo: \t" + dtcMin + " nanoSeg");
        System.out.println("\nEl máximo ocurrió en la iteración " + iMax);
        System.out.println("El mínimo ocurrió en la iteración " + iMin);
    }

    private static String enviarProducto1(java.lang.String empresa, int numAut) {
	wsPaqueteria.ServicioPaqueteria_Service service = new wsPaqueteria.ServicioPaqueteria_Service();
	wsPaqueteria.ServicioPaqueteria port = service.getServicioPaqueteriaPort();
	return port.enviarProducto(empresa, numAut);
    }
    
    private static String enviarProducto2(java.lang.String empresa, int numAut, wsPaqueteria.ServicioPaqueteria port) {
	return port.enviarProducto(empresa, numAut);
    }
}
