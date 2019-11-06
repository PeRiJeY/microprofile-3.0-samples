package es.german.healthrecord.common.exception;

public class EhrMultipleResultsException extends EhrException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -152278431947744484L;

	public EhrMultipleResultsException() {
		super();
	}
	
	public EhrMultipleResultsException(String message) {
		super(message);
	}
	
	public EhrMultipleResultsException(String message, Throwable cause) {
		super(message, cause);
	}
}
