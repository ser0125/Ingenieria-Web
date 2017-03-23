/**
 * 
 */
package co.edu.udea.iw.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * @author sergio.llanos
 *
 */
public class UsuarioDAOImpl implements UsuarioDAO {

	//Met
	public Usuario obtener(String login) throws MyException{
	Usuario usuario=null;
	Session session=null;
	try{
		session=DataSource.getInstance().getSession();
   
		usuario=(Usuario)session.get(Usuario.class,login);
		
		
	
	}catch(HibernateException e){
		throw new MyException("Error consultando la ciudad",e);
	}
	return usuario;
	}
	
}
