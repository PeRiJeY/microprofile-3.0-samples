package es.german.healthrecord.common.exception;

public class EhrNotFoundException extends EhrException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -152278431947744484L;

	public EhrNotFoundException() {
		super();
	}
	
	public EhrNotFoundException(String message) {
		super(message);
	}
	
	public EhrNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
