import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * @author sergio.llanos
 * @version 1.0
 * @description Clase que tiene el main de la aplicación, osea que al correrla se realizara lo que
 * tenga el main
 */
public class EjemploDB {
	
//Clase principal que realiza el metodo consultarciudades
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		//Se llama al metodo
		consultarCiudades();
		
	}
	
	/*Se define el metodo consultarCiudades() el cual cargara el driver y traera una consulta de 
	la base de datos*/
	public static  void consultarCiudades()
	{
		Connection con=null;   //Creamos un objeto connection
		PreparedStatement ps =null; //Creamos un objeto PreparedStatement
		ResultSet rs =null; //Creamos un objeto ResultSet
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); //Cargamos el driver de la BD
			//Creamos la conexión a la BD
			con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Sergio","root","root"); 
			ps = con.prepareStatement("select * from ciudades");//Realizamos la consulta
			rs = ps.executeQuery(); //Ejecutamos la consulta y la guardamos en ese objeto
			
			while(rs.next())  //Se van pasando los datos que se trajeron de la consulta
			{
				System.out.println(rs.getString("codigo")+ ":" + rs.getString("Nombre"));
			}
		}
		catch(ClassNotFoundException e) //Al llamar ese driver puede que la clase no exista
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		//Se cierran las conexiones de la BD en el orden contrario a como se abrieron
		finally{
			try{
				rs.close();
				ps.close();
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		
		
	}

}
