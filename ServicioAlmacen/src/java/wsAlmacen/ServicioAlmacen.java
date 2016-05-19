package wsAlmacen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author labdismov
 */
@WebService(serviceName = "ServicioAlmacen")
public class ServicioAlmacen {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
	return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     * Checamos si en el almacén se tiene la cantidad requerida.
     * Si sí, disminuimos temporalmente la cantidad disponible.
     * Si no, regresamos que no se puede.
     */
    @WebMethod(operationName = "checaDispProd")
    public boolean checaDispProd(@WebParam(name = "nomProd") String nomProd, @WebParam(name = "cantReq") int cantReq) {
	try {
	    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	    Connection conn=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/labdismov/Documents/TiendaOnline.accdb");
	    Statement s = conn.createStatement();
	    ResultSet rs = s.executeQuery("SELECT [CantProd] FROM [Producto] WHERE Producto.NomProd='"+ nomProd +"';");
	    while (rs.next()) {
		int cantDisp = rs.getInt(1);
		System.out.println("Cant disp de " + nomProd + ": " + cantDisp);
		if(cantDisp>=cantReq){
		    int temp = cantDisp-cantReq;
		    s.executeUpdate("UPDATE [PRODUCTO] SET [CantProd]="+temp+" WHERE Producto.NomProd='"+nomProd+"';");
		    s.close();
		    System.out.println("Se actualizó la base de datos!");
		    conn.commit();
		    conn.close();
		    return true;
		}conn.close();
	    }
	} catch(SQLException e) {
	    System.out.println("Error al acceder a la BD...");
	    return false;
	} catch (ClassNotFoundException ex) {
	    System.out.println("Error en la clase");
	    return false;
	}
	return false;
    }

    /**
     * Web service operation
     * Regresamos la cantidad requerida disminuida temporalmente.
     */
    @WebMethod(operationName = "regresaCantProd")
    public boolean regresaCantProd(@WebParam(name = "nomProd") String nomProd, @WebParam(name = "cantProd") int cantProd) {
	try {
	    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	    Connection conn=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/labdismov/Documents/TiendaOnline.accdb");
	    Statement s = conn.createStatement();
	    ResultSet rs = s.executeQuery("SELECT [CantProd] FROM [Producto] WHERE Producto.NomProd='"+ nomProd +"';");
	    while (rs.next()) {
		int cantDisp = rs.getInt(1);
		System.out.println("Cant disp de " + nomProd + ": " + cantDisp);
		int temp = cantDisp+cantProd;
		s.executeUpdate("UPDATE [PRODUCTO] SET [CantProd]="+temp+" WHERE Producto.NomProd='"+nomProd+"';");
		s.close();
		System.out.println("Se actualizó la base de datos!");
		conn.commit();
		conn.close();
		return true;		
	    }
	} catch(SQLException e) {
	    System.out.println("Error al acceder a la BD...");
	    return false;
	} catch (ClassNotFoundException ex) {
	    System.out.println("Error en la clase");
	    return false;
	}
	return false;
    }
    
}
