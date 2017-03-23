package co.edu.udea.iw.dao.impl.test;

import static org.junit.Assert.*;

import org.junit.Test;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dao.impl.CiudadDAOImpl;
import co.edu.udea.iw.dao.impl.UsuarioDAOImpl;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

public class UsuarioDaoImplTest {

	@Test
	public void testObtenerString() {
		UsuarioDAO usuarioDAO = null;
		Usuario usuario = null;
		try
		{
			usuarioDAO = new UsuarioDAOImpl();
			usuario = usuarioDAO.obtener("elver");
			assertEquals(usuario.getNombres(),"Elver");
		}
		catch(MyException e)
		{
			
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	

}
