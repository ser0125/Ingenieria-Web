package co.edu.udea.iw.dao.imp;
/**
 * @author sergio.llanos
 * @version 1.0
 */
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

public class CiudadDAOImpTest {

	@Test
	//Prueba que se realiza para demostrar que la lista retorna al menos 1 elemento
	public void testObtener() {
		CiudadDAO ciudadDAO = null; //Se crea el objeto ciudadDao
		List <Ciudad> ciudades = null; //Se crea la lista de ciudades
		try{
			ciudadDAO = new CiudadDAOImp();
			ciudades = ciudadDAO.obtener(); //Con este metodo se obtienen las ciudades
			assertTrue(ciudades.size()>0);   //Con este metodo verificamos nuestra prueba
			
		}
		catch(MyException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	//Prueba que se realiza para demostrar que se puede retornar una ciudad especifica
	public void testObtenerLong() {
		CiudadDAO ciudadDAO = null;
		Ciudad ciudad = null;
		try
		{
			ciudadDAO = new CiudadDAOImp();
			ciudad = ciudadDAO.obtener(1l); //Con este metodo mandamos de parametro el codigo 1
			//Como mandamos el 1 deberia retornar con el metodo getNombre Medellin
			assertEquals(ciudad.getNombre(),"Medellin");
		}
		catch(MyException e)
		{
			fail(e.getMessage());
		}
	}

}
