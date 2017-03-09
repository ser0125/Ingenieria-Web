/**
 * 
 */
package co.edu.udea.iw.dao;
import java.util.List;

import co.edu.udea.iw.dto.Ciudades;
import co.edu.udea.iw.exception.MyException;

/**
 * @author sergio.llanos
 *
 */
public interface CiudadDAO {
	
	/*Nos entrega la lista de las ciudades*/
	public List<Ciudades> obtener() throws MyException ;
	
}

