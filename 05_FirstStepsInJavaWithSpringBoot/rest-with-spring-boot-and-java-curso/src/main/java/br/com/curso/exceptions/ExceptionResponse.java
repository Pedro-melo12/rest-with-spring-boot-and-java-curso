package br.com.curso.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date timesStamp;
	private String message;
	private String details;
	
	public ExceptionResponse(Date timesStamp2, String message2, String description) {
		this.timesStamp = timesStamp2;
		this.message = message2;
		this.details = description;
	}
	public Date getTimesStamp() {
		return timesStamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	
	
}
