package clientepago;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LABDISMOV
 */
public class ClientePago {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long t0 = 0, t1 = 0, t2 = 0;
        long dtc = 0, dtcMax = 0, dtcMin = 0;
        long sx = 0, sx2 = 0;
        long deltaT1 = 0;
        int iMax = 0, iMin = 0;
	Estadisticas stad;
	int soyCliente;
        
        soyCliente = quienSoy(1);
        int n = 10; // número de transacciones
	stad = new Estadisticas(n);
	
        long deltaTAlInicioEnMillis = lapsoAlInicioEnMillis();
        System.out.println("Clte: " + soyCliente + ", dormiré " + 
                deltaTAlInicioEnMillis + " milisegundos."); 
  
	try {
	    Thread.currentThread().sleep(deltaTAlInicioEnMillis);
	} catch (InterruptedException ex) {
	    Logger.getLogger(ClientePago.class.getName()).log(Level.SEVERE, null, ex);
	}
        
        // Conexión solamente la primera vez
        t0 = System.currentTimeMillis();
        
	com.adictosaltrabajo.webservice.pasarelapago.ServicioPagoService service = new com.adictosaltrabajo.webservice.pasarelapago.ServicioPagoService();
        com.adictosaltrabajo.webservice.pasarelapago.ServicioPago port = service.getServicioPagoPort();
        
        t1 =System.currentTimeMillis();
        
        deltaT1 = (t1 - t0);   // milisegundos
        
        String idCliente = "idCliente";
        Random r = new Random();
        int pago = r.nextInt(1000)+1;
        
        for(int i=0; i<n; i++){
            t0 = System.nanoTime();
            String res = port.facturar(idCliente, pago);
            dtc = System.nanoTime();
	    
	    stad.sumasCliente(t0,dtc);
        }
        
        stad.imprimeInfoClte();
        datosClientes(1,stad.sumaNormal,stad.sumaCuadrados,stad.minTiempo,stad.maxTiempo,n);
    }

    private static String facturar(java.lang.String idCliente, int cuantia) {
        com.adictosaltrabajo.webservice.pasarelapago.ServicioPagoService service = new com.adictosaltrabajo.webservice.pasarelapago.ServicioPagoService();
        com.adictosaltrabajo.webservice.pasarelapago.ServicioPago port = service.getServicioPagoPort();
        return port.facturar(idCliente, cuantia);
    }

    private static void datosClientes(int servicio, long sumaNormal, long sumaCuadrados, long minDeltaTiempo, long maxDeltaTiempo, int numTransacciones) {
	wsPago.ServicioEstadisticas_Service service = new wsPago.ServicioEstadisticas_Service();
	wsPago.ServicioEstadisticas port = service.getServicioEstadisticasPort();
	port.datosClientes(servicio, sumaNormal, sumaCuadrados, minDeltaTiempo, maxDeltaTiempo, numTransacciones);
    }

    private static long lapsoAlInicioEnMillis() {
	wsPago.ServicioEstadisticas_Service service = new wsPago.ServicioEstadisticas_Service();
	wsPago.ServicioEstadisticas port = service.getServicioEstadisticasPort();
	return port.lapsoAlInicioEnMillis();
    }

    private static int quienSoy(int servicio) {
	wsPago.ServicioEstadisticas_Service service = new wsPago.ServicioEstadisticas_Service();
	wsPago.ServicioEstadisticas port = service.getServicioEstadisticasPort();
	return port.quienSoy(servicio);
    }
    
}
