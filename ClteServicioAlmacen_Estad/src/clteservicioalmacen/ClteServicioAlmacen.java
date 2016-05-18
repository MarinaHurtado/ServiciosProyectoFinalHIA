/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clteservicioalmacen;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class ClteServicioAlmacen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            // TODO code application logic here
        
        long t0, t1, t2, dtc, sx, sx2, dtcMax = 0, dtcMin = 0;
        double deltaT1, deltaT2, prom, desvStd;
        String res;
        int i_max = 0, i_min = 0;
	int soyCliente;
	Estadisticas stad;
	
	soyCliente = quienSoy(0);
        int N = 10; // número de transacciones
	stad = new Estadisticas(N);
	
	long deltaTAlInicioEnMillis = lapsoAlInicioEnMillis();
        System.out.println("Clte: " + soyCliente + ", dormiré " + 
                deltaTAlInicioEnMillis + " milisegundos."); 
  
	try {
	    Thread.currentThread().sleep(deltaTAlInicioEnMillis);
	} catch (InterruptedException ex) {
	    Logger.getLogger(ClteServicioAlmacen.class.getName()).log(Level.SEVERE, null, ex);
	}
        
        //Creación de la conexión
        t0=System.currentTimeMillis();
                
        wsAlmacen.ServicioAlmacen_Service service = new wsAlmacen.ServicioAlmacen_Service();
        wsAlmacen.ServicioAlmacen port = service.getServicioAlmacenPort();
               
        t1=System.currentTimeMillis();
        deltaT1=(t1-t0); //en milisegundos
        sx=0;
        sx2=0;
        
        String nomProd = "Leche";
        int cantReq = 10;
        int cantProd = 0;
	
        for (int i=0; i<N; i++){
            t0=System.nanoTime();
            //res=port.helloWorldOperation("Gus");
            
            port.checaDispProd(nomProd, cantReq);
            port.regresaCantProd(nomProd, cantProd);
            
            dtc=System.nanoTime();
	    
	     stad.sumasCliente(t0,dtc);
        }
	
	stad.imprimeInfoClte();
        datosClientes(0,stad.sumaNormal,stad.sumaCuadrados,stad.minTiempo,stad.maxTiempo,N);	
    }

    private static boolean regresaCantProd(java.lang.String nomProd, int cantProd) {
        wsAlmacen.ServicioAlmacen_Service service = new wsAlmacen.ServicioAlmacen_Service();
        wsAlmacen.ServicioAlmacen port = service.getServicioAlmacenPort();
        return port.regresaCantProd(nomProd, cantProd);
    }

    private static void datosClientes(int servicio, long sumaNormal, long sumaCuadrados, long minDeltaTiempo, long maxDeltaTiempo, int numTransacciones) {
	wsestadisticas.ServicioEstadisticas_Service service = new wsestadisticas.ServicioEstadisticas_Service();
	wsestadisticas.ServicioEstadisticas port = service.getServicioEstadisticasPort();
	port.datosClientes(servicio, sumaNormal, sumaCuadrados, minDeltaTiempo, maxDeltaTiempo, numTransacciones);
    }

    private static long lapsoAlInicioEnMillis() {
	wsestadisticas.ServicioEstadisticas_Service service = new wsestadisticas.ServicioEstadisticas_Service();
	wsestadisticas.ServicioEstadisticas port = service.getServicioEstadisticasPort();
	return port.lapsoAlInicioEnMillis();
    }

    private static int quienSoy(int servicio) {
	wsestadisticas.ServicioEstadisticas_Service service = new wsestadisticas.ServicioEstadisticas_Service();
	wsestadisticas.ServicioEstadisticas port = service.getServicioEstadisticasPort();
	return port.quienSoy(servicio);
    }  
}