import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Se cre ala clase
public class EjemploDB {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		consultarCiudades();
		
	}
	
	//Se define un método 
	public static  void consultarCiudades()
	{
		Connection con=null;   //Creamos la conexión con la BD
		PreparedStatement ps =null; //Realizamos la consulta
		ResultSet rs =null; //Contiene los datos obtenidos de la consulta realizada
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); //Cargar el driver de la BD
				
			con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/camiloClase","root","root");//Creamos la conexión a la BD 
			ps = con.prepareStatement("select * from ciudades");
			rs = ps.executeQuery();
			
			while(rs.next())  //iterar datos traidos, retorna false cuando se dejan de traer datos
			{
				System.out.println(rs.getString("codigo")+ ":" + rs.getString("Nombre"));
			}
		}
		catch(ClassNotFoundException e) //Puede que al llamar ese driver la clase no exita
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		//Cerrar las conexiones de la BD en el orden contrario a como se abrieron
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
