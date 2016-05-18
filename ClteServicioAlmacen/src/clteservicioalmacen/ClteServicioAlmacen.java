/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clteservicioalmacen;

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
        
        
        int N = 4;
        for (int i=0; i<N; i++){
            t0=System.nanoTime();
            //res=port.helloWorldOperation("Gus");
            
            port.checaDispProd(nomProd, cantReq);
            port.regresaCantProd(nomProd, cantProd);
            
            dtc=System.nanoTime()-t0;
            sx += dtc;
            sx2 += dtc*dtc;
            if(i==0)
            {
                dtcMin=dtc;
                dtcMax=dtc;
                i_max = i;
                i_min = i;
            }
            else{
                if(dtc < dtcMin)
                {
                    dtcMin = dtc;
                    i_min = i;
                }
                if(dtc > dtcMax)
                {
                    dtcMax = dtc;
                    i_max = i;
                }
            }
        }
        t2=System.currentTimeMillis();
        
        prom = ((double)sx)/N; //en nanoseg
        desvStd=Math.sqrt(sx2 - N*prom*prom); // en nanoseg
             
        //Reporte
            
        System.out.println("Creación de la  conexión: " + deltaT1 + " miliSeg");
        System.out.println("Para " + N +" veces");
        System.out.printf("Tiempo de ciclo promedio:      %15.4f nanoSeg\n",prom);
        System.out.printf("                 desvStd:      %15.4f nanoSeg\n",desvStd);        
        System.out.printf("Tiempo de ciclo   máximo: %15d nanoSeg\n",dtcMax);
        System.out.printf("Tiempo de ciclo   mínimo: %15d nanoSeg\n",dtcMin);
        System.out.println("El máximo ocurrió en la vez " + i_max);
        System.out.println("El mínimo ocurrió en la vez " + i_min);
        
    }

    private static boolean regresaCantProd(java.lang.String nomProd, int cantProd) {
        wsAlmacen.ServicioAlmacen_Service service = new wsAlmacen.ServicioAlmacen_Service();
        wsAlmacen.ServicioAlmacen port = service.getServicioAlmacenPort();
        return port.regresaCantProd(nomProd, cantProd);
    }
     
}