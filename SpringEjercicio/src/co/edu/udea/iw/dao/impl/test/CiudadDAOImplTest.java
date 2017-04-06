package co.edu.udea.iw.dao.impl.test;
/**
 * @author sergio.llanos
 * @version 1.0
 */
import static org.junit.Assert.*;

import java.util.List;

import javax.swing.Spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.impl.CiudadDAOImpl;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;
import javassist.ClassPath;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:SpringConfig.xml")
public class CiudadDAOImplTest {
	
	@Autowired
	private CiudadDAO ciudadDAO;
	
	@Test
	//Prueba que se realiza para demostrar que la lista retorna al menos 1 elemento
	public void testObtener() {
		List <Ciudad> ciudades = null; //Se crea la lista de ciudades
		try{
		
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
		Ciudad ciudad = null;
		try
		{
			ciudad = ciudadDAO.obtener(1l); //Con este metodo mandamos de parametro el codigo 1
			//Como mandamos el 1 deberia retornar con el metodo getNombre Medellin
			assertEquals(ciudad.getNombre(),"Medellin");
		}
		catch(MyException e)
		{
			
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	

}

