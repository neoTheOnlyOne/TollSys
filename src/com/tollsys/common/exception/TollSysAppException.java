package com.tollsys.common.exception;

public class TollSysAppException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TollSysAppException() {
		
	}
	
	public TollSysAppException(String msg) {
		super(msg);
	}
	
	public TollSysAppException(Throwable cause) {
		super(cause);
	}
	
	public TollSysAppException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
