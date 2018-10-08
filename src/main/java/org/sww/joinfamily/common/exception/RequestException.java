package org.sww.joinfamily.common.exception ;

public class RequestException extends JfcommonException {
	
	public RequestException(String message) {
		super(message) ;
	}

	public RequestException(String message, Exception e) {
		super(message,e) ;
	}

	private static final long	serialVersionUID	= 403408793026937592L ;
	
}
