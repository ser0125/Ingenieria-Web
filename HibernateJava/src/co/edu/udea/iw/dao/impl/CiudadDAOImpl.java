package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

public class CiudadDAOImpl implements CiudadDAO {

	public List<Ciudad> obtener() throws MyException{
		List<Ciudad> lista = new ArrayList<Ciudad>();
		Session session=null;
		try{
			session=DataSource.getInstance().getSession();
			Criteria criteria=session.createCriteria(Ciudad.class);
			lista= criteria.list();
		}catch (HibernateException e){
			throw new MyException("Error consultando ciudades", e);
		}
		return lista;
	}
	
	//Metodo que obtiene una ciudad por el codigo
	public Ciudad obtener(Long codigo) throws MyException{
	Ciudad ciudad=null;
	Session session=null;
	try{
		session=DataSource.getInstance().getSession();
        //Get retorna null cuando no encuentra los datos,
		//load retorna una excepcion cuando no lo encuentra
		ciudad=(Ciudad)session.get(Ciudad.class,codigo);
		
		//ciudad=(Ciudad)session.load(Ciudad.class, codigo);
		/* No es la mejor forma
		Criteria criteria=session.createCriteria(Ciudad.class);
		criteria.add(Restrictions.eq("codigo", codigo));
		ciudad=(Ciudad)criteria.uniqueResult();
		*/
	}catch(HibernateException e){
		throw new MyException("Error consultando la ciudad",e);
	}
	return ciudad;
	}
	
	@Override
	public void guardar(Ciudad ciudad) throws MyException{
		Transaction tx=null;
	Session session=null;
	try{
		session=DataSource.getInstance().getSession();
		tx=session.beginTransaction();
		session.save(ciudad);
		tx.commit();
	}catch(HibernateException e){
		throw new MyException("Error consultando ciudades",e);
	}
		
	}
}
