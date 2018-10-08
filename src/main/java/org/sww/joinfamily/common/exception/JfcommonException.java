package org.sww.joinfamily.common.exception ;

public class JfcommonException extends RuntimeException {
	
	private static final long	serialVersionUID	= -268693255844895883L ;
	
	private String						code ;
	
	public JfcommonException(String message) {
		super(message) ;
	}
	
	public JfcommonException(String message, String code) {
		super(message) ;
		setCode(code) ;
	}
	
	public JfcommonException(String message, Throwable cause) {
		super(message, cause) ;
	}
	
	public JfcommonException(String message, String code, Throwable cause) {
		super(message, cause) ;
		setCode(code) ;
	}
	
	public JfcommonException(Throwable cause) {
		super(cause) ;
	}
	
	public String getCode() {
		return code ;
	}
	
	public void setCode(String code) {
		this.code = code ;
	}
	
}
