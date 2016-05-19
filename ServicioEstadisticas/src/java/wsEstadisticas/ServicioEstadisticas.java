package wsEstadisticas;

import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author labdismov
 */
@WebService(serviceName = "ServicioEstadisticas")
public class ServicioEstadisticas {
    
    private static long aQueHoraEsElInicio;
    private static int[] cuantosVan;
    private static long[] sumaNormalCltes;
    private static long[] sumaCuadradosCltes;
    private static long[] minDeltaT, maxDeltaT;
    private static long[] minTpoCltes, maxTpoCltes;
    private static long[] numTotalTransacciones;
    
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     * @param lapsoEnSegundos
     * @return 
     */
    @WebMethod(operationName = "blnReset")
    public boolean blnReset(@WebParam(name = "lapsoEnSegundos") int lapsoEnSegundos) {
	aQueHoraEsElInicio = System.currentTimeMillis() + 1000 * lapsoEnSegundos;
	for (int i = 0; i < 3; i++) {
	    cuantosVan = new int[3];
	    sumaNormalCltes = new long[3];
	    minDeltaT= new long[3];
	    maxDeltaT= new long[3];
	    maxTpoCltes= new long[3];
	    minTpoCltes= new long[3];
	    sumaCuadradosCltes = new long[3];
	    numTotalTransacciones = new long[3];
	}
	for (int i = 0; i < 3; i++) {
	    cuantosVan[i] = 0;
	    sumaNormalCltes[i] = 0;
	    sumaCuadradosCltes[i] = 0;
	    minDeltaT[i] = -1000;
	    maxDeltaT[i] = -1000;
	    maxTpoCltes[i] = Long.MIN_VALUE;
	    minTpoCltes[i] = Long.MAX_VALUE;
	}
        return true;
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "quienSoy")
    public int quienSoy(@WebParam(name = "servicio") int servicio) {
        return ++cuantosVan[servicio];
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "lapsoAlInicioEnMillis")
    public long lapsoAlInicioEnMillis() {
        return aQueHoraEsElInicio - System.currentTimeMillis();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "datosClientes")
    @Oneway
    public void datosClientes(@WebParam(name = "servicio") int servicio, @WebParam(name = "sumaNormal") long sumaNormal, 
            @WebParam(name = "sumaCuadrados") long sumaCuadrados, @WebParam(name = "minDeltaTiempo") long minDeltaTiempo, 
            @WebParam(name = "maxDeltaTiempo") long maxDeltaTiempo, @WebParam(name = "numTransacciones") int numTransacciones) {
        sumaNormalCltes[servicio] += sumaNormal;
        sumaCuadradosCltes[servicio] += sumaCuadrados;
        numTotalTransacciones[servicio] += numTransacciones;
        peorEsNada(servicio,minDeltaTiempo,maxDeltaTiempo);
    }
    
    private void peorEsNada(int servicio, long minDelta, long maxDelta){
        if (minDelta < minTpoCltes[servicio]) {
            minTpoCltes[servicio] = minDelta;
        } 
        if (maxDelta > maxTpoCltes[servicio]) {
            maxTpoCltes[servicio] = maxDelta;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "resultadosEstadisticas")
    public String resultadosEstadisticas() {
        String resultado = "";
	
        try{
//	    for (int i = 0; i < 3; i++) {
	    int i = 2;
		double promedioCltes = (double)(sumaNormalCltes[i] / numTotalTransacciones[i]);
//		   resultado += "\nPromedio cltes: "+promedioCltes+"\n";
		double promMulNumTrans = (double)(Math.pow(promedioCltes, 2)*numTotalTransacciones[i]);
//		    resultado += "\nPromedio MulNumTrans: "+promMulNumTrans+"\n";
//		   resultado += "\nSuma Cuadrados: "+sumaCuadradosCltes[i]+"\n";
//		   resultado += "\nnumTotalTrans: "+numTotalTransacciones[i]+"\n";
		double desvEstCltes = (double)(Math.sqrt(sumaCuadradosCltes[i] - promMulNumTrans)/(numTotalTransacciones[i] - 1));
		resultado += "\nTotal clientes del servicio "+i+": "+cuantosVan[i]+"\nPromedio total: "+promedioCltes+" ms"
                                +"\nDesvEst total: "+desvEstCltes+" ms"
                                +"\nMinimo deltaT: "+minTpoCltes[i]+" ms\nMaximo deltaT: "+maxTpoCltes[i]+" ms\n";
		System.out.println(resultado);
//	    }
            
            return resultado;
        }catch (Exception e){
            System.out.println("Error al calcular.");
        }
        return resultado;
    }

}
