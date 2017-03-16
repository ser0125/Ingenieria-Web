package co.edu.udea.iw.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.edu.udea.iw.exception.MyException;

/**
 * 
 * @author sergio.llanos
 * @version 1.0
 */
public class DataSource {
	
	//Atributo privado que solo se va a instanciar 1 vez
	private static DataSource instancia;
	
	// Es una fabrica de sessiones que tiene una lista de sessiones
	private SessionFactory factory=null;
	
	//Clase que sirve para cargar el archivo de configuraciones
	private Configuration conf=new Configuration();
	
	/*Para utilizar el patron de diseño singleton
	se necesita un constructor privado*/
	private DataSource(){	
	}
	
	//Metodo que va a instanciar 1 vez el 
	//atributo que se va a usar 
	public static DataSource getInstance(){
		if(instancia==null)
			instancia= new DataSource();
		
		return instancia;
	}
	//Metodo que nos entrega un objeto tipo session
	//Sesiones que este activas en la base de datos
	public Session getSession() throws MyException{
		try{
		if(factory==null){
			conf.configure("co/edu/udea/iw/configuracion/hibernate.cfg.xml");
			factory=conf.buildSessionFactory();
		}
		
		return factory.openSession();
		}catch(HibernateException e){
			throw new MyException("Error configurando la session",e);
		}
	}
}
