/**
 * 
 */
package co.edu.udea.iw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Ciudades;
import co.edu.udea.iw.exception.MyException;

/**
 * @author sergio.llanos
 *
 */
public class CiudadDAOImp {

	/*Nos entrega la lista de las ciudades*/
	public List<Ciudades> obtener() throws MyException{ ;
	PreparedStatement ps =null; //Realizamos la consulta
	ResultSet rs =null; //Contiene los datos obtenidos de la consulta realizada
	Connection con=null;   //Creamos la conexión con la BD
	List<Ciudades> lista= new ArrayList<Ciudades>();
	try{
		con= DataSource.getConnection();	
		ps = con.prepareStatement("select * from ciudades");
		rs = ps.executeQuery();
		
		while(rs.next())  //iterar datos traidos, retorna false cuando se dejan de traer datos
		{
			Ciudades ciudad= new Ciudades();
			ciudad.setCodigo(rs.getLong("codigo"));
			ciudad.setNombre(rs.getString("Nombre"));
			ciudad.setCodigoArea(rs.getString("codigoArea"));
			lista.add(ciudad);
			
		}
	}catch(SQLException e){
		throw new MyException("Error consultando",e);
		
	}finally{
		try{
			if(rs!=null)
				rs.close();
			if(ps!=null)
				ps.close();
			if(con!=null)
				con.close();
			
		}catch(SQLException e){
		throw new MyException("Error cerrando",e);
		
	}
	}
	return lista;
	}
}
