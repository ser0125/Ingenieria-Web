package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.udea.iw.exception.MyException;

/**
 * 
 * @author sergio.llanos
 * @version 1.0
 */
public class DataSource {

	private static Connection connection; //Conexion con singleton
	
	//El throw es para lanzar hacia arriba la excepción
	public static Connection getConnection() throws MyException
	{
		try
		{ 
			if(connection == null || connection.isClosed())
			{
				//Cargamos el driver de la BD
				Class.forName("com.mysql.jdbc.Driver"); 
				// Conexión con la base de datos
			    connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Sergio","root","root");
			}
		}
		//Al llamar ese driver puede que la clase no exista
		catch(ClassNotFoundException e)
		{
			throw new MyException("Driver no encontrado",e);
		}
		catch(SQLException e)
		{
			throw new MyException("No se puede establecer conexiÃ³n",e);
		}
		
		return connection;
	}
}
