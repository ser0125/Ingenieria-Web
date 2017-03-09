package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.udea.iw.exception.MyException;

/**
 * 
 * @author sergio.llanos
 *
 */

public class DataSource {
	
 //Funcion estatica que crea un objeto de tipo connection
	//y lanza la clase MyException
	//El throws esta diciendo que el metodo que lo utilice debe mandar esta excepcion
	//getConnection() es un metodo de la clase Connection
	public static Connection getConnection() throws MyException{
		Connection con=null;   //Creamos la conexión con la BD
	try{
		Class.forName("com.mysql.jdbc.Driver"); //Cargar el driver de la BD
		con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/camiloClase","root","root");//Creamos la conexión a la BD 
			}catch(ClassNotFoundException e){
				//En un nuevo hilo se va a manejar esta excepcion
				throw new MyException("Driver no encontrado", e);
			}catch(SQLException e){
				throw new MyException("No puede establecer conexión", e);
			}
	return con;
		
	}
	
}
