/**
 * 
 */
package co.edu.udea.iw.exception;

import org.apache.log4j.Logger;

/**
 * @author sergio.llanos
 *
 */
public class MyException extends Exception {

	Logger log =Logger.getLogger(this.getClass());
	
	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MyException(String message, Throwable cause) {
		super(message, cause);
		log.error(message,cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public MyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public MyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public MyException() {
		// TODO Auto-generated constructor stub
	}
	

}
