package cltetulibroonline;

import java.util.Random;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.Dispatch;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Service;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	int soyCliente = 0;
	Estadisticas stad;
        
        double prom = 0;
        double desvStd = 0;
        
	soyCliente = quienSoy(2);
        int n = 10; // número de transacciones
	stad = new Estadisticas(n);
	
        long deltaTAlInicioEnMillis = lapsoAlInicioEnMillis();
        System.out.println("Clte: " + soyCliente + ", dormiré " + 
                deltaTAlInicioEnMillis + " milisegundos."); 
  
	try {
	    Thread.currentThread().sleep(deltaTAlInicioEnMillis);
	} catch (InterruptedException ex) {
	    Logger.getLogger(ClteServicioPaqueteria.class.getName()).log(Level.SEVERE, null, ex);
	}
        
        // Conexión solamente la primera vez
        t0 = System.currentTimeMillis();
	wsPaqueteria.ServicioPaqueteria_Service service = new wsPaqueteria.ServicioPaqueteria_Service();
	wsPaqueteria.ServicioPaqueteria port = service.getServicioPaqueteriaPort();
        t1 =System.currentTimeMillis();
        
        deltaT1 = (t1 - t0);   // milisegundos
        
        String empresa = "TienditaChafa";
	// Checamos si mandan nombre de empresa
	if (args.length > 0) {
	    empresa = args[0];
	}
        Random r = new Random();
        String numAut = ""+(r.nextInt(1000)+1);
        
        for(int i=0; i<n; i++){
            t0 = System.currentTimeMillis();
            String res = enviarProducto2(empresa, numAut, port);
            dtc = System.currentTimeMillis();
	    
	    stad.sumasCliente(t0,dtc);
        }
	
	stad.imprimeInfoClte();
        datosClientes(2,stad.sumaNormal,stad.sumaCuadrados,stad.minTiempo,stad.maxTiempo,n);
	
	try {
	    Thread.sleep(1000);
	} catch (InterruptedException ex) {
	    Logger.getLogger(ClteServicioPaqueteria.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    private static long lapsoAlInicioEnMillis() {
	wsestadisticas.ServicioEstadisticas_Service service = new wsestadisticas.ServicioEstadisticas_Service();
	wsestadisticas.ServicioEstadisticas port = service.getServicioEstadisticasPort();
	return port.lapsoAlInicioEnMillis();
    }

    private static String enviarProducto1(java.lang.String empresa, java.lang.String numAut) {
	wsPaqueteria.ServicioPaqueteria_Service service = new wsPaqueteria.ServicioPaqueteria_Service();
	wsPaqueteria.ServicioPaqueteria port = service.getServicioPaqueteriaPort();
	return port.enviarProducto(empresa, numAut);
    }
    
    private static String enviarProducto2(java.lang.String empresa, java.lang.String numAut, wsPaqueteria.ServicioPaqueteria port) {
	return port.enviarProducto(empresa, numAut);
    }

    private static void datosClientes(int servicio, long sumaNormal, long sumaCuadrados, long minDeltaTiempo, long maxDeltaTiempo, int numTransacciones) {
	wsestadisticas.ServicioEstadisticas_Service service = new wsestadisticas.ServicioEstadisticas_Service();
	wsestadisticas.ServicioEstadisticas port = service.getServicioEstadisticasPort();
	port.datosClientes(servicio, sumaNormal, sumaCuadrados, minDeltaTiempo, maxDeltaTiempo, numTransacciones);
    }

    private static int quienSoy(int servicio) {
	wsestadisticas.ServicioEstadisticas_Service service = new wsestadisticas.ServicioEstadisticas_Service();
	wsestadisticas.ServicioEstadisticas port = service.getServicioEstadisticasPort();
	return port.quienSoy(servicio);
    }
    
}
