package revisaestadisticas;

/**
 *
 * @author labdismov
 */
public class RevisaEstadisticas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	if (args.length != 0) {
	    if (args[0].equals("1")) {
		blnReset(30);
		System.out.println("Tpo: "+lapsoAlInicioEnMillis());
	    } else {
		System.out.println(""+resultadosEstadisticas());
	    }
	}
    }

    private static boolean blnReset(int lapsoEnSegundos) {
	wsestadisticas.ServicioEstadisticas_Service service = new wsestadisticas.ServicioEstadisticas_Service();
	wsestadisticas.ServicioEstadisticas port = service.getServicioEstadisticasPort();
	return port.blnReset(lapsoEnSegundos);
    }

    private static long lapsoAlInicioEnMillis() {
	wsestadisticas.ServicioEstadisticas_Service service = new wsestadisticas.ServicioEstadisticas_Service();
	wsestadisticas.ServicioEstadisticas port = service.getServicioEstadisticasPort();
	return port.lapsoAlInicioEnMillis();
    }

    private static String resultadosEstadisticas() {
	wsestadisticas.ServicioEstadisticas_Service service = new wsestadisticas.ServicioEstadisticas_Service();
	wsestadisticas.ServicioEstadisticas port = service.getServicioEstadisticasPort();
	return port.resultadosEstadisticas();
    }
    
    
}
