/**
 * 
 */
package co.edu.udea.iw.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * @author sergio.llanos
 * @version 1.0
 */
public class CiudadDAOImp implements CiudadDAO{
	
	//Metodo que sirve para obtener una lista de ciudades
	public List<Ciudad> obtener() throws MyException{
		
		Connection con =null; ///Creamos un objeto connection
		PreparedStatement ps =null; //Creamos un objeto PreparedStatement
		ResultSet rs =null; //Creamos un objeto ResultSet
		
		List<Ciudad> ciudades =new ArrayList<>();
		try
		{
			con=DataSource.getConnection(); 	//Creamos la conexión a la BD
			ps=con.prepareStatement("select * from ciudades");
			rs = ps.executeQuery(); //Ejecutamos la consulta y la guardamos en ese objeto
			while(rs.next()) //Se van pasando los datos que se trajeron de la consulta
			{
				Ciudad ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("codigo")); //Se guarda el codigo de la ciudad
				ciudad.setNombre(rs.getString("nombre"));//Se guarda el nombre de la ciudad
				//Se guarda el codigo de area de la ciudad
				ciudad.setCodigoArea(rs.getString("codigoArea"));
				//se añade el objeto ciudad a la lista
				ciudades.add(ciudad);
			}
		}
		catch(SQLException  e)
		{
			throw new MyException("Error consultando", e);
		}
		//Se cierran las conexiones de la BD en el orden contrario a como se abrieron
		finally{
			
			try
			{
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
				if(con!=null)
					con.close();
			}
			catch(SQLException e)
			{
				throw new MyException("Error cerrando", e);
			}
		}
		return ciudades;
		
	}


	//Metodo que sirve para obtener una ciudad de acuerdo al parametro que mandamos
	public Ciudad obtener(Long codigo) throws MyException {
		// TODO Auto-generated method stub
		

		Connection con =null; ///Creamos un objeto connection
		PreparedStatement ps =null; //Creamos un objeto PreparedStatement
		ResultSet rs =null; //Creamos un objeto ResultSet
		Ciudad ciudad = new Ciudad(); 
		
		try
		{
			con=DataSource.getConnection();   //Creamos la conexión a la BD
			ps=con.prepareStatement("select * from ciudades where codigo = ?");
			ps.setLong(1, codigo); //Sirve para mandar el codigo evitando sql injection
			rs = ps.executeQuery(); //Ejecutamos la consulta y la guardamos en ese objeto
			if(rs.next())//Se van pasando los datos que se trajeron de la consulta
			{
				ciudad.setCodigo(rs.getLong("codigo")); //Se guarda el codigo
				ciudad.setNombre(rs.getString("nombre")); //Se guarda el nombre
				ciudad.setCodigoArea(rs.getString("codigoArea")); //se guarda el codigo de area
			}
		}
		catch(SQLException e)
		{
			throw new MyException("Error consultando", e);
		}
		finally{
			//Se cierran las conexiones de la BD en el orden contrario a como se abrieron
			try
			{
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
				if(con!=null)
					con.close();
			}
			catch(SQLException e)
			{
				throw new MyException("Error cerrando", e);
			}
		}
		return ciudad;
	}
}
