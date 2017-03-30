package co.edu.udea.iw.dao.impl.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dao.impl.ClienteDAOImpl;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyException;

public class ClienteDAOImplTest {

	@Test
	public void testObtener() {
		ClienteDAO clienteDAO = null;
		List<Cliente> resultado = null;
		
		try {
			clienteDAO = new ClienteDAOImpl();
			resultado = clienteDAO.obtener();
			
			for(Cliente cliente: resultado) {
				System.out.println(new StringBuffer(cliente.getNombres()).append(cliente.getApellidos()));
			}
			
			assertTrue(resultado.size() > 0);
		} catch(MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
