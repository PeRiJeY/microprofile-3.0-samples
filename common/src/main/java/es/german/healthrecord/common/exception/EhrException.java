package es.german.healthrecord.common.exception;

public class EhrException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -152278431947744484L;

	public EhrException() {
		super();
	}
	
	public EhrException(String message) {
		super(message);
	}
	
	public EhrException(String message, Throwable cause) {
		super(message, cause);
	}
}
