package cltetiendaonline;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author labdismov
 */
public class ClteTiendaOnline {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	
	Estadisticas stad;
	long t0 = 0, t1 = 0;
	long dtc = 0;
	long deltaT1 = 0;
	int soyCliente;
	
	soyCliente = quienSoy(2);
        int n = 10; // número de transacciones
	stad = new Estadisticas(n);
	
        long deltaTAlInicioEnMillis = lapsoAlInicioEnMillis();
        System.out.println("Clte: " + soyCliente + ", dormiré " + 
                deltaTAlInicioEnMillis + " milisegundos."); 

	try {
	    Thread.currentThread().sleep(deltaTAlInicioEnMillis);
	} catch (InterruptedException ex) {
	    Logger.getLogger(ClteTiendaOnline.class.getName()).log(Level.SEVERE, null, ex);
	}

	String[] productos = {"Leche","Frijol","Garbanzos","Mayonesa","Avena",
				"Mermelada", "Gomitas Mango", "Corn Flakes", "Pan Blanco"};
	int[] precioUnidad = {16,24,14,24,30,41,15,43,28};
	String idCliente = "Clte12345";
	int unidades;
	
	Random rn = new Random();
	int prodRn = rn.nextInt(productos.length);
	unidades = rn.nextInt(200)+1;
	
//	System.out.println(productos[prodRn]);
//	System.out.println(""+precioUnidad[prodRn]);
//	System.out.println(""+unidades);
	
	 // Conexión solamente la primera vez
        t0 = System.currentTimeMillis();
	wsTiendaOnline.TiendaOnlineWSDLService service = new wsTiendaOnline.TiendaOnlineWSDLService();
	wsTiendaOnline.TiendaOnlineWSDLPortType port = service.getTiendaOnlineWSDLPort();
        t1 =System.currentTimeMillis();
	
	deltaT1 = (t1 - t0);   // milisegundos
	
	for(int i=0; i<n; i++){
            t0 = System.nanoTime();
            String res = tiendaOnlineWSDLOperation(productos[prodRn], idCliente, unidades, precioUnidad[prodRn],port);
            dtc = System.nanoTime();
	    
	    stad.sumasCliente(t0,dtc);
        }
	
	stad.imprimeInfoClte();
        datosClientes(2,stad.sumaNormal,stad.sumaCuadrados,stad.minTiempo,stad.maxTiempo,n);
	
//	System.out.println(res);
    }

    private static String tiendaOnlineWSDLOperation(java.lang.String producto, java.lang.String idCliente, int unidades, int precioUnidad) {
	wsTiendaOnline.TiendaOnlineWSDLService service = new wsTiendaOnline.TiendaOnlineWSDLService();
	wsTiendaOnline.TiendaOnlineWSDLPortType port = service.getTiendaOnlineWSDLPort();
	return port.tiendaOnlineWSDLOperation(producto, idCliente, unidades, precioUnidad);
    }
    
    private static String tiendaOnlineWSDLOperation(java.lang.String producto, java.lang.String idCliente, int unidades, int precioUnidad, wsTiendaOnline.TiendaOnlineWSDLPortType port) {
	return port.tiendaOnlineWSDLOperation(producto, idCliente, unidades, precioUnidad);
    }

    private static void datosClientes(int servicio, long sumaNormal, long sumaCuadrados, long minDeltaTiempo, long maxDeltaTiempo, int numTransacciones) {
	wsEstadisticas.ServicioEstadisticas_Service service = new wsEstadisticas.ServicioEstadisticas_Service();
	wsEstadisticas.ServicioEstadisticas port = service.getServicioEstadisticasPort();
	port.datosClientes(servicio, sumaNormal, sumaCuadrados, minDeltaTiempo, maxDeltaTiempo, numTransacciones);
    }

    private static int quienSoy(int servicio) {
	wsEstadisticas.ServicioEstadisticas_Service service = new wsEstadisticas.ServicioEstadisticas_Service();
	wsEstadisticas.ServicioEstadisticas port = service.getServicioEstadisticasPort();
	return port.quienSoy(servicio);
    }

    private static long lapsoAlInicioEnMillis() {
	wsEstadisticas.ServicioEstadisticas_Service service = new wsEstadisticas.ServicioEstadisticas_Service();
	wsEstadisticas.ServicioEstadisticas port = service.getServicioEstadisticasPort();
	return port.lapsoAlInicioEnMillis();
    }
    
}
