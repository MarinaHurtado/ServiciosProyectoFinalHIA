package clteservicioalmacen;

import java.util.Arrays;

/**
 *
 * @author CASSANDRA
 */
public class Estadisticas {
    public long sumaNormal, sumaCuadrados;
    public long minTiempo, maxTiempo;
    private long[] consultas;
    private int contador;
    
    public Estadisticas(int numConsultas){
        sumaNormal = sumaCuadrados = 0;
        minTiempo = maxTiempo = 0;
        contador = 0;
        consultas = new long[numConsultas];
    }
    
    public void sumasCliente(long tmpInicial, long tmpFinal){
        long diferencia = tmpFinal - tmpInicial;
        
        consultas[contador] = diferencia;
        contador++;
        if (contador == consultas.length)
            minMaxTiempos();
        
        sumaNormal += diferencia;
        long cuad = (long) Math.pow(diferencia, 2);
        sumaCuadrados += cuad;
    }
    
    private void minMaxTiempos(){
        Arrays.sort(consultas);
        minTiempo = consultas[0];
        maxTiempo = consultas[contador-1];
    }
    
    public void imprimeInfoClte(){
        System.out.println("Num transacciones: "+consultas.length
                +"\nSuma tiempos: "+sumaNormal
                +"\nSuma cuadrada de tiempos: "+sumaCuadrados
                +"\nMenor tiempo: "+minTiempo
                +"\nMayor tiempo: "+maxTiempo);
    }
}
