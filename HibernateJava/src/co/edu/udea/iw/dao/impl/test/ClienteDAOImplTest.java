package co.edu.udea.iw.dao.impl.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dao.impl.ClienteDAOImpl;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.dto.Usuario;
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
	
	@Test
	public void testGuardar(){
		
		Cliente cliente = null;
		ClienteDAO clienteDao = null;
		Usuario usuario = null;
		try{
			
			cliente = new Cliente();
			cliente.setCedula("123123");
			cliente.setNombres("Sergio Andres");
			cliente.setApellidos(" Llanos Garcia");
			cliente.setEmail("SergioAndres@gmail.com");
			
			
			usuario = new Usuario();
			usuario.setLogin("elver");
			cliente.setUsuarioCrea(usuario);
			cliente.setFechaCreacion(new Date(Calendar.getInstance().getTimeInMillis()));
			clienteDao = new ClienteDAOImpl();
			clienteDao.guardar(cliente);
		}catch(MyException e){
			e.printStackTrace();
			
		}
	}


}
